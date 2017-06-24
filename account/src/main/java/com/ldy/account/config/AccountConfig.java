package com.ldy.account.config;

import com.ldy.common.config.BaseConfig;
import com.ldy.common.config.PropertyValue;

/**
 * Created by ldy on 2017/6/24.
 */

public class AccountConfig extends BaseConfig {
    public static final String BASE_URL =
            getStrValue(new PropertyValue("account.baseUrl"), new PropertyValue("baseUrl"));

    public static final String HOSTNAME =
            getStrValue(new PropertyValue("account.hostname"), new PropertyValue("hostname"));
}
