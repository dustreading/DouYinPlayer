package com.whuuuuu.douyinplayer.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.itheima.player.model.bean.YueDanBean
import com.whuuuuu.douyinplayer.view.YueDanView
import com.whuuuuu.douyinplayer.widget.LoadMoreView
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

    fun loadMore(list:List<YueDanBean.PlayListsBean>?){
        list?.let{
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YueDanHolder {

        if(viewType==1){
            //刷新控件
            return YueDanHolder(LoadMoreView(parent.context))
        }else{
            //普通条目
            return YueDanHolder(YueDanItemView(parent.context))
        }
    }

    override fun getItemCount(): Int {
        return list.size + 1
    }

    /**
     * 获取不同的条目view样式
     */
    override fun getItemViewType(position: Int): Int {
        if(position==list.size){
            //最后一条 刷新控件
            return 1
        }else{
            //普通条目控件
            return 0
        }
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: YueDanHolder, position: Int) {
        if(position==list.size) return //最后一条加载更多条目，不做处理
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