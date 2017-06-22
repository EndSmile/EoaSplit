package com.ldy.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ldy.account.common.service.AccountService;
import com.ldy.account.common.service.AccountServiceRepository;
import com.ldy.main.navigator.MainNavigator;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
    }

    public void login(View view) {
        AccountService accountService = AccountServiceRepository.instance()
                .getAccountService();
        if (accountService == null) {
            throw new NullPointerException("accountService can not be null");
        }
        accountService.toLoginActivity(MainNavigator.get2MainIntent());
    }
}
