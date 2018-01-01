package com.example.usercenter.service.impl

import com.example.usercenter.service.RegisterService
import rx.Observable
import javax.inject.Inject


/**
 * Created by zct11 on 2017/12/31.
 */
class RegisterServiceImpl @Inject constructor() :RegisterService{
    override fun register(phone: String, verifyCode: String, password: String): Observable<Boolean> {
            return Observable.just(true)
    }

}