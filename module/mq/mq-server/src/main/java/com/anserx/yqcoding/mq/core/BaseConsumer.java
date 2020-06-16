package com.anserx.yqcoding.mq.core;

public interface BaseConsumer<D> {

    void handle(D d);
}
