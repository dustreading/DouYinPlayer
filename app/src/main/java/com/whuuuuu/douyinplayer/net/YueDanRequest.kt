package com.whuuuuu.douyinplayer.net

import com.itheima.player.model.bean.YueDanBean
import com.whuuuuu.douyinplayer.util.URLProviderUtils

/**
 * ClassName:YueDanRequest
 * Description:悦单界面网络请求
 */
class YueDanRequest(type:Int, offset:Int, handler:ResponseHandler<YueDanBean>):
    MRequest<YueDanBean>(type, URLProviderUtils.getYueDanUrl(offset, 20), handler) {

    fun excute() {
        NetManager.manager.sendRequest(this)
    }
}