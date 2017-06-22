package com.ldy.setting.receiver;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.ldy.common.factor.Factory;
import com.ldy.common.receiver.ModuleInitReceiver;
import com.ldy.main.common.entity.MainPageEntity;
import com.ldy.main.common.event.GetMainPageEvent;
import com.ldy.main.common.facade.MainFacade;
import com.ldy.main.common.facade.MainFacadeRepository;
import com.ldy.setting.R;
import com.ldy.setting.SettingFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class SettingInitReceiver extends ModuleInitReceiver {

    @Override
    protected void init(Context context) {
        Log.d("IMInitReceiver", "imInit");
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initFinish(Context context) {

    }

    @Subscribe
    public void initMainPage(GetMainPageEvent event) {
        event.add(MainPageEntity.buildSecondPage(
                new Factory<Fragment>() {
                    @Override
                    public Fragment build() {
                        return new SettingFragment();
                    }
                },
                R.string.setting_mine,
                R.drawable.setting_ic_mine_normal,
                R.drawable.setting_ic_mine_selected
        ));

    }

}
