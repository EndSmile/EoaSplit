package com.ldy.common.factor;

import android.content.Context;
import android.support.v4.app.NotificationCompatBase;

/**
 * Created by ldy on 2017/6/21.
 */

public class ResourceFactory implements Factory<Integer> {

    private final Context context;
    private final String packageName;
    private final String name;
    private final String type;
    private Integer id;

    public ResourceFactory(Context context, String packageName, String name, String type) {
        this.context = context;
        this.packageName = packageName;
        this.name = name;
        this.type = type;
    }

    @Override
    public Integer build() {
        if (id != null && id != 0) {
            return id;
        }
        try {
            id = context.getResources().getIdentifier(name, type, packageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}
