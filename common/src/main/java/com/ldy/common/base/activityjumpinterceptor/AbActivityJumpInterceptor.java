package com.ldy.common.base.activityjumpinterceptor;

import android.app.Activity;
import android.support.v4.app.Fragment;

/**
 * Created by ldy on 2017/6/23.
 */

public class AbActivityJumpInterceptor implements ActivityJumpInterceptor {
    @Override
    public StartActivityData startActivityForResult(Activity sourceActivity, StartActivityData startActivityData) {
        return startActivityData;
    }

    @Override
    public StartActivityData startActivityForResult(Fragment sourceFragment, StartActivityData startActivityData) {
        return startActivityData;
    }

    @Override
    public StartActivityData startActivityForResult(android.app.Fragment sourceFragment, StartActivityData startActivityData) {
        return startActivityData;
    }

    @Override
    public OnActivityResultData onActivityResult(Activity sourceActivity, OnActivityResultData onActivityResultData) {
        return onActivityResultData;
    }

    @Override
    public OnActivityResultData onActivityResult(Fragment sourceFragment, OnActivityResultData onActivityResultData) {
        return onActivityResultData;
    }

    @Override
    public OnActivityResultData onActivityResult(android.app.Fragment sourceFragment, OnActivityResultData onActivityResultData) {
        return onActivityResultData;
    }
}
