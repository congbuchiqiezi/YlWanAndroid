package com.hyl.mylibrary.base

interface IPresenter<V : IView> {
    /**
     * 绑定 View
     */
    fun attachView(mView: V)

    /**
     * 解绑 View
     */
    fun detachView()
}