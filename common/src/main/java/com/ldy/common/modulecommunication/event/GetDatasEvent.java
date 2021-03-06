package com.ldy.common.modulecommunication.event;

import android.support.annotation.NonNull;

import com.ldy.common.util.GenericityUtil;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ldy on 2017/6/22.
 * 被设计为需要其它模块提供数据时，而数据的提供方又不确定，发出此事件，由其它模块调用此事件的
 * {@link #add(Object)}接口添加数据
 */

public abstract class GetDatasEvent<E> implements Iterable<E>, Event {
    protected List<E> dataList = new ArrayList<>();

    public boolean add(E t) {
        return dataList.add(t);
    }

    public E get(int index) {
        return dataList.get(index);
    }

    public int size() {
        return dataList.size();
    }

    public List<E> getDataList() {
        return dataList;
    }

    @Override
    @NonNull
    public Iterator<E> iterator() {
        return dataList.iterator();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+"{" +
                "dataList=" + dataList +
                '}';
    }

}