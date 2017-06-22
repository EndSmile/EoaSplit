package com.ldy.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;

import com.ldy.common.EoaApplication;


public class DensityUtil {

	/** 
     * 将px值转换为dip或dp值，保证尺寸大小不变 
     *  
     * @param pxValue 
     * @return
     */  
    public static int px2dip(float pxValue) {
        final float scale = EoaApplication.getContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);  
    }  
  
    /** 
     * 将dip或dp值转换为px值，保证尺寸大小不变 
     *  
     * @param dipValue 
     * @return
     */  
    public static int dip2px(float dipValue) {
        final float scale = EoaApplication.getContext().getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);  
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     *
     * @param dipValue
     * @return
     */
    public static double dp2px(float dipValue) {
        final float scale = EoaApplication.getContext().getResources().getDisplayMetrics().density;
        return dipValue*scale;
    }

    public static int getStatusBarHeight(@NonNull Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen","android");
        return resources.getDimensionPixelSize(resourceId);
    }
}
