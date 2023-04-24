package com.hyl.ylwanandroid.mvp.contract

import com.hyl.mylibrary.base.IModel
import com.hyl.mylibrary.base.IPresenter
import com.hyl.mylibrary.base.IView
import com.hyl.mylibrary.bean.Banner
import com.hyl.mylibrary.bean.HttpResult
import io.reactivex.Observable

interface HomeContract {
    interface View : IView {
        fun setBanner(data: List<Banner>)
    }

    interface Presenter : IPresenter<View> {
        fun getBanner()
    }

    interface Model : IModel {
        fun getBanner(): Observable<HttpResult<List<Banner>>>
    }
}