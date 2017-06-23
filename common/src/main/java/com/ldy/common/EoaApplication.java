package com.ldy.common;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.ldy.common.modulecommunication.event.plug.EventLogPlug;
import com.ldy.common.modulecommunication.event.plug.EventControl;


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

        EventControl.instance().registerPlug(new EventLogPlug());
    }

    public static Context getContext() {
        return context;
    }
}
