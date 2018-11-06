package com.whuuuuu.douyinplayer.net

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.whuuuuu.douyinplayer.model.HomeItemBean
import com.whuuuuu.douyinplayer.util.ThreadUtil
import okhttp3.*
import java.io.IOException

/**
 * ClassName:NetManager
 * Description:发送网络请求类 单例模式
 */
class NetManager private constructor(){
    val client by lazy { OkHttpClient() }
    companion object {
        val manager by lazy { NetManager() }
    }

    /**
     * 发送网络请求
     */
    fun <RESPONSE>sendRequest(req:MRequest<RESPONSE>){
        val request = Request.Builder().url(req.url).get().build()
        client.newCall(request).enqueue(object : Callback {
            /**
             * 子线程调用
             */
            override fun onFailure(call: Call?, e: IOException?) {
                ThreadUtil.runOnMainThread(object : Runnable {
                    override fun run() {
                        //回掉到view层处理
                        req.handler.onError(req.type, e?.message)
                    }
                })
            }

            /**
             * 子线程调用
             */
            override fun onResponse(call: Call?, response: Response?) {
                val result = response?.body()?.string()
                val parseResult = req.parseResult(result)
                ThreadUtil.runOnMainThread(object :Runnable{
                    override fun run() {
                        req.handler.onSuccess(req.type, parseResult)
                    }
                })
            }
        })
    }
}