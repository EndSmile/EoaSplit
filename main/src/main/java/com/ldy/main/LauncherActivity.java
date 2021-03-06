package com.ldy.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ldy.account.common.facade.AccountFacade;
import com.ldy.account.common.facade.AccountFacadeRepository;
import com.ldy.common.base.BaseActivity;
import com.ldy.main.navigator.MainNavigator;

public class LauncherActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_launcher);
    }

    public void login(View view) {
        AccountFacade accountFacade = AccountFacadeRepository.instance()
                .getVerifyFacade();
        accountFacade.toLoginActivity(MainNavigator.get2MainIntent());
    }
}
