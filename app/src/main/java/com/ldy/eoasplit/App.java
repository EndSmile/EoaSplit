package com.ldy.eoasplit;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.ldy.common.EoaApplication;
import com.ldy.common.base.activityjumpinterceptor.AbActivityJumpInterceptor;
import com.ldy.common.base.activityjumpinterceptor.ActivityJumpInterceptor;
import com.ldy.common.base.activityjumpinterceptor.ActivityJumpInterceptorControl;
import com.ldy.common.base.activityjumpinterceptor.ReplaceActivityInterceptor;
import com.ldy.common.modulecommunication.event.plug.EventControl;
import com.ldy.main.MainActivity;

/**
 * Created by ldy on 2017/6/22.
 */

public class App extends EoaApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        EventControl.instance()
                .registerPlug(new ReverseMainPageEventPlug());
//        ActivityJumpInterceptorControl.instance()
//                .register(new ReplaceActivityInterceptor(MainActivity.class,MockActivity.class));
    }
}
