package com.ldy.common.navigator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.ldy.common.ActivityStack;

/**
 * Created by ldy on 2017/6/19.
 */

public class Navigator {
    public static final String NEXT_ACTIVITY_INTENT = "nextActivityIntent";

    public static void startActivityAndNext(Class<? extends Activity> targetActivity,
                                            Intent nextActivityIntent) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(NEXT_ACTIVITY_INTENT, nextActivityIntent);
        startActivity(targetActivity, bundle);
    }

    public static void startNext(Activity activity) {
        Intent nextIntent = activity.getIntent().getParcelableExtra(NEXT_ACTIVITY_INTENT);
        ActivityStack.instance().current().startActivity(nextIntent);
    }

    public static void startActivity(Class<? extends Activity> targetActivity,
                                     Bundle bundle) {
        Activity current = ActivityStack.instance().current();
        Intent intent = new Intent(current, targetActivity);
        intent.putExtras(bundle);
        current.startActivity(intent);
    }
}
