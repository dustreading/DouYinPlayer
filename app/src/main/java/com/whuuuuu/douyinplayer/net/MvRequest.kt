package com.whuuuuu.douyinplayer.net

import com.whuuuuu.douyinplayer.model.MvBean

class MvRequest(handler:ResponseHandler<List<MvBean>>):
    MRequest<List<MvBean>>(0, "http://47.106.120.64:5000/mv", handler){
    /**
     * 发送网络请求，因为在构建MvRequest的时候需要传入handler，所以我们通过重写接口的回调方法接收返回数据
     */
    fun execute(){
        NetManager.manager.sendRequest(this)
    }
}