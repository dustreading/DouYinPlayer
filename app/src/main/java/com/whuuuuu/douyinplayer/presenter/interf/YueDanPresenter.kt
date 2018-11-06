package com.whuuuuu.douyinplayer.presenter.interf

interface YueDanPresenter {
    companion object {
        val TYPE_INIT_OR_REFRESH = 1
        val TYPE_LOAD_MORE = 2
    }

    /**
     * 上拉加载数据
     */
    fun loadDatas()

    /**
     * 下拉加载更多
     */
    fun loadMore(offset: Int)
}