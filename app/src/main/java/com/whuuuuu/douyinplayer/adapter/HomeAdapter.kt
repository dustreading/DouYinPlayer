package com.whuuuuu.douyinplayer.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.whuuuuu.douyinplayer.base.BaseListAdapter
import com.whuuuuu.douyinplayer.model.HomeItemBean
import com.whuuuuu.douyinplayer.widget.HomeItemView
import com.whuuuuu.douyinplayer.widget.LoadMoreView

class HomeAdapter:BaseListAdapter<HomeItemBean, HomeItemView>(){
    override fun refreshItemView(itemView: HomeItemView, data: HomeItemBean) {
        itemView.setData(data)
    }

    override fun getItemView(context: Context?): HomeItemView {
        return HomeItemView(context)
    }

}