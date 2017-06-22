package com.ldy.main.receiver;

import android.content.Context;

import com.ldy.common.receiver.ModuleInitReceiver;
import com.ldy.main.common.service.MainServiceRepository;
import com.ldy.main.serviceimpl.MainServiceImpl;

public class MainInitReceiver extends ModuleInitReceiver {

    @Override
    protected void init(Context context) {
        MainServiceRepository.instance().setMainService(MainServiceImpl.instance());
    }

    @Override
    protected void initFinish(Context context) {

    }
}
