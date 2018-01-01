package com.example.base.data.protocal

/**
 * Created by zct11 on 2018/1/1.
 */
class BaseResp<out T> (val status:Int,val message:String, val data:T)