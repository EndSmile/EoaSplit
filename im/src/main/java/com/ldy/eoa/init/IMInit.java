package com.ldy.eoa.init;

import android.content.Context;

import com.ldy.common.annotation.ReflectInvoke;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by ldy on 2017/6/21.
 */
@ReflectInvoke
public class IMInit implements EoaInit {
    @Override
    public void serviceInit(Context context) {
        EventBus.getDefault().register(this);
    }

    @Override
    public void serviceInitFinish(Context context) {

    }


}
