package com.ldy.common.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.ldy.common.EoaApplication;

/**
 * Created by ldy on 2017/6/21.
 * 为了让各模块完成初始化，在{@link EoaApplication#onCreate()}时发出广播,需要在AndroidManifest.xml中注册</p>
 * {@link #ACTION_MODULE_INIT},{@link #ACTION_MODULE_INIT_FINISH}<p/>
 * 作为action的广播
 */

public abstract class ModuleInitReceiver extends BroadcastReceiver {

    public static final String ACTION_MODULE_INIT = "com.xdja.eoa.module.init";
    public static final String ACTION_MODULE_INIT_FINISH = "com.xdja.eoa.module.initFinish";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (ACTION_MODULE_INIT.equals(action)) {
            init(context);
        } else if (ACTION_MODULE_INIT_FINISH.equals(action)) {
            initFinish(context);
        }
    }

    /**
     * 初始化，{@link EoaApplication#onCreate()}时发出广播，
     * 应该在此初始化自己的模块，需要在AndroidManifest.xml中注册{@link #ACTION_MODULE_INIT}作为action的广播
     */
    protected abstract void init(Context context);

    /**
     * 各模块初始化完毕，{@link EoaApplication#onCreate()}时发出广播，
     * 应该在此调用或注册其它模块，需要在AndroidManifest.xml注册{@link #ACTION_MODULE_INIT_FINISH}作为action的广播
     */
    protected abstract void initFinish(Context context);
}
