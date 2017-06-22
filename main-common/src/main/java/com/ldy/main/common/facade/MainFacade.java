package com.ldy.main.common.facade;

import com.ldy.common.modulecommunication.ModuleFacade;
import com.ldy.main.common.entity.MainPageEntity;

/**
 * Created by ldy on 2017/6/19.
 */

public interface MainFacade extends ModuleFacade {
    void registerPage(MainPageEntity mainPageEntity);
}
