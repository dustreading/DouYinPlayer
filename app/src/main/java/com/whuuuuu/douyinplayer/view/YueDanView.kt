package com.whuuuuu.douyinplayer.view

import com.itheima.player.model.bean.YueDanBean
import com.whuuuuu.douyinplayer.model.HomeItemBean

interface YueDanView {
    /**
     * 获取数据失败
     */
    fun onError(list: String?)

    /**
     * 初始化数据或者刷新数据成功
     */
    fun loadSuccess(response: YueDanBean?)

    /**
     * 加载更多数据成功
     */
    fun loadMore(response: YueDanBean?)
}