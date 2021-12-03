package com.mj.utils;

import org.apache.ibatis.cache.Cache;

/**
 * @author : MaJ
 * @date : 2021/11/22
 * @description ：自定义缓存
 */
public class Mycache implements Cache {
    public String getId() {
        return null;
    }

    public void putObject(Object o, Object o1) {

    }

    public Object getObject(Object o) {
        return null;
    }

    public Object removeObject(Object o) {
        return null;
    }

    public void clear() {

    }

    public int getSize() {
        return 0;
    }
}
