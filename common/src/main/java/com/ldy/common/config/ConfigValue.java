package com.ldy.common.config;

import android.support.annotation.Nullable;

/**
 * Created by ldy on 2017/6/24.
 */

public interface ConfigValue<T> {
    @Nullable
    T getValue();
}
