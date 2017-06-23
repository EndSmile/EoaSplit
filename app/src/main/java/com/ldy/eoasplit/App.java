package com.ldy.eoasplit;

import com.ldy.common.EoaApplication;
import com.ldy.common.modulecommunication.event.Event;
import com.ldy.common.modulecommunication.event.plug.EventControl;
import com.ldy.common.modulecommunication.event.plug.EventPlug;

/**
 * Created by ldy on 2017/6/22.
 */

public class App extends EoaApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        EventControl.getInstance()
                .registerPlug(new ReverseMainPageEventPlug());
    }
}
