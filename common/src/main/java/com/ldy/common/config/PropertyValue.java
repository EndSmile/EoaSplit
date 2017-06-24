package com.ldy.common.config;

import android.content.Context;
import android.support.annotation.Nullable;

import com.ldy.common.EoaApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ldy on 2017/6/24.
 */

public class PropertyValue implements ConfigValue<String>{
    private final String key;

    public PropertyValue(String key) {
        this.key = key;
    }

    @Nullable
    public String getValue(){
        return getPropertyConfigValue(key);
    }

    public static final String CONFIG_FILE_NAME = "config.properties";

    private static Properties configProperties;

    @Nullable
    public static String getPropertyConfigValue(String key) {
        if (configProperties == null) {
            Context context = EoaApplication.getContext();
            try {
                InputStream inputStream = context.getAssets().open(CONFIG_FILE_NAME);
                configProperties = new Properties();
                configProperties.load(inputStream);
            } catch (IOException ignored) {
            }
        }
        if (configProperties != null) {
            return configProperties.getProperty(key);
        }
        return null;
    }

    @Override
    public String toString() {
        return "PropertyValue{" +
                "key='" + key + '\'' +
                '}';
    }
}
