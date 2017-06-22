package com.ldy.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ldy.account.common.facade.AccountFacade;
import com.ldy.account.common.facade.AccountFacadeRepository;
import com.ldy.main.navigator.MainNavigator;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
    }

    public void login(View view) {
        AccountFacade accountFacade = AccountFacadeRepository.instance()
                .getFacade();
        if (accountFacade == null) {
            throw new NullPointerException("accountService can not be null");
        }
        accountFacade.toLoginActivity(MainNavigator.get2MainIntent());
    }
}
