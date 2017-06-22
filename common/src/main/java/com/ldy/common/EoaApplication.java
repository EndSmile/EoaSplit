package com.ldy.common;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.ldy.eoa.init.EoaInit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldy on 2017/6/19.
 */

public class EoaApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        ActivityStackControl.instance().register(this);
        sendBroadcast(new Intent("com.xdja.eoa.module.init"));
        sendBroadcast(new Intent("com.xdja.eoa.module.initFinish"));

    }

//    private void initService() {
//        List<Class<EoaInit>> list = ClassUtil.getAllClassByInterface(EoaInit.class);
//        ArrayList<EoaInit> inits = new ArrayList<>(list.size());
//        try {
//            for (Class<EoaInit> initClass : list) {
//                inits.add(initClass.newInstance());
//            }
//        } catch (InstantiationException e) {
//            throw new RuntimeException("实现EoaInit的类必须拥有一个无参构造函数",e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException("实现EoaInit的类必须可被访问",e);
//        }
//        for (EoaInit init : inits) {
//            init.serviceInit(this);
//        }
//        for (EoaInit init : inits) {
//            init.serviceInitFinish(this);
//        }
//    }

    public static Context getContext() {
        return context;
    }
}
