package com.whuuuuu.douyinplayer.net

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.whuuuuu.douyinplayer.model.HomeItemBean
import java.lang.reflect.ParameterizedType

/**
 * ClassName:MRequest
 * Description:网络请求基类
 */
open class MRequest<RESPONSE>(val type:Int, val url:String, val handler:ResponseHandler<RESPONSE>) {
    /**
     * 解析网络请求的结果
     */
    fun parseResult(result: String?): RESPONSE {
        val gson = Gson()
        //获取泛型类型
        val type = (this.javaClass.genericSuperclass as ParameterizedType).getActualTypeArguments()[0]
        val list = gson.fromJson<RESPONSE>(result, type)
        return list
    }
}