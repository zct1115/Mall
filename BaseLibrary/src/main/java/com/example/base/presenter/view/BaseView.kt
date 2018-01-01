package com.example.base.presenter.view

/**
 * MVP view 基类回调接口
 * Created by zct11 on 2017/12/31.
 */
interface BaseView {

    fun showLoading()

    fun hideLoading()

    fun onError()
}