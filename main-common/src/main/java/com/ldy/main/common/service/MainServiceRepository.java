package com.ldy.main.common.service;

import android.support.annotation.Nullable;

/**
 * Created by ldy on 2017/6/19.
 */

public class MainServiceRepository {
    private static MainServiceRepository instance = new MainServiceRepository();

    private MainServiceRepository(){}

    public static MainServiceRepository instance(){
        return instance;
    }

    private MainService mainService;

    @Nullable
    public MainService getMainService() {
        return mainService;
    }

    public void setMainService(MainService mainService) {
        this.mainService = mainService;
    }
}
