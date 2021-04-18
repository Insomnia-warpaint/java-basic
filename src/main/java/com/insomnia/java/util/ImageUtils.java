package com.insomnia.java.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.coobird.thumbnailator.Thumbnails;

/**
 * @author insomnia
 * @date 2021/4/12 下午7:33
 * @effect
 */
public class ImageUtils {

   private static final Logger logger = LogManager.getLogger(ImageUtils.class);

    /**
     * GET 请求
     */
   private static final String GET_REQUEST_METHOD = "GET";

    /**
     * POST 请求
     */
   private static final String POST_REQUEST_METHOD = "POST";

    /**
     * 请求超时时间 单位 毫秒
     */
   private static final Integer CONNECTION_TIME_OUT = 1000 * 5;

    /**
     *  1024 字节
     */
   private static final Integer CURRENT_BYTE_SIZE = 1024;

    /**
     * 2048 字节
     */
   private static final Integer MAX_IMAGE_BYTE_SIZE = 2048;


   private static final Integer HALF_MEGABYTE = 512;

   private static final Integer ONE_MEGABYTE = 1024;

   private static final Integer TWO_MEGABYTE = 2048;

    /**
     * 缓冲区大小
     */
   private static final Integer BUFFER_SIZE = 1024;


    /**
     *
     * @param imageUrl 图片的网址
     * @param localPath 本地的写入路径
     */
	@SuppressWarnings("resource")
	public static void compressedPictures(String imageUrl, String localPath) throws IOException
	{
        if (!StringUtils.isNotEmpty(imageUrl)){
            logger.error("imageUrl 不能为空!");
            throw new IllegalArgumentException("imageUrl must not null");
        }

        if (!StringUtils.isNotEmpty(localPath)){
            logger.error("localPath 不能为空!");
            throw new IllegalArgumentException("localPath must not null");
        }

		HttpURLConnection connection = httpUrlConnection(imageUrl);
        // 获取输入流
        InputStream inputStream = connection.getInputStream();

        // 将 inputStream 转换为 byte 数组
        byte[] byteArray = copyToByteArray(inputStream);

        // 将压缩后的字节数组写入文件
        new FileOutputStream(localPath).write(compressedPictures(byteArray, 200));
    }

    /**
     *
     * @param imageBytes 图片的字节数组
     * @param destSize 压缩的大小 单位 kb
     * @return
     */
    public static byte[] compressedPictures(byte[] imageBytes , Integer destSize){

        if (imageBytes == null || imageBytes.length <= 0){
            return imageBytes;
        }

        if (imageBytes.length < destSize * CURRENT_BYTE_SIZE){
            return imageBytes;
        }

        long srcSize = imageBytes.length;
        // 获取压缩的精度
        double accuracy = getAccuracy(srcSize / 1024);
        try {
            while (imageBytes.length > destSize * ONE_MEGABYTE){
                ByteArrayInputStream in = new ByteArrayInputStream(imageBytes);
                ByteArrayOutputStream out = new ByteArrayOutputStream(imageBytes.length);
                Thumbnails.of(in)
                        .scale(accuracy)
                        .outputQuality(accuracy)
                        .toOutputStream(out);
                imageBytes = out.toByteArray();
            }
            logger.info("压缩图片 原图大小 = {" + srcSize / 1024 +"} kb" + " 压缩后的大小 = {" + imageBytes.length / 1024 + "}");
        } catch (IOException e) {
            logger.error("图片压缩失败! ", e.getMessage());
        }

        return imageBytes;
    }

    /**
     * 根据文件大小计算压缩的精度 图片
     * @param size 文件大小
     * @return 精度
     */
    private static double getAccuracy(long size) {
        double accuracy;
        if (size < HALF_MEGABYTE){
            accuracy = 0.9;
        }else if (size < ONE_MEGABYTE){
            accuracy = 0.8;
        }else if (size < TWO_MEGABYTE){
            accuracy = 0.75;
        }else {
            accuracy = 0.5;
        }
        return accuracy;
    }

    /**
     *
     * @param inputStream 输入流
     * @return byte 数组
     * @throws IOException
     */
    private static byte[] copyToByteArray(InputStream inputStream) throws IOException {

        if (inputStream == null) {
            return new byte[0];
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        copy(inputStream,outputStream);
        return outputStream.toByteArray();

    }

    /**
     *
     * @param inputStream
     * @param outputStream
     * @return
     * @throws IOException
     */
    private static Integer copy(InputStream inputStream, OutputStream outputStream) throws IOException {

        int byteCount = 0;
        byte[] buffer = new byte[BUFFER_SIZE];
        int byteRead;

        if ((byteRead = inputStream.read(buffer)) != -1){
            outputStream.write(buffer,0,byteRead);
            byteCount+= byteRead;
        }

        outputStream.flush();

        return byteCount;
    }

    /**
     *
     * @param path url
     * @return  HttpURLConnection
     * @throws IOException
     */
	private static HttpURLConnection httpUrlConnection(String path) throws IOException
	{
        // 创建 URL 对象
        URL url = new URL(path);
        // 开启连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(GET_REQUEST_METHOD);
        connection.setConnectTimeout(CONNECTION_TIME_OUT);

        return connection;
    }
}
