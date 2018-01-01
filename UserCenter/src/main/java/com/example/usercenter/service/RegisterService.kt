package com.example.usercenter.service

import rx.Observable

/**
 * Created by zct11 on 2017/12/31.
 */
interface RegisterService{
    fun register(phone:String,verifyCode:String,password:String):Observable<Boolean>
}