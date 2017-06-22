package com.ldy.common;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * Created by ldy on 2017/3/31.
 */

public class ActivityStackControl implements Application.ActivityLifecycleCallbacks {
    private static ActivityStackControl instance = null;
    private ActivityStack activityStack;

    private ActivityStackControl() {

    }

    public void register(Application application) {
        if (activityStack != null) {
            //已经注册过了
            return;
        }
        activityStack = ActivityStack.instance();
        application
                .registerActivityLifecycleCallbacks(this);
    }

    public static ActivityStackControl instance() {
        if (instance == null) {
            synchronized (ActivityStackControl.class) {
                if (instance == null) {
                    instance = new ActivityStackControl();
                }
            }
        }
        return instance;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        activityStack.addActivity(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        activityStack.removeActivity(activity);
    }
}
