package com.whuuuuu.douyinplayer.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.itheima.player.model.bean.YueDanBean
import com.whuuuuu.douyinplayer.view.YueDanView
import com.whuuuuu.douyinplayer.widget.YueDanItemView

/**
 * ClassName:YueDanAdapter
 * Description:悦单界面adapter
 */
class YueDanAdapter:RecyclerView.Adapter<YueDanAdapter.YueDanHolder>(){
    private var list = ArrayList<YueDanBean.PlayListsBean>()
    /**
     * 更新列表操作
     */
    fun updateList(list:List<YueDanBean.PlayListsBean>?){
        list?.let{
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YueDanHolder {
        return YueDanHolder(YueDanItemView(parent.context))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: YueDanHolder, position: Int) {
        //拿到当前条目的数据
        val data = list.get(position)
        //条目的view
        val itemView = holder.itemView as YueDanItemView
        //view和data绑定
        itemView.setData(data)
    }


    class YueDanHolder(itemView: View?):RecyclerView.ViewHolder(itemView){

    }
}