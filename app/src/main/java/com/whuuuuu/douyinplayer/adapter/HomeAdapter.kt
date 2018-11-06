package com.whuuuuu.douyinplayer.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.whuuuuu.douyinplayer.model.HomeItemBean
import com.whuuuuu.douyinplayer.widget.HomeItemView
import com.whuuuuu.douyinplayer.widget.LoadMoreView

class HomeAdapter:RecyclerView.Adapter<HomeAdapter.HomeHolder>() {
    private var list = ArrayList<HomeItemBean>()
    /**
     * 更新数据要清空集合
     */
    fun updateList(list:List<HomeItemBean>?){
        list?.let {
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    /**
     * 加载更多不需要清空集合
     */
    fun loadMore(list:List<HomeItemBean>?){
        list?.let {
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        //如果是最后一条 不需要刷新view
        if(position==list.size)return
        //条目数据
        val data = list.get(position)
        //条目view
        val itemView = holder.itemView as HomeItemView
        //条目刷新
        itemView.setData(data)
    }

    override fun getItemViewType(position: Int): Int {
        if(position==list.size){
            //最后一条
            return 1
        }else{
            //普通条目
            return 0
        }
    }

    override fun getItemCount(): Int {
        return list.size+1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        if(viewType==1){
            //最后一条
            return HomeHolder(LoadMoreView(parent?.context))
        }else{
            //其他条目
            return HomeHolder(HomeItemView(parent?.context))
        }
    }

    class HomeHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }

}