package com.ldy.eoasplit;

import com.ldy.common.base.ComparableWrapper;
import com.ldy.common.modulecommunication.event.plug.EventPlug;
import com.ldy.main.common.entity.MainPageEntity;
import com.ldy.main.common.event.GetMainPageEvent;

import java.util.Collections;

/**
 * Created by ldy on 2017/6/22.
 */

public class ReverseMainPageEventPlug implements EventPlug<GetMainPageEvent> {
    @Override
    public boolean preEvent(GetMainPageEvent event) {
        return false;
    }

    @Override
    public void postEvent(GetMainPageEvent event) {
        Collections.reverse(event.getDataList());
    }

    @Override
    public Class<GetMainPageEvent> getEventClass() {
        return GetMainPageEvent.class;
    }
}
