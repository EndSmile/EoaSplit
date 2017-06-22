package com.ldy.account.serviceImpl;

import android.content.Intent;

import com.ldy.account.common.bean.AccountBean;
import com.ldy.account.common.service.AccountService;
import com.ldy.account.navigator.AccountNavigator;

/**
 * Created by ldy on 2017/6/19.
 */

public class AccountServiceImpl implements AccountService {
    private static AccountServiceImpl instance = new AccountServiceImpl();

    private AccountServiceImpl() {
    }

    public static AccountServiceImpl instance(){
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
