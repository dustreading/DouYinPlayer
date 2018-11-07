package com.whuuuuu.douyinplayer.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.itheima.player.model.bean.YueDanBean
import com.whuuuuu.douyinplayer.base.BaseListAdapter
import com.whuuuuu.douyinplayer.view.YueDanView
import com.whuuuuu.douyinplayer.widget.LoadMoreView
import com.whuuuuu.douyinplayer.widget.YueDanItemView

/**
 * ClassName:YueDanAdapter
 * Description:悦单界面adapter
 */
class YueDanAdapter:BaseListAdapter<YueDanBean.PlayListsBean, YueDanItemView>(){
    override fun refreshItemView(itemView: YueDanItemView, data: YueDanBean.PlayListsBean) {
        itemView.setData(data)
    }

    override fun getItemView(context: Context?): YueDanItemView {
        return YueDanItemView(context)
    }
}
