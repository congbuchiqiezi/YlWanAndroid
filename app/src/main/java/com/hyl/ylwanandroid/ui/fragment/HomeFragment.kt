package com.hyl.ylwanandroid.ui.fragment

import android.util.Log
import android.view.View
import com.hyl.mylibrary.base.BaseMvpFragment
import com.hyl.mylibrary.bean.Banner
import com.hyl.ylwanandroid.R
import com.hyl.ylwanandroid.mvp.contract.HomeContract
import com.hyl.ylwanandroid.mvp.presenter.HomePresenter

class HomeFragment : BaseMvpFragment<HomeContract.View, HomeContract.Presenter>(), HomeContract.View {
    companion object {
        fun getInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun attachLayoutRes(): Int = R.layout.fragment_home
    override fun createPresenter(): HomeContract.Presenter {
        return HomePresenter()
    }

    override fun initView(view: View) {
        super.initView(view)
        mPresenter?.getBanner()
    }

    override fun setBanner(data: List<Banner>) {
        Log.d("HomeFragment", data.toString())
    }

}