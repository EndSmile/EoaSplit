package com.ldy.common.base.activityjumpinterceptor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

/**
 * Created by ldy on 2017/6/24.
 */

public class ReplaceActivityInterceptor extends AbActivityJumpInterceptor {
    private final Class<? extends Activity> oldActivity;
    private final Class<? extends Activity> newActivity;

    public ReplaceActivityInterceptor(Class<? extends Activity> oldActivity, Class<? extends Activity> newActivity) {
        this.oldActivity = oldActivity;
        this.newActivity = newActivity;
    }

    @Override
    public StartActivityData startActivityForResult(Activity sourceActivity, StartActivityData startActivityData) {
        return replace(sourceActivity, startActivityData);
    }

    @Override
    public StartActivityData startActivityForResult(Fragment sourceFragment, StartActivityData startActivityData) {
        return replace(sourceFragment.getContext(), startActivityData);
    }

    @Override
    public StartActivityData startActivityForResult(android.app.Fragment sourceFragment, StartActivityData startActivityData) {
        return replace(sourceFragment.getActivity(), startActivityData);
    }

    @NonNull
    private StartActivityData replace(Context context, StartActivityData startActivityData) {
        Intent intent = startActivityData.intent;
        if (intent.getComponent().getClassName().equals(oldActivity.getName())){
            intent.setClass(context,newActivity);
        }
        return startActivityData;
    }

}
