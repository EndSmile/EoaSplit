package com.ldy.eoa.init;

import android.content.Context;
import android.util.Log;

import com.ldy.account.common.facade.AccountFacadeRepository;
import com.ldy.account.serviceImpl.AccountFacadeImpl;
import com.ldy.common.annotation.ReflectInvoke;

/**
 * Created by ldy on 2017/6/21.
 */
@ReflectInvoke
public class AccountInit implements EoaInit {
    @Override
    public void serviceInit(Context context) {
        Log.d("AccountInit", "account模块serviceInit");
        AccountFacadeRepository.instance().setAccountFacade(AccountFacadeImpl.instance());
    }

    @Override
    public void serviceInitFinish(Context context) {

    }
}
