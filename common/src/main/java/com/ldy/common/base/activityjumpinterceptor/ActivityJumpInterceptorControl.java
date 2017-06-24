package com.ldy.common.base.activityjumpinterceptor;

import android.app.Activity;
import android.support.v4.app.Fragment;

import java.util.ArrayList;

/**
 * Created by ldy on 2017/6/23.
 */

public class ActivityJumpInterceptorControl implements ActivityJumpInterceptor {
    private static final ActivityJumpInterceptorControl instance = new ActivityJumpInterceptorControl();
    private ArrayList<ActivityJumpInterceptor> interceptors = new ArrayList<>();

    public static ActivityJumpInterceptorControl instance() {
        return instance;
    }

    private ActivityJumpInterceptorControl() {
    }

    public void register(ActivityJumpInterceptor interceptor) {
        interceptors.add(interceptor);
    }

    public synchronized void unRegister(ActivityJumpInterceptor interceptor) {
        if (interceptor != null) {
            interceptors.remove(interceptor);
        }
    }

    @Override
    public StartActivityData startActivityForResult(Activity sourceActivity, StartActivityData startActivityData) {
        for (ActivityJumpInterceptor interceptor : interceptors) {
            startActivityData = interceptor.startActivityForResult(sourceActivity, startActivityData);
        }
        return startActivityData;
    }

    @Override
    public StartActivityData startActivityForResult(Fragment sourceFragment, StartActivityData startActivityData) {
        for (ActivityJumpInterceptor interceptor : interceptors) {
            startActivityData = interceptor.startActivityForResult(sourceFragment, startActivityData);
        }
        return startActivityData;
    }

    @Override
    public StartActivityData startActivityForResult(android.app.Fragment sourceFragment, StartActivityData startActivityData) {
        for (ActivityJumpInterceptor interceptor : interceptors) {
            startActivityData = interceptor.startActivityForResult(sourceFragment, startActivityData);
        }
        return startActivityData;
    }

    @Override
    public OnActivityResultData onActivityResult(Activity sourceActivity, OnActivityResultData onActivityResultData) {
        for (ActivityJumpInterceptor interceptor : interceptors) {
            onActivityResultData = interceptor.onActivityResult(sourceActivity, onActivityResultData);
        }
        return onActivityResultData;
    }

    @Override
    public OnActivityResultData onActivityResult(Fragment sourceFragment, OnActivityResultData onActivityResultData) {
        for (ActivityJumpInterceptor interceptor : interceptors) {
            onActivityResultData = interceptor.onActivityResult(sourceFragment, onActivityResultData);
        }
        return onActivityResultData;
    }

    @Override
    public OnActivityResultData onActivityResult(android.app.Fragment sourceFragment, OnActivityResultData onActivityResultData) {
        for (ActivityJumpInterceptor interceptor : interceptors) {
            onActivityResultData = interceptor.onActivityResult(sourceFragment, onActivityResultData);
        }
        return onActivityResultData;
    }
}
