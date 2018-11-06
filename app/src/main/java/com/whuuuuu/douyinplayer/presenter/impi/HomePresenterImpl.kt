package com.whuuuuu.douyinplayer.presenter.impi

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.whuuuuu.douyinplayer.model.HomeItemBean
import com.whuuuuu.douyinplayer.presenter.interf.HomePresenter
import com.whuuuuu.douyinplayer.util.ThreadUtil
import com.whuuuuu.douyinplayer.view.HomeView
import okhttp3.*
import java.io.IOException

class HomePresenterImpl(var homeView: HomeView): HomePresenter {

    /**
     * 上拉加载数据
     */
    override fun loadDatas() {
        val path = "http://47.106.120.64:5000/1"
        val client = OkHttpClient()
        val request = Request.Builder().url(path).get().build()
        client.newCall(request).enqueue(object : Callback {
            /**
             * 子线程调用
             */
            override fun onFailure(call: Call?, e: IOException?) {
                ThreadUtil.runOnMainThread(object : Runnable {
                    override fun run() {
                        //回掉到view层处理
                        homeView.onError(e?.message)
                    }
                })
            }

            /**
             * 子线程调用
             */
            override fun onResponse(call: Call?, response: Response?) {
                val result = response?.body()?.string()
                val gson = Gson()
                val list = gson.fromJson<List<HomeItemBean>>(result, object : TypeToken<List<HomeItemBean>>(){}.type)
                ThreadUtil.runOnMainThread(object :Runnable{
                    override fun run() {
                        //将正确的结果回调到view层
                        homeView.loadSuccess(list)
                    }
                })
            }
        })
    }

    /**
     * 下拉加载更多
     */
    override fun loadMore(offset: Int) {
        val path = "http://47.106.120.64:5000/" + offset
        val client = OkHttpClient()
        val request = Request.Builder().url(path).get().build()
        client.newCall(request).enqueue(object : Callback {
            /**
             * 子线程调用
             */
            override fun onFailure(call: Call?, e: IOException?) {
                ThreadUtil.runOnMainThread(object : Runnable {
                    override fun run() {
                        //将错误的信息回调到view层
                        homeView.onError(e?.message)
                    }
                })
            }

            /**
             * 子线程调用
             */
            override fun onResponse(call: Call?, response: Response?) {
                val result = response?.body()?.string()
                val gson = Gson()
                val list = gson.fromJson<List<HomeItemBean>>(result, object :TypeToken<List<HomeItemBean>>(){}.type)
                ThreadUtil.runOnMainThread(object :Runnable{
                    override fun run() {
                        //将加载更多的结果回调到view层
                        homeView.loadMore(list)
                    }
                })
            }
        })
    }
}