package com.layer.audio.utils;

import lombok.experimental.UtilityClass;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 集合工具类
 *
 * @author cdyangyang18
 */
@UtilityClass
public class CollectionUtils {

    /**
     * 判断List是否为空
     *
     * @param list list集合
     * @param <T>  泛型
     * @return boolean
     */
    public static <T> boolean isEmpty(List<T> list) {
        return list == null || list.size() == 0;
    }

    /**
     * 判断List是否不为空
     *
     * @param list list集合
     * @param <T>  泛型
     * @return boolean
     */
    public static <T> boolean isNotEmpty(List<T> list) {
        return !isEmpty(list);
    }

    /**
     * 判断List是否为空
     *
     * @param map Map集合
     * @return boolean
     */
    public static <K, V> boolean isEmpty(Map<K, V> map) {
        return map == null || map.size() == 0;
    }

    /**
     * 判断List是否不为空
     *
     * @param map Map集合
     * @return boolean
     */
    public static <K, V> boolean isNotEmpty(Map<K, V> map) {
        return !isEmpty(map);
    }

    /**
     * 判断集合元素是否全部相同
     *
     * @param list List集合
     * @param <T>  泛型
     * @return boolean
     */
    public static <T> boolean isSame(List<T> list) {
        return null != list && 1 == new HashSet<Object>(list).size();
    }

    /**
     * 判断集合元素是否不全部相同
     *
     * @param list List集合
     * @param <T>  泛型
     * @return boolean
     */
    public static <T> boolean isNotSame(List<T> list) {
        return !isSame(list);
    }

}
