package com.hyl.ylwanandroid.mvp.model

import com.hyl.mylibrary.base.BaseModel
import com.hyl.mylibrary.bean.Banner
import com.hyl.mylibrary.bean.HttpResult
import com.hyl.mylibrary.network.RetrofitHelper
import com.hyl.ylwanandroid.mvp.contract.HomeContract
import io.reactivex.Observable

class HomeModel : BaseModel(), HomeContract.Model {
    override fun getBanner(): Observable<HttpResult<List<Banner>>> {
        return RetrofitHelper.service.getBanners()
    }
}