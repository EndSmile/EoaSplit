package com.ldy.common;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.ldy.common.modulecommunication.event.plug.EventLogPlug;
import com.ldy.common.modulecommunication.event.EventControl;
import com.ldy.common.receiver.ModuleInitReceiver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


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

        moduleInit();

        EventControl.instance().registerPlug(new EventLogPlug());
    }

    private void moduleInit() {
        ArrayList<ModuleInitReceiver> receivers = new ArrayList<>();
        Bundle metaData = null;
        try {
            metaData = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA).metaData;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (metaData!=null){
            for (String s : metaData.keySet()) {
                Object o = metaData.get(s);
                if ("module_init".equals(o)) {
                    try {
                        Class<?> aClass = Class.forName(s);
                        if (ModuleInitReceiver.class.isAssignableFrom(aClass)) {
                            ModuleInitReceiver receiver = (ModuleInitReceiver) aClass.newInstance();
                            receivers.add(receiver);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            for (ModuleInitReceiver receiver : receivers) {
                receiver.init(this);
            }
            for (ModuleInitReceiver receiver : receivers) {
                receiver.initFinish(this);
            }
        }
    }

    public static Context getContext() {
        return context;
    }
}
