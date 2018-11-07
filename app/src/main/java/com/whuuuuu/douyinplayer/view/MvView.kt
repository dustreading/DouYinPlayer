package com.whuuuuu.douyinplayer.view

import com.whuuuuu.douyinplayer.model.MvBean

interface MvView {
    abstract fun onError(msg: String?)
    abstract fun onSuccess(result: List<MvBean>)
}