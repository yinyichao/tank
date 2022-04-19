package com.yin.tank;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
    static Properties props = new Properties();

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object getKey(String key) {
        return props.get(key);
    }
    public static String getStringKey(String key) {
        return (String)props.get(key);
    }
    public static int getIntegerKey(String key) {
        return Integer.parseInt((String)props.get(key));
    }

}
