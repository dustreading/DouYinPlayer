package com.whuuuuu.douyinplayer.base

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.whuuuuu.douyinplayer.R
import com.whuuuuu.douyinplayer.adapter.HomeAdapter
import com.whuuuuu.douyinplayer.model.HomeItemBean
import com.whuuuuu.douyinplayer.presenter.impi.HomePresenterImpl
import com.whuuuuu.douyinplayer.view.HomeView
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * ClassName:BaseListFragment
 * Description:所有具有下拉刷新和上拉加载更多列表界面的基类
 * 基类抽取
 * HomeView->BaseView
 * Adapter->BaseListAdapter
 * Presenter->BaseLIstPresenter
 */
abstract class BaseListFragment<RESPONSE,ITEMBEAN,ITEMVIEW:View> : BaseFragment(), BaseView<RESPONSE> {
    override fun onError(list: String?) {
        myToast("加载数据失败")
    }

    override fun loadSuccess(response:RESPONSE?) {
        //隐藏刷新控件
        refreshLayout.isRefreshing = false
        //刷新列表
        adapter.updateList(getList(response))
    }

    override fun loadMore(response: RESPONSE?) {
        adapter.loadMore(getList(response))
    }

    //适配
    val adapter by lazy { getSpecialAdapter() }

    val presenter by lazy { getSpecialPresenter() }

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_list, null)
    }

    override fun initListener() {
        //初始化recyclerview
        recycleView.layoutManager = LinearLayoutManager(context)

        recycleView.adapter = adapter

        //初始化刷新控件
        refreshLayout.setColorSchemeColors(Color.RED, Color.YELLOW, Color.GREEN)

        refreshLayout.setOnRefreshListener {
            //刷新监听
            presenter.loadDatas()
        }
        //监听列表的滑动
        recycleView.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                when(newState){
//                    RecyclerView.SCROLL_STATE_IDLE -> {
//                        println("idel")
//                    }
//                    RecyclerView.SCROLL_STATE_DRAGGING -> {
//                        println("drag")
//                    }
//                    RecyclerView.SCROLL_STATE_SETTLING -> {
//                        println("settling")
//                    }
//                }
                if(newState== RecyclerView.SCROLL_STATE_IDLE){
                    //是否最后一条已经显示
                    val layoutManager = recyclerView.layoutManager
                    if(layoutManager is LinearLayoutManager){
                        val manager: LinearLayoutManager = layoutManager
                        val lastPosition = manager.findLastVisibleItemPosition()
                        if(lastPosition==adapter.itemCount-1){
                            //已经是最后一条
                            presenter.loadMore(adapter.itemCount-1)
                        }
                    }
                }
            }
        })
    }

    override fun initData() {
        //初始化数据
        presenter.loadDatas()
    }

    /**
     * 获取适配器adapter
     */
    abstract fun getSpecialAdapter():BaseListAdapter<ITEMBEAN,ITEMVIEW>

    /**
     * 获取presenter
     */
    abstract fun getSpecialPresenter():BaseListPresenter

    /**
     * 从返回结果中获取列表数据集合
     */
    abstract fun getList(response:RESPONSE?):List<ITEMBEAN>?
}