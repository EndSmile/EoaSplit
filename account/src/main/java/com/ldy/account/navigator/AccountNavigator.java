package com.ldy.account.navigator;

import android.content.Intent;

import com.ldy.account.LoginActivity;
import com.ldy.common.navigator.Navigator;

/**
 * Created by ldy on 2017/6/19.
 */

public class AccountNavigator extends Navigator {
    public static void toLogin(Intent nextIntent) {
        startActivityAndNext(LoginActivity.class, nextIntent);
    }
}
