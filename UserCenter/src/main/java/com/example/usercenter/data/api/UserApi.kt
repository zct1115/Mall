package com.example.usercenter.data.api

import com.example.base.data.protocal.BaseResp
import com.example.usercenter.data.protocol.RegisterReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 * Created by zct11 on 2018/1/1.
 */
interface UserApi {
    @POST("userCenter/register")
    fun register(@Body req:RegisterReq):Observable<BaseResp<String>>
}