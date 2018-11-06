package com.whuuuuu.douyinplayer.net

import com.whuuuuu.douyinplayer.model.HomeItemBean

/**
 * ClassName:HomeRequest
 * Description:首页数据请求类
 */
class HomeRequest(type:Int, offset:Int, handler:ResponseHandler<List<HomeItemBean>>):
    MRequest<List<HomeItemBean>>(type, "http://47.106.120.64:5000/" + offset.toString(), handler) {

    /**
     * 发送网络请求
     */
    fun excute() {
        NetManager.manager.sendRequest(this)
    }

}