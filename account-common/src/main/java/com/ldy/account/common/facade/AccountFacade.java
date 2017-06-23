package com.ldy.account.common.facade;

import android.content.Intent;

import com.ldy.account.common.bean.AccountBean;
import com.ldy.common.modulecommunication.facade.ModuleFacade;

/**
 * Created by ldy on 2017/6/19.
 */

public interface AccountFacade extends ModuleFacade{
    AccountBean getAccount();
    void toLoginActivity(Intent nextActivityIntent);
}
