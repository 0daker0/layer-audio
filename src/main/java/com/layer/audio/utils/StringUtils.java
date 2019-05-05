package com.layer.audio.utils;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;

/**
 * String工具类
 *
 * @author cdyangyang18
 */
@UtilityClass
public class StringUtils {

    // 定义下划线
    private static final char UNDERLINE = '_';

    /**
     * String为空判断
     *
     * @param str 需判断字符串
     * @return true:为空 false:不为空
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    /**
     * String不为空判断
     *
     * @param str 需判断字符串
     * @return true:不为空 false:为空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 填写空值为""，而不是null
     *
     * @param param 字符串
     * @return 处理后的字符串
     */
    public static String writeNullStringAsEmpty(String param) {
        return isEmpty(param) ? "" : param;
    }

    /**
     * 判断字符是否存在于指定字符内
     *
     * @param sourceStr  指定字符
     * @param targetList 需要判断的字符数组
     * @return boolean
     */
    public static boolean isExit(String sourceStr, List<String> targetList) {
        sourceStr = sourceStr.trim().replaceAll(" ", "").toUpperCase();
        for (String str : targetList) {
            str = str.trim().replaceAll(" ", "").toUpperCase();
            if (sourceStr.contains(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字符是否不存在于指定字符内
     *
     * @param sourceStr  指定字符
     * @param targetList 需要判断的字符数组
     * @return boolean
     */
    public static boolean isNotExit(String sourceStr, List<String> targetList) {
        return !isExit(sourceStr, targetList);
    }

    /**
     * 判断字符是否存在于指定字符内
     *
     * @param sourceStr  指定字符
     * @param targetList 需要判断的字符数组
     * @return boolean
     */
    public static boolean isExit(String sourceStr, String[] targetList) {
        return isExit(sourceStr, Arrays.asList(targetList));
    }

    /**
     * 判断字符是否不存在于指定字符内
     *
     * @param sourceStr  指定字符
     * @param targetList 需要判断的字符数组
     * @return boolean
     */
    public static boolean isNotExit(String sourceStr, String[] targetList) {
        return isNotExit(sourceStr, Arrays.asList(targetList));
    }

}
