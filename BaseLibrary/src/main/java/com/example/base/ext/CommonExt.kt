package com.example.base.ext

import com.example.base.rx.BaseSubscriber
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Observable<T>kotlin扩展函数
 * 封装相同的代码
 * Created by zct11 on 2017/12/31.
 */
fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>) {

    this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(subscriber)
}