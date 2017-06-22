package com.ldy.main.facadeimpl;

import com.ldy.main.common.facade.MainFacade;

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
