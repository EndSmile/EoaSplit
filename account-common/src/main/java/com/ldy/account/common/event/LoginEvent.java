package com.ldy.account.common.event;

import com.ldy.account.common.bean.AccountBean;

/**
 * Created by ldy on 2017/6/19.
 */

public class LoginEvent {
    private final AccountBean accountBean;

    public LoginEvent(AccountBean accountBean) {
        this.accountBean = accountBean;
    }

    public AccountBean getAccountBean() {
        return accountBean;
    }
}
