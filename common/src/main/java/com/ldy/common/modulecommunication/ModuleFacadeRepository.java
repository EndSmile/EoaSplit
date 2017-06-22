package com.ldy.common.modulecommunication;

import android.support.annotation.Nullable;

import java.security.InvalidParameterException;

/**
 * Created by ldy on 2017/6/22.
 * {@link ModuleFacade}的仓储实现
 */

public abstract class ModuleFacadeRepository<T extends ModuleFacade> {
    private T facade;

    /**
     * @return 如果没有实现方或实现方还没有调用{@link #setFacade(object)}，则返回null<p/>
     * 注意：一定要进行判空操作，如果调用是必须的，应该抛出异常
     */
    @Nullable
    public T getFacade() {
        return facade;
    }

    /**
     * 仅供模块的实现者调用，且只能被非空设定一次
     */
    public void setFacade(T facade) {
        if (this.facade != null) {
            throw new InvalidParameterException("facade仅可以被设定一次");
        }
        this.facade = facade;
    }
}
