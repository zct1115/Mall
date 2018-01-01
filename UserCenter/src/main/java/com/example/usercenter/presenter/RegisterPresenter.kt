package com.example.usercenter.presenter

import com.example.base.ext.execute
import com.example.base.presenter.BasePresenter
import com.example.base.rx.BaseSubscriber
import com.example.usercenter.presenter.view.RegisterView
import com.example.usercenter.service.RegisterService
import com.example.usercenter.service.impl.RegisterServiceImpl
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by zct11 on 2017/12/31.
 */
open class RegisterPresenter: BasePresenter<RegisterView>() {

   /* @Inject
    lateinit var userService*/

    fun register(phone:String,verifyCode: String,password:String){

        val userService=RegisterServiceImpl()
        userService.register(phone,verifyCode,password)
                .execute(object :BaseSubscriber<Boolean>(){
                    override fun onNext(t: Boolean) {
                        mView.onRegisterResult(t)
                    }
                })


       mView.onRegisterResult(true)
    }
}