package com.whuuuuu.douyinplayer.presenter.interf

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.whuuuuu.douyinplayer.model.HomeItemBean
import com.whuuuuu.douyinplayer.util.ThreadUtil
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import java.io.IOException

interface HomePresenter {

    /**
     * 上拉加载数据
     */
    fun loadDatas()

    /**
     * 下拉加载更多
     */
    fun loadMore(offset: Int)
}