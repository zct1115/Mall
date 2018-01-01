package com.example.usercenter.data.repository

import com.example.base.data.net.RetrofitFactory
import com.example.base.data.protocal.BaseResp
import com.example.usercenter.data.api.UserApi
import com.example.usercenter.data.protocol.RegisterReq
import rx.Observable

/**
 * Created by zct11 on 2018/1/1.
 */
class UserRepository{
    fun register(phone:String,password:String, verityCode:String):Observable<BaseResp<String>>{
        return RetrofitFactory.instance.create(UserApi::class.java)
                .register(RegisterReq(phone,password,verityCode))

    }
}