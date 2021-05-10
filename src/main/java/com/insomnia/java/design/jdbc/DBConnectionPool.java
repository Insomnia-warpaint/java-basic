package com.insomnia.java.design.jdbc;

import com.insomnia.java.util.JDBCUtils;
import com.insomnia.java.util.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

/**
 *
 */
public class DBConnectionPool extends Pool {

    private static final Logger LOG = LogManager.getLogger(DBConnectionPool.class);
    /**
     * 正在使用的连接数
     */
    private int checkedOut;


    /**
     * 存放生产的连接对象
     */
    private Vector<Connection> freeConnection = new Vector<Connection>();

    private String userName = null;


    private String password = null;

    private String url = null;
    /**
     *  空闲连接数
     */
    private static int num = 0;

    /**
     * 当前可用连接数
     */
    private static  int activeNum = 0;

    private static DBConnectionPool pool = null;

    public static synchronized DBConnectionPool getInstance() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (null == pool){
            Constructor<DBConnectionPool> constructor = (Constructor<DBConnectionPool>) Class.forName("com.insomnia.java.design.jdbc.DBConnectionPool").getDeclaredConstructor();
            constructor.setAccessible(true);
            pool = constructor.newInstance();
        }

        return pool;
    }

    @Override
    public void createPool() {
        pool = new DBConnectionPool();
        if (null != pool){
            LOG.info("create DBConnectionPool success!");
        }else{
            LOG.info("create DBConnectionPool fail!");
        }
    }

    /**
     * 获取一个可用连接
     * @return
     */
    @Override
    public synchronized Connection getConnection() {
        Connection connection = null;
        /**
         *  有空闲的连接
         */
        if (freeConnection.size() > 0){
            num--;
            connection = freeConnection.firstElement();
            freeConnection.removeElementAt(0);
            try {
                if (connection.isClosed()){
                    connection = getConnection();
                }
            } catch (SQLException e) {
               connection =  getConnection();
            }
            /**
             * 没有空闲连接且 最大连接等于 0 或者 当前连接数 小于 最大连接 则创建一个连接
             */
        }else if ( 0 == maxConnect || maxConnect > checkedOut){
            connection = createConnection();
        }

        if (null != connection){
            checkedOut++;
        }
        activeNum++;
        return connection;
    }

    /**
     * 获取连接 并加上等待时间
     * @param timeout
     * @return
     */
    @Override
    public synchronized  Connection getConnection(long timeout) {
        long startTime = System.currentTimeMillis();
        Connection connection = null;

        while ((connection = getConnection()) == null){
            try {
                wait(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if ((new Date().getTime() - startTime) >= timeout){
                return  null;
            }
        }

        return connection;
    }

    /**
     * 释放连接到连接池
     * @param conn
     */
    @Override
    public synchronized void freeConnection(Connection conn) {
        freeConnection.addElement(conn);
        num++;
        checkedOut--;
        activeNum--;
        notifyAll();
    }

    @Override
    public int getNum() {
        return num;
    }

    @Override
    public int getNumActive() {
        return activeNum;
    }

    private DBConnectionPool(){
        try {
            init();
            for (int i = 0 ; i < normalConnect ; i++){
                /**
                 * 获取连接
                 */
                Connection conn = createConnection();
                if (null != conn){
                    /**
                     * 将连接添加到容器中
                     */
                    freeConnection.add(conn);
                    /**
                     * 记录连接总数
                     */
                    num++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 创建连接
     * @return
     */
    private Connection createConnection(){
        Connection connection = null;
        try {
            if (!StringUtils.isNotEmpty(userName) || !StringUtils.isNotEmpty(password)){
                connection = DriverManager.getConnection(url);
            }else{
                connection = DriverManager.getConnection(url,userName,password);
            }
            LOG.info("connection created success!");
        } catch (SQLException e) {
            LOG.error("create connection by url fail Cause {}" , e.getMessage(),e);
        }

        return connection;
    }

    /**
     * 初始化构造器
     * @throws IOException
     */
    private void init() throws IOException {
        InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesName);
        Properties prop = new Properties();
        prop.load(inStream);
        this.userName = prop.getProperty("userName");
        this.password = prop.getProperty("password");
        this.driverName = prop.getProperty("driverName");
        this.url = prop.getProperty("url");
        this.maxConnect = Integer.parseInt(prop.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(prop.getProperty("normalConnect"));
    }

    /**
     * 关闭所有连接
     */
    public synchronized void release(){
        try {
            Enumeration<Connection> allElements = freeConnection.elements();
            while (allElements.hasMoreElements()){
                Connection connection = allElements.nextElement();
                JDBCUtils.closeConnection(connection);
                num--;
            }

            freeConnection.removeAllElements();
            activeNum = 0;
        } finally {
            super.release();
        }
    }
}
