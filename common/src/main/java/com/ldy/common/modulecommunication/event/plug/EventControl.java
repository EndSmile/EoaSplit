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
    private EventBus eventBus;

    public static EventControl instance() {
        return instance;
    }

    private EventControl() {
        eventBus = EventBus.getDefault();
    }

    public void post(Event event) {
        if (!preEvent(event)) {
            eventBus.post(event);
        }
        postEvent(event);
    }

    public void register(Object subscriber) {
        eventBus.register(subscriber);
    }

    public void unregister(Object subscriber) {
        eventBus.unregister(subscriber);
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

    private boolean preEvent(Event event) {
        for (EventPlug eventPlug : eventPlugs) {
            if (eventPlug.getEventClass().isAssignableFrom(event.getClass())) {
                if (eventPlug.preEvent(event)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void postEvent(Event event) {
        for (EventPlug eventPlug : eventPlugs) {
            if (eventPlug.getEventClass().isAssignableFrom(event.getClass())) {
                eventPlug.postEvent(event);
            }
        }
    }
}
