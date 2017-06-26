package com.ldy.common.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.ldy.common.util.TransformUtil;

import java.security.InvalidParameterException;
import java.util.Arrays;

/**
 * Created by ldy on 2017/6/24.
 */

public class BaseConfig {


    @Nullable
    public static String getStrValue(Object... objects) {
        Object value = getValue(objects);
        if (value == null) {
            return null;
        }
        return String.valueOf(value);
    }

    @NonNull
    public static String getVerifyStrValue(Object... objects) {
        return String.valueOf(getVerifyValue(objects));
    }

    @Nullable
    public static Integer getIntegerValue(Object... objects) {
        return TransformUtil.toInt(getValue(objects));
    }

    public static int getVerifyIntValue(Object... objects) {
        Integer integer = TransformUtil.toInt(getVerifyValue(objects));
        if (integer == null) {
            throw new InvalidParameterException("参数解析结果不为int类型");
        }
        return integer;
    }

    @Nullable
    public static Float getFloatValue(Object... objects) {
        return TransformUtil.toFloat(getValue(objects));
    }

    public static float getVerifyFloatValue(Object... objects) {
        Float aFloat = TransformUtil.toFloat(getVerifyValue(objects));
        if (aFloat == null) {
            throw new InvalidParameterException("参数解析结果不为float类型");
        }
        return aFloat;
    }


    @NonNull
    public static Object getVerifyValue(Object... objects) {
        if (objects == null) {
            throw new InvalidParameterException("param must not be null");
        }
        Object value = getValue(objects);
        if (value == null) {
            throw new InvalidParameterException(Arrays.toString(objects) + ":解析结果不能为null");
        }
        return value;
    }

    /**
     * @param objects 依次读取数组中的值，读到非null值即返回，如果该值为{@link PropertyValue}
     *                则获取{@link PropertyValue#getValue()}代替该值
     */
    @Nullable
    public static Object getValue(Object... objects) {
        if (objects == null) {
            return null;
        }
        Object result = null;
        for (Object object : objects) {
            if (object != null) {
                if (object instanceof ConfigValue) {
                    result = ((ConfigValue) object).getValue();
                } else {
                    result = object;
                }
                if (result != null) {
                    break;
                }

            }
        }
        return result;
    }

}
