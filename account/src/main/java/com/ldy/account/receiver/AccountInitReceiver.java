package com.ldy.account.receiver;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ldy.account.common.bean.AccountBean;
import com.ldy.account.common.facade.AccountFacadeRepository;
import com.ldy.account.facadeImpl.AccountFacadeImpl;
import com.ldy.common.ActivityStack;
import com.ldy.common.base.ComparableWrapper;
import com.ldy.common.modulecommunication.event.plug.EventControl;
import com.ldy.common.receiver.ModuleInitReceiver;
import com.ldy.setting.common.event.GetSettingItemEvent;

import org.greenrobot.eventbus.Subscribe;

public class AccountInitReceiver extends ModuleInitReceiver {

    @Override
    protected void init(Context context) {
        AccountFacadeRepository.instance().setFacade(AccountFacadeImpl.instance());
        EventControl.instance().register(this);
    }

    @Override
    protected void initFinish(Context context) {

    }

    @Subscribe
    public void getSettingItemEvent(GetSettingItemEvent event) {
        AccountBean account = AccountFacadeImpl.instance().getAccount();
        if (account == null) {
            return;
        }

        FrameLayout frameLayout = new FrameLayout(ActivityStack.instance().current());
        TextView textView = new TextView(event.getContext());
        textView.setText("账号:" + account.getUserName());
        frameLayout.addView(textView, LinearLayout.LayoutParams.WRAP_CONTENT,90);
        event.add(ComparableWrapper.<View>buildFirst(frameLayout));
    }
}
