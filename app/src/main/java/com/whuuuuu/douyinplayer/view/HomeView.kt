package com.whuuuuu.douyinplayer.view

import com.whuuuuu.douyinplayer.model.HomeItemBean

/**
 * ClassName: HomeView
 * Description: home界面和presenter交互
 */
interface HomeView {
    /**
     * 获取数据失败
     */
    fun onError(list: String?)

    /**
     * 初始化数据或者刷新数据成功
     */
    fun loadSuccess(list: List<HomeItemBean>?)

    /**
     * 加载更多数据成功
     */
    fun loadMore(list: List<HomeItemBean>?)
}