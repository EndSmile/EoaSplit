package com.ldy.account.common.facade;

import com.ldy.common.modulecommunication.facade.ModuleFacadeRepository;

/**
 * Created by ldy on 2017/6/19.
 */

public class AccountFacadeRepository extends ModuleFacadeRepository<AccountFacade>{
    private static AccountFacadeRepository instance = new AccountFacadeRepository();

    private AccountFacadeRepository(){}

    public static AccountFacadeRepository instance(){
        return instance;
    }
}
