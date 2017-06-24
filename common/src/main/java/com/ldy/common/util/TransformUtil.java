package com.ldy.common.util;

import android.support.annotation.Nullable;

/**
 * Created by ldy on 2017/6/24.
 */

public class TransformUtil {

    @Nullable
    public static Integer toInt(Object o) {
        if (o == null) {
            return null;
        }
        if (o instanceof Integer) {
            return (Integer) o;
        } else if (o instanceof String) {
            return Integer.valueOf((String) o);
        }
        return null;
    }

    @Nullable
    public static Float toFloat(Object o) {
        if (o == null) {
            return null;
        }
        if (o instanceof Float) {
            return (Float) o;
        } else if (o instanceof Integer) {
            return ((Integer) o).floatValue();
        } else if (o instanceof Double) {
            return ((Double) o).floatValue();
        } else if (o instanceof String) {
            return Float.valueOf((String) o);
        }
        return null;
    }
}
