package com.ldy.common.base;

import android.support.annotation.NonNull;

/**
 * Created by ldy on 2017/6/22.
 */

public class ComparableWrapper<T> implements Comparable<ComparableWrapper<T>> {
    private final int priority;
    private final T content;

    public ComparableWrapper(int priority, T content) {
        this.priority = priority;
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(@NonNull ComparableWrapper<T> o) {
        return priority - o.priority;
    }

    public static <T> ComparableWrapper<T> buildFirst(T content) {
        return new ComparableWrapper<T>(0,content);
    }
    public static <T> ComparableWrapper<T> buildSecond(T content) {
        return new ComparableWrapper<T>(1,content);
    }
    public static <T> ComparableWrapper<T> buildThird(T content) {
        return new ComparableWrapper<T>(2,content);
    }
    public static <T> ComparableWrapper<T> buildFourth(T content) {
        return new ComparableWrapper<T>(3,content);
    }
    public static <T> ComparableWrapper<T> buildFifth(T content) {
        return new ComparableWrapper<T>(4,content);
    }
    public static <T> ComparableWrapper<T> buildSixth(T content) {
        return new ComparableWrapper<T>(5,content);
    }

    @Override
    public String toString() {
        return "ComparableWrapper{" +
                "priority=" + priority +
                ", content=" + content +
                '}';
    }
}
