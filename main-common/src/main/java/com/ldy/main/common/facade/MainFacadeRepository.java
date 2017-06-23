package com.ldy.main.common.facade;

import com.ldy.common.modulecommunication.facade.ModuleFacadeRepository;

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
