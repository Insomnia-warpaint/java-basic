package com.insomnia.java.web;

import com.insomnia.java.service.MessageService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebServlet;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author insomnia
 */
public class TimerListener implements ServletContextListener {

    private static int count = 0;

    private static final int CURRENT_SCHEDULED_SIZE = 10;
    @Override
    public void contextInitialized(ServletContextEvent event) {

        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(CURRENT_SCHEDULED_SIZE);
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
               MessageService.resetCount();
               System.out.println("重置次数！");
            }
        },1,10,TimeUnit.SECONDS);
    }
}
