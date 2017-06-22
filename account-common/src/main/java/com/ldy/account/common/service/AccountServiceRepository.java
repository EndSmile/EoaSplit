package com.ldy.account.common.service;

import android.support.annotation.Nullable;

/**
 * Created by ldy on 2017/6/19.
 */

public class AccountServiceRepository {
    private static AccountServiceRepository instance = new AccountServiceRepository();

    private AccountServiceRepository(){}

    public static AccountServiceRepository instance(){
        return instance;
    }

    private AccountService accountService;

    @Nullable
    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
