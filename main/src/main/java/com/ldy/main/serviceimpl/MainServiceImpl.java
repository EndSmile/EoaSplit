package com.ldy.main.serviceimpl;

import com.ldy.main.common.entity.MainPageEntity;
import com.ldy.main.common.service.MainService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import rx.Observable;

/**
 * Created by ldy on 2017/6/21.
 */

public class MainServiceImpl implements MainService {

    private static MainServiceImpl instance = new MainServiceImpl();

    private MainServiceImpl() {
    }

    public static MainServiceImpl instance(){
        return instance;
    }

    private List<MainPageEntity> pageEntityList = new ArrayList<>();

    @Override
    public void registerPage(MainPageEntity mainPageEntity) {
        pageEntityList.add(mainPageEntity);
        Collections.sort(pageEntityList);
    }

    public List<MainPageEntity> getPageEntityList() {
        return pageEntityList;
    }
}
