package com.hyl.mylibrary.bean

data class HttpResult<T>(val data: T) : BaseBean()

/**
 * banner
 */
data class Banner(val desc: String, val id: Int, val imagePath: String, val isVisible: Int, val order: Int,
    val title: String, val type: Int, val url: String)