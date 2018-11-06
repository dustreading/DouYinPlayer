package com.whuuuuu.douyinplayer.presenter.impi

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.whuuuuu.douyinplayer.model.HomeItemBean
import com.whuuuuu.douyinplayer.net.HomeRequest
import com.whuuuuu.douyinplayer.net.NetManager
import com.whuuuuu.douyinplayer.net.ResponseHandler
import com.whuuuuu.douyinplayer.presenter.interf.HomePresenter
import com.whuuuuu.douyinplayer.presenter.interf.HomePresenter.Companion.TYPE_INIT_OR_REFRESH
import com.whuuuuu.douyinplayer.presenter.interf.HomePresenter.Companion.TYPE_LOAD_MORE
import com.whuuuuu.douyinplayer.util.ThreadUtil
import com.whuuuuu.douyinplayer.view.HomeView
import okhttp3.*
import java.io.IOException

class HomePresenterImpl(var homeView: HomeView?): HomePresenter, ResponseHandler<List<HomeItemBean>> {
    /**
     * 解绑view和presenter
     */
    fun destoryView(){
        if(homeView!=null){
            homeView = null
        }
    }

    //失败
    override fun onError(type:Int, msg: String?) {
        homeView?.onError(msg)
    }

    override fun onSuccess(type:Int, result: List<HomeItemBean>) {
        when(type) {
            TYPE_INIT_OR_REFRESH -> homeView?.loadSuccess(result)
            TYPE_LOAD_MORE -> homeView?.loadMore(result)
        }
    }

    /**
     * 初始化数据或者刷新
     */
    override fun loadDatas() {
        HomeRequest(TYPE_INIT_OR_REFRESH, 0, this).excute()
    }

    /**
     * 下拉加载更多
     */
    override fun loadMore(offset: Int) {
        HomeRequest(TYPE_LOAD_MORE, offset, this).excute()
    }
}