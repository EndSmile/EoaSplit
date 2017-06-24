package com.ldy.common.config;

import android.content.Context;
import android.support.annotation.Nullable;

import com.ldy.common.EoaApplication;

/**
 * Created by ldy on 2017/6/24.
 */

public class ResourceValue implements ConfigValue<Integer> {

    private final String name;
    private final String defType;

    public ResourceValue(String name, String defType) {
        this.name = name;
        this.defType = defType;
    }

    @Nullable
    @Override
    public Integer getValue() {
        Context context = EoaApplication.getContext();
        if (context == null) {
            return null;
        }
        int identifier = context.getResources().getIdentifier(name, defType, context.getPackageName());
        if (identifier == 0) {
            return null;
        }
        return identifier;
    }

    @Override
    public String toString() {
        return "ResourceValue{" +
                "name='" + name + '\'' +
                ", defType='" + defType + '\'' +
                '}';
    }

    public static ResourceValue buildAnimResource(String name){
        return new ResourceValue(name,"anim");
    }
    public static ResourceValue buildAttrResource(String name){
        return new ResourceValue(name,"attr");
    }

    public static ResourceValue buildBoolResource(String name){
        return new ResourceValue(name,"bool");
    }

    public static ResourceValue buildColorResource(String name){
        return new ResourceValue(name,"color");
    }

    public static ResourceValue buildDimenResource(String name){
        return new ResourceValue(name,"dimen");
    }

    public static ResourceValue buildDrawableResource(String name){
        return new ResourceValue(name,"drawable");
    }

    public static ResourceValue buildIdResource(String name){
        return new ResourceValue(name,"id");
    }

    public static ResourceValue buildIntegerResource(String name){
        return new ResourceValue(name,"integer");
    }

    public static ResourceValue buildLayoutResource(String name){
        return new ResourceValue(name,"layout");
    }

    public static ResourceValue buildStringResource(String name){
        return new ResourceValue(name,"string");
    }

    public static ResourceValue buildStyleResource(String name){
        return new ResourceValue(name,"style");
    }

    public static ResourceValue buildStyleableResource(String name){
        return new ResourceValue(name,"styleable");
    }

}
