package com.ldy.account.receiver;

import android.content.Context;

import com.ldy.account.common.facade.AccountFacadeRepository;
import com.ldy.account.serviceImpl.AccountFacadeImpl;
import com.ldy.common.receiver.ModuleInitReceiver;

public class AccountInitReceiver extends ModuleInitReceiver {

    @Override
    protected void init(Context context) {
        AccountFacadeRepository.instance().setFacade(AccountFacadeImpl.instance());

    }

    @Override
    protected void initFinish(Context context) {

    }
}
