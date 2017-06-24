package com.ldy.im.config;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import com.ldy.common.config.BaseConfig;
import com.ldy.common.config.PropertyValue;
import com.ldy.common.config.ResourceValue;
import com.ldy.im.R;

/**
 * Created by ldy on 2017/6/24.
 */

public class IMConfig extends BaseConfig {
    public static final String BASE_URL =
            getVerifyStrValue(new PropertyValue("im.baseUrl"), new PropertyValue("baseUrl"));

    public static final String HOSTNAME =
            getVerifyStrValue(new PropertyValue("im.hostname"), new PropertyValue("hostname"));

    @DrawableRes
    public static final int MAIN_ICON_NORMAL =
            getVerifyIntValue(ResourceValue.buildDrawableResource("im_mainIcon_normal")
                    , R.drawable.im_ic_im_normal);

    @DrawableRes
    public static final int MAIN_ICON_SELECT =
            getVerifyIntValue(ResourceValue.buildDrawableResource("im_mainIcon_select")
                    , R.drawable.im_ic_im_selected);

    @StringRes
    public static final int MAIN_TITLE =
            getVerifyIntValue(ResourceValue.buildStringResource("im_main_title")
                    , R.string.im_conversation);
}
