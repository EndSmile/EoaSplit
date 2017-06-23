package com.ldy.common.modulecommunication.event;

import java.util.Collections;

/**
 * Created by ldy on 2017/6/22.
 * 其存在的数据集具有比较性，在添加之后即排序
 */

public abstract class GetSortDatasEvent<E extends Comparable<E>> extends GetDatasEvent<E> {

    @Override
    public boolean add(E t) {
        boolean add = super.add(t);
        if (add) {
            Collections.sort(dataList);
        }
        return add;
    }
}
