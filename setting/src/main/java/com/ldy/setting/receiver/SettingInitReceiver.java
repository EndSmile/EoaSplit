package com.ldy.setting.receiver;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.ldy.common.EoaApplication;
import com.ldy.common.factor.Factory;
import com.ldy.common.factor.ResourceFactory;
import com.ldy.common.receiver.ModuleInitReceiver;
import com.ldy.main.common.entity.MainPageEntity;
import com.ldy.main.common.event.InitMainPageEvent;
import com.ldy.main.common.service.MainService;
import com.ldy.main.common.service.MainServiceRepository;
import com.ldy.setting.BuildConfig;
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
    public void initMainPage(InitMainPageEvent event) {
//        MainService mainService = MainServiceRepository.instance()
//                .getMainService();
//        if (mainService != null) {
//            mainService.registerPage(
//                    MainPageEntity.buildSecondPage(
//                            new Factory<Fragment>() {
//                                @Override
//                                public Fragment build() {
//                                    return new SettingFragment();
//                                }
//                            },
//                            new ResourceFactory(EoaApplication.getContext(), BuildConfig.APPLICATION_ID, "setting_mine", "string"),
//                            new ResourceFactory(EoaApplication.getContext(), BuildConfig.APPLICATION_ID, "setting_ic_mine_normal", "drawable"),
//                            new ResourceFactory(EoaApplication.getContext(), BuildConfig.APPLICATION_ID, "setting_ic_mine_selected", "drawable")
//                    ));
//
//        }
    }

}
