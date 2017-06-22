package com.ldy.account.receiver;

import android.content.Context;

import com.ldy.account.common.service.AccountServiceRepository;
import com.ldy.account.serviceImpl.AccountServiceImpl;
import com.ldy.common.receiver.ModuleInitReceiver;

public class AccountInitReceiver extends ModuleInitReceiver {

    @Override
    protected void init(Context context) {
        AccountServiceRepository.instance().setAccountService(AccountServiceImpl.instance());

    }

    @Override
    protected void initFinish(Context context) {

    }
}
