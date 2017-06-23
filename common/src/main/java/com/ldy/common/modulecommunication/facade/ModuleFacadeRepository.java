package com.ldy.common.modulecommunication.facade;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.reflect.ParameterizedType;
import java.security.InvalidParameterException;

/**
 * Created by ldy on 2017/6/22.
 * {@link ModuleFacade}的仓储实现
 */

public abstract class ModuleFacadeRepository<T extends ModuleFacade> {
    private T facade;

    /**
     * @return 如果没有实现方或实现方还没有调用 {@link #setFacade(ModuleFacade)}，则返回null<p/>
     * 注意：一定要进行判空操作，如果调用是必须的，请调用 {@link #getVerifyFacade()}
     */
    @Nullable
    public T getFacade() {
        return facade;
    }


    /**
     * 适用于强依赖于返回的结果，要求其必须非空，如果还没有初始化，则直接抛出异常
     */
    @NonNull
    public T getVerifyFacade() {
        T facade = getFacade();
        if (facade == null) {
            String facadeName = getFacadeName();
            throw new NullPointerException(facadeName +
                    "不能为null," + facadeName + "模块应该先调用setFacade(ModuleFacade)方法");
        }
        return facade;
    }

    /**
     * 仅供模块的实现者调用，且只能被非空设定一次
     */
    public void setFacade(T facade) {
        if (this.facade != null) {
            throw new InvalidParameterException(getFacadeName() + "仅可以被设定一次");
        }
        this.facade = facade;
    }


    /**
     * @return {@link T}的名字
     */
    private String getFacadeName() {
        if (this.getClass().getGenericSuperclass() instanceof ParameterizedType &&
                ((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments().length > 0) {
            Class facadeClass = (Class) ((ParameterizedType) (this.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[0];
            return toLowerCaseFirstOne(facadeClass.getSimpleName());

        }
        return "";
    }

    /**
     * 首字母转小写
     */
    private static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

}
