package com.ldy.eoasplit;

import com.ldy.common.EoaApplication;
import com.ldy.common.modulecommunication.event.plug.EventControl;

/**
 * Created by ldy on 2017/6/22.
 */

public class App extends EoaApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        EventControl.instance()
                .registerPlug(new ReverseMainPageEventPlug());
    }
}
