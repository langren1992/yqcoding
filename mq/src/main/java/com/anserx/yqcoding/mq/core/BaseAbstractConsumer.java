package com.anserx.yqcoding.mq.core;

public abstract class BaseAbstractConsumer<D>  implements BaseConsumer<D> {

    @Override
    public abstract void handle(D d);
}
