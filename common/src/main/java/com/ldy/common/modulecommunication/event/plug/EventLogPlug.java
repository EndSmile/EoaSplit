package com.ldy.common.modulecommunication.event.plug;

import android.util.Log;

import com.ldy.common.modulecommunication.event.Event;

/**
 * Created by ldy on 2017/6/22.
 */

public class EventLogPlug implements EventPlug<Event> {

    @Override
    public boolean preEvent(Event event) {
        Log.d("EventLogPlug --> ", event.toString());
        return false;
    }

    @Override
    public void postEvent(Event event) {
        Log.d("EventLogPlug <--",event.toString());
    }

    @Override
    public Class<Event> getEventClass() {
        return Event.class;
    }
}
