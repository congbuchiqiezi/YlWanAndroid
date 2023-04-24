package com.hyl.mylibrary.base

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<M : IModel, V : IView> : IPresenter<V> {
    protected var mModel: M? = null
    protected var mView: V? = null
    private var mCompositeDisposable: CompositeDisposable? = null

    open fun createModel(): M? = null

    override fun attachView(mView: V) {
        this.mView = mView
        mModel = createModel()
    }

    override fun detachView() { // 保证activity结束时取消所有正在执行的订阅
        unDispose()
        mModel?.onDetach()
        this.mModel = null
        this.mView = null
        this.mCompositeDisposable = null
    }

    private fun unDispose() {
        mCompositeDisposable?.clear()  // 保证Activity结束时取消
        mCompositeDisposable = null
    }
}