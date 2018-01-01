package com.example.base.presenter

import com.example.base.presenter.view.BaseView

/**
 * MVP presenter基类
 * Created by zct11 on 2017/12/31.
 */
open class BasePresenter<T: BaseView>{
     lateinit var mView:T
}