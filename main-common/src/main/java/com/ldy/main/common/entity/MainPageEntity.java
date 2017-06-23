package com.ldy.main.common.entity;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

import com.ldy.common.base.ComparableWrapper;
import com.ldy.common.factor.Factory;

/**
 * Created by ldy on 2017/6/21.
 */

public class MainPageEntity {
    private final Factory<Fragment> fragmentFactory;
    @StringRes
    private final int titleRes;
    @DrawableRes
    private final int iconNormalRes;
    @DrawableRes
    private final int iconSelectRes;

    public MainPageEntity(Factory<Fragment> fragmentFactory, int titleRes,
                          int iconNormalRes, int iconSelectRes) {
        this.fragmentFactory = fragmentFactory;
        this.titleRes = titleRes;
        this.iconNormalRes = iconNormalRes;
        this.iconSelectRes = iconSelectRes;
    }

    public Factory<Fragment> getFragmentFactory() {
        return fragmentFactory;
    }


    public int getTitleRes() {
        return titleRes;
    }

    public int getIconNormalRes() {
        return iconNormalRes;
    }

    public int getIconSelectRes() {
        return iconSelectRes;
    }

    @Override
    public String toString() {
        return "MainPageEntity{" +
                "fragmentFactory=" + fragmentFactory +
                ", titleRes=" + titleRes +
                ", iconNormalRes=" + iconNormalRes +
                ", iconSelectRes=" + iconSelectRes +
                '}';
    }
}
