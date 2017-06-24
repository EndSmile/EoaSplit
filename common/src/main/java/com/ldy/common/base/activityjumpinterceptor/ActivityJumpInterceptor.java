package com.ldy.common.base.activityjumpinterceptor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by ldy on 2017/6/23.
 */

public interface ActivityJumpInterceptor {

    StartActivityData startActivityForResult(Activity sourceActivity, StartActivityData startActivityData);

    StartActivityData startActivityForResult(android.support.v4.app.Fragment sourceFragment, StartActivityData startActivityData);

    StartActivityData startActivityForResult(android.app.Fragment sourceFragment, StartActivityData startActivityData);
    
    OnActivityResultData onActivityResult(Activity sourceActivity, OnActivityResultData onActivityResultData);

    OnActivityResultData onActivityResult(android.support.v4.app.Fragment sourceFragment, OnActivityResultData onActivityResultData);

    OnActivityResultData onActivityResult(android.app.Fragment sourceFragment, OnActivityResultData onActivityResultData);

    class StartActivityData {
        public Intent intent;
        public int requestCode;
        @Nullable
        public Bundle options;

        public StartActivityData(Intent intent, int requestCode, @Nullable Bundle options) {
            this.intent = intent;
            this.requestCode = requestCode;
            this.options = options;
        }
    }

    class OnActivityResultData {
        public int requestCode;
        public int resultCode;
        public Intent data;

        public OnActivityResultData(int requestCode, int resultCode, Intent data) {
            this.requestCode = requestCode;
            this.resultCode = resultCode;
            this.data = data;
        }
    }
}
