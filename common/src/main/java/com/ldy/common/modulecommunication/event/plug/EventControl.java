package com.ldy.common.modulecommunication.event.plug;

import com.ldy.common.modulecommunication.event.Event;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldy on 2017/6/22.
 */

public class EventControl {
    private static final EventControl instance = new EventControl();

    public static EventControl getInstance() {
        return instance;
    }

    private EventControl() {
    }

    public void post(Event event){
        preEvent(event);
        EventBus.getDefault().post(event);
        postEvent(event);
    }

    private List<EventPlug> eventPlugs;

    public void registerPlug(EventPlug eventPlug) {
        if (eventPlugs == null) {
            eventPlugs = new ArrayList<>();
        }
        eventPlugs.add(eventPlug);
    }

    public void unRegisterPlug(EventPlug eventPlug) {
        if (eventPlugs != null && eventPlugs.contains(eventPlug)) {
            eventPlugs.remove(eventPlug);
        }
    }

    private boolean preEvent(Event event){
        for (EventPlug eventPlug : eventPlugs) {
            if (eventPlug.getEventClass().isAssignableFrom(event.getClass())){
                if (eventPlug.preEvent(event)){
                    return true;
                }
            }
        }
        return false;
    }

    private void postEvent(Event event){
        for (EventPlug eventPlug : eventPlugs) {
            if (eventPlug.getEventClass().isAssignableFrom(event.getClass())){
                eventPlug.postEvent(event);
            }
        }
    }
}
