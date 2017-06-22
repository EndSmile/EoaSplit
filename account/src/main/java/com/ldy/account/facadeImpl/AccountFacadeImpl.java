package com.ldy.account.facadeImpl;

import android.content.Intent;

import com.ldy.account.common.bean.AccountBean;
import com.ldy.account.common.facade.AccountFacade;
import com.ldy.account.navigator.AccountNavigator;

/**
 * Created by ldy on 2017/6/19.
 */

public class AccountFacadeImpl implements AccountFacade {
    private static AccountFacadeImpl instance = new AccountFacadeImpl();

    private AccountFacadeImpl() {
    }

    public static AccountFacadeImpl instance(){
        return instance;
    }

    private AccountBean accountBean;

    @Override
    public AccountBean getAccount() {
        return accountBean;
    }

    public void setAccount(AccountBean accountBean) {
        this.accountBean = accountBean;
    }

    @Override
    public void toLoginActivity(Intent nextActivityIntent) {
        AccountNavigator.toLogin(nextActivityIntent);
    }
}
