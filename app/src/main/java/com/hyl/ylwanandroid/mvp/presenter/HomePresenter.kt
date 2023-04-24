package com.hyl.ylwanandroid.mvp.presenter

import com.hyl.mylibrary.base.BasePresenter
import com.hyl.mylibrary.bean.Banner
import com.hyl.mylibrary.bean.HttpResult
import com.hyl.mylibrary.utils.NetWorkUtil
import com.hyl.ylwanandroid.app.App
import com.hyl.ylwanandroid.mvp.contract.HomeContract
import com.hyl.ylwanandroid.mvp.model.HomeModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HomePresenter : BasePresenter<HomeContract.Model, HomeContract.View>(), HomeContract.Presenter {
    override fun createModel(): HomeContract.Model {
        return HomeModel()
    }

    override fun getBanner() {
        mModel?.getBanner()?.subscribeOn(Schedulers.io())?.observeOn(Schedulers.io())
                ?.subscribe(object : Observer<HttpResult<List<Banner>>> {
                    override fun onSubscribe(d: Disposable) {
                        mView?.showLoading()
                        mModel?.addDisposable(d)
                        if (!NetWorkUtil.isNetworkConnected(App.instance)) { //todo 为什么引用不到library中的资源
                            //                            mView?.showDefaultMsg(App.instance.resources.getString(R.string.network_unavailable_tip))
                            onComplete()
                        }
                    }

                    override fun onNext(t: HttpResult<List<Banner>>) {
                        mView?.setBanner(t.data)
                    }

                    override fun onError(e: Throwable) {
                    }

                    override fun onComplete() {
                        mView?.hideLoading()
                    }
                })
    }
}