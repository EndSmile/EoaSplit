package com.ldy.setting.common.event;

import android.content.Context;
import android.view.View;

import com.ldy.common.base.ComparableWrapper;
import com.ldy.common.modulecommunication.event.GetSortDatasEvent;

/**
 * Created by ldy on 2017/6/22.
 */

public class GetSettingItemEvent extends GetSortDatasEvent<ComparableWrapper<View>> {
    private final Context context;

    public GetSettingItemEvent(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }
}
