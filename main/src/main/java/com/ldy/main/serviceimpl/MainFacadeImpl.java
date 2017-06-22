package com.ldy.main.serviceimpl;

import com.ldy.main.common.entity.MainPageEntity;
import com.ldy.main.common.facade.MainFacade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ldy on 2017/6/21.
 */

public class MainFacadeImpl implements MainFacade {

    private static MainFacadeImpl instance = new MainFacadeImpl();

    private MainFacadeImpl() {
    }

    public static MainFacadeImpl instance(){
        return instance;
    }

}
