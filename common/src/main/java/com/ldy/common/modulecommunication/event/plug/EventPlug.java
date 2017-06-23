package com.ldy.common.modulecommunication.event.plug;

import com.ldy.common.modulecommunication.event.Event;

/**
 * Created by ldy on 2017/6/22.
 */

public interface EventPlug<E extends Event> {
    /**
     * 在所有事件之前调用
     * @return 如果结果为true则拦截此事件
     */
    boolean preEvent(E event);

    /**
     * 在所有事件之后调用
     */
    void postEvent(E event);

    /**
     * @return 只会拦截 <p/>
     * <code>
     *    event instanceof E == true
     * </code>
     * <p/> 的事件
     */
    Class<E> getEventClass();
}
