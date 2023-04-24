package com.hyl.mylibrary.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by chenxz on 2018/4/21.
 */
object NetWorkUtil {
    /**
     * check NetworkConnected
     *
     * @param context
     * @return
     */
    fun isNetworkConnected(context: Context): Boolean {
        val manager = context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = manager.activeNetworkInfo
        return !(null == info || !info.isConnected)
    }
}