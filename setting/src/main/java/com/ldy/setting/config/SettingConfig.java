package com.ldy.setting.config;

import com.ldy.common.config.BaseConfig;
import com.ldy.common.config.PropertyValue;

/**
 * Created by ldy on 2017/6/24.
 */

public class SettingConfig extends BaseConfig {
    public static final String BASE_URL =
            getStrValue(new PropertyValue("setting.baseUrl"), new PropertyValue("baseUrl"));

    public static final String HOSTNAME =
            getStrValue(new PropertyValue("setting.hostname"), new PropertyValue("hostname"));
}
