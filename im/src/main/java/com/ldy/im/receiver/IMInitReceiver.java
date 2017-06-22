package com.ldy.im.receiver;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.ldy.common.EoaApplication;
import com.ldy.common.factor.Factory;
import com.ldy.common.factor.ResourceFactory;
import com.ldy.common.receiver.ModuleInitReceiver;
import com.ldy.im.BuildConfig;
import com.ldy.im.IMFragment;
import com.ldy.im.R;
import com.ldy.main.common.entity.MainPageEntity;
import com.ldy.main.common.event.InitMainPageEvent;
import com.ldy.main.common.service.MainService;
import com.ldy.main.common.service.MainServiceRepository;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class IMInitReceiver extends ModuleInitReceiver {

    @Override
    protected void init(Context context) {
        Log.d("IMInitReceiver", "imInit");
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initFinish(Context context) {

    }

    @Subscribe
    public void initMainPage(InitMainPageEvent event){
        MainService mainService = MainServiceRepository.instance()
                .getMainService();
        if (mainService!=null){
//            String packageName = BuildConfig.APPLICATION_ID;
            String packageName = EoaApplication.getContext().getPackageName();
            mainService.registerPage(MainPageEntity.buildFirstPage(
                    new Factory<Fragment>() {
                        @Override
                        public Fragment build() {
                            return new IMFragment();
                        }
                    },
                    new ResourceFactory(EoaApplication.getContext(), packageName,"im_conversation","string"),
                    new ResourceFactory(EoaApplication.getContext(), packageName,"im_ic_im_normal","drawable"),
                    new ResourceFactory(EoaApplication.getContext(), packageName,"im_ic_im_selected","drawable")
            ));
        }
    }

}
