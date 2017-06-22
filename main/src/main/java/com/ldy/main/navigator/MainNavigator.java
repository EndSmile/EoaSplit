package com.ldy.main.navigator;

import android.content.Intent;

import com.ldy.common.ActivityStack;
import com.ldy.common.navigator.Navigator;
import com.ldy.main.MainActivity;

/**
 * Created by ldy on 2017/6/19.
 */

public class MainNavigator extends Navigator {

    public static Intent get2MainIntent(){
        return new Intent(ActivityStack.instance().current(), MainActivity.class);
    }
}
