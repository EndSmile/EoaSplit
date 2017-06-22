package com.ldy.account.common.service;

import android.content.Intent;

import com.ldy.account.common.bean.AccountBean;

/**
 * Created by ldy on 2017/6/19.
 */

public interface AccountService {
    AccountBean getAccount();
    void toLoginActivity(Intent nextActivityIntent);
}
