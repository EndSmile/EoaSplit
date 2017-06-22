package com.ldy.account.common.event;

import com.ldy.account.common.bean.AccountBean;
import com.ldy.common.modulecommunication.NotificationEvent;

/**
 * Created by ldy on 2017/6/19.
 */

public class LogoutEvent implements NotificationEvent {
    private final AccountBean accountBean;

    public LogoutEvent(AccountBean accountBean) {
        this.accountBean = accountBean;
    }

    public AccountBean getAccountBean() {
        return accountBean;
    }
}
