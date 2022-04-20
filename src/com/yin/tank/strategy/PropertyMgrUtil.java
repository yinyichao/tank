package com.yin.tank.strategy;

import com.yin.tank.PropertyMgr;

import java.lang.reflect.InvocationTargetException;

public class PropertyMgrUtil {
    public static FireStrategy getDefaultFire() {
        String defaultFire = PropertyMgr.getStringKey("defaultFire");
        try {
            return (DefaultFireStrategy)Class.forName(defaultFire).getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static FireStrategy getFourDirFire() {
        String defaultFire = PropertyMgr.getStringKey("fourFire");
        try {
            return (FourDirFireStrategy)Class.forName(defaultFire).getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
