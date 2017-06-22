package com.ldy.main.common.entity;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

import com.ldy.common.factor.Factory;
import com.ldy.common.factor.ResourceFactory;

/**
 * Created by ldy on 2017/6/21.
 */

public class MainPageEntity implements Comparable<MainPageEntity> {
    private final Factory<Fragment> fragmentFactory;
    private final ResourceFactory titleRes;
    private final ResourceFactory iconNormalRes;
    private final ResourceFactory iconSelectRes;

    private final int priority;

    public MainPageEntity(Factory<Fragment> fragmentFactory, ResourceFactory titleRes,
                          ResourceFactory iconNormalRes, ResourceFactory iconSelectRes, int priority) {
        this.fragmentFactory = fragmentFactory;
        this.titleRes = titleRes;
        this.iconNormalRes = iconNormalRes;
        this.iconSelectRes = iconSelectRes;
        this.priority = priority;
    }

    public Factory<Fragment> getFragmentFactory() {
        return fragmentFactory;
    }

    public int getPriority() {
        return priority;
    }

    public ResourceFactory getTitleRes() {
        return titleRes;
    }

    public ResourceFactory getIconNormalRes() {
        return iconNormalRes;
    }

    public ResourceFactory getIconSelectRes() {
        return iconSelectRes;
    }

    public static MainPageEntity buildFirstPage(Factory<Fragment> fragmentFactory, ResourceFactory titleRes,
                                                ResourceFactory iconNormalRes, ResourceFactory iconSelectRes) {
        return new MainPageEntity(fragmentFactory, titleRes, iconNormalRes, iconSelectRes, 0);
    }

    public static MainPageEntity buildSecondPage(Factory<Fragment> fragmentFactory, ResourceFactory titleRes,
                                                 ResourceFactory iconNormalRes, ResourceFactory iconSelectRes) {
        return new MainPageEntity(fragmentFactory, titleRes, iconNormalRes, iconSelectRes, 1);
    }

    public static MainPageEntity buildThirdPage(Factory<Fragment> fragmentFactory, ResourceFactory titleRes,
                                                ResourceFactory iconNormalRes, ResourceFactory iconSelectRes) {
        return new MainPageEntity(fragmentFactory, titleRes, iconNormalRes, iconSelectRes, 2);
    }

    public MainPageEntity buildFourthPage(Factory<Fragment> fragmentFactory, ResourceFactory titleRes,
                                          ResourceFactory iconNormalRes, ResourceFactory iconSelectRes) {
        return new MainPageEntity(fragmentFactory, titleRes, iconNormalRes, iconSelectRes, 3);
    }

    public MainPageEntity buildFifthPage(Factory<Fragment> fragmentFactory, ResourceFactory titleRes,
                                         ResourceFactory iconNormalRes, ResourceFactory iconSelectRes) {
        return new MainPageEntity(fragmentFactory, titleRes, iconNormalRes, iconSelectRes, 4);
    }

    @Override
    public int compareTo(@NonNull MainPageEntity o) {
        return priority - o.priority;
    }
}
