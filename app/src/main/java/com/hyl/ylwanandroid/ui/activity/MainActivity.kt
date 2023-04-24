package com.hyl.ylwanandroid.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import com.hyl.mylibrary.base.BaseActivity
import com.hyl.ylwanandroid.R
import com.hyl.ylwanandroid.R.layout
import com.hyl.ylwanandroid.ui.fragment.HomeFragment

class MainActivity : BaseActivity() {
    private var mHomeFragment: HomeFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        initView()
    }

    @SuppressLint("CommitTransaction")
    private fun initView() {
        val transaction = supportFragmentManager.beginTransaction()
        if (mHomeFragment == null) {
            mHomeFragment = HomeFragment.getInstance()
            transaction.add(R.id.container, mHomeFragment!!, "home")
        } else {
            transaction.show(mHomeFragment!!)
        }
        transaction.commit()
    }
}