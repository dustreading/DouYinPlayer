package com.whuuuuu.douyinplayer.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.whuuuuu.douyinplayer.adapter.HomeAdapter
import com.whuuuuu.douyinplayer.model.HomeItemBean
import com.whuuuuu.douyinplayer.widget.HomeItemView
import com.whuuuuu.douyinplayer.widget.LoadMoreView

/**
 * ClassName:BaseListAdapter
 * Description:所有下拉刷新和上拉加载更多列表界面adapter的基类
 */
abstract class BaseListAdapter<ITEMBEAN, ITEMVIEW:View>:RecyclerView.Adapter<BaseListAdapter.BaseListHolder>(){

    private var list = ArrayList<ITEMBEAN>()
    /**
     * 更新数据要清空集合
     */
    fun updateList(list:List<ITEMBEAN>?){
        list?.let {
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    /**
     * 加载更多不需要清空集合
     */
    fun loadMore(list:List<ITEMBEAN>?){
        list?.let {
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    override fun onBindViewHolder(holder: BaseListHolder, position: Int) {
        //如果是最后一条 不需要刷新view
        if(position==list.size)return
        //条目数据
        val data = list.get(position)
        //条目view
        val itemView = holder?.itemView as ITEMVIEW
        //条目刷新
        refreshItemView(itemView, data)
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseListHolder {
        if(viewType==1){
            //最后一条
            return BaseListHolder(LoadMoreView(parent?.context))
        }else{
            //其他条目
            return BaseListHolder(getItemView(parent?.context))
        }
    }

    class BaseListHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    /**
     * 刷新条目view
     */
    abstract fun refreshItemView(itemView: ITEMVIEW, data: ITEMBEAN)

    /**
     * 获取条目view
     */
    abstract fun getItemView(context: Context?): ITEMVIEW
}