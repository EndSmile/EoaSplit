package com.ldy.common.util;

import android.support.annotation.Nullable;

import java.lang.reflect.ParameterizedType;

/**
 * Created by ldy on 2017/6/22.
 */

public class GenericityUtil {

    @Nullable
    public static Class getFirstGenericityClass(Object o) {
        if (o.getClass().getGenericSuperclass() instanceof ParameterizedType &&
                ((ParameterizedType) (o.getClass().getGenericSuperclass())).getActualTypeArguments().length > 0) {
            return (Class) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[0];
        }
        return null;
    }
}
