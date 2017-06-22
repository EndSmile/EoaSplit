package com.ldy.account.common.event;

import com.ldy.account.common.bean.AccountBean;

/**
 * Created by ldy on 2017/6/19.
 */

public class LogoutEvent {
    private final AccountBean accountBean;

    public LogoutEvent(AccountBean accountBean) {
        this.accountBean = accountBean;
    }

    public AccountBean getAccountBean() {
        return accountBean;
    }
}
