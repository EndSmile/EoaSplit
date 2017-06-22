package com.ldy.main.common.facade;

import android.support.annotation.Nullable;

import com.ldy.common.modulecommunication.ModuleFacadeRepository;

/**
 * Created by ldy on 2017/6/19.
 */

public class MainFacadeRepository extends ModuleFacadeRepository<MainFacade>{
    private static MainFacadeRepository instance = new MainFacadeRepository();

    private MainFacadeRepository(){}

    public static MainFacadeRepository instance(){
        return instance;
    }

}
