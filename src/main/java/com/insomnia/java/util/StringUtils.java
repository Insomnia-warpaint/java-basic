package com.insomnia.java.util;

/**
 * @author insomnia
 * @date 2021/4/12 下午7:45
 * @effect
 */
public class StringUtils {

    private static final String[] EMPTY_STRING_ARRAY = {};
    private static final String FOLDER_SEPARATOR = "/";
    private static final String WINDOWS_FOLDER_SEPARATOR = "\\";
    private static final String TOP_PATH = "..";
    private static final String CURRENT_PATH = ".";
    private static final Character EXENTENT_SEPARATOR = '.';

    /**
     *
     * @param str 字符序列
     * @return 不为空返回 true 反之 false
     *
     */
    public static boolean isNotEmpty(CharSequence str){
        return (null != str && str.length() > 0);
    }

    /**
     *
     * @param str 字符串
     * @return  不为空返回 true 反之 false
     *
     */
    public static boolean isNotEmpty(String str){
        return (null != str && !str.isEmpty());
    }

    /**
     *
     * @param str 字符序列
     * @return 为空返回 true 反之 false
     */
    public static boolean isEmpty(CharSequence str){
        return (null == str || str.length() == 0);
    }

    /**
     *
     * @param str 字符串
     * @return 空返回 true 反之 false
     */
    public static boolean isEmpty(String str){
        return (null == str || str.isEmpty());
    }

    /**
     *
     * @param str 字符序列
     * @return 不为空返回 true 反之 false
     */
    public static boolean hasLength(CharSequence str){
        return  (null != str && str.length() > 0);
    }

    /**
     *
     * @param str 字符串
     * @return 不为空返回 true 反之 false
     */
    public static boolean hasLength(String str){
        return  (null != str && !str.isEmpty());
    }
}
