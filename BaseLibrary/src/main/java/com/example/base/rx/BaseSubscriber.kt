package com.example.base.rx

import rx.Subscriber


/**
 * 订阅事件
 * Created by zct11 on 2017/12/31.
 */
open class BaseSubscriber<T>:Subscriber<T>(){
    override fun onError(e: Throwable?) {

    }

    override fun onNext(t: T) {

    }

    override fun onCompleted() {

    }

}