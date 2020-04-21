package com.leesin;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/4/21 15:52
 * @modified By:
 */
public class RedisDataBase implements DataBase {
    @Override
    public String dataBaseName() {
        System.out.println("我是redis");
        return "";
    }
}
