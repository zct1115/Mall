package com.example.base.ui.activity

import com.example.base.presenter.BasePresenter
import com.example.base.presenter.view.BaseView

/**
 * Created by zct11 on 2017/12/31.
 */
open class BaseMVPActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    lateinit var mPresenter:T

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onError() {

    }

}