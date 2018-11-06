package com.whuuuuu.douyinplayer.ui.fragment

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.whuuuuu.douyinplayer.R
import com.whuuuuu.douyinplayer.adapter.HomeAdapter
import com.whuuuuu.douyinplayer.base.BaseFragment
import com.whuuuuu.douyinplayer.model.HomeItemBean
import com.whuuuuu.douyinplayer.presenter.impi.HomePresenterImpl
import com.whuuuuu.douyinplayer.util.ThreadUtil
import com.whuuuuu.douyinplayer.util.URLProviderUtils
import com.whuuuuu.douyinplayer.view.HomeView
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import java.io.IOException

class HomeFragment:BaseFragment(), HomeView {
    override fun onError(list: String?) {
        myToast("加载数据失败")
    }

    override fun loadSuccess(list: List<HomeItemBean>?) {
        //隐藏刷新控件
        refreshLayout.isRefreshing = false
        //刷新列表
        adapter.updateList(list)
    }

    override fun loadMore(list: List<HomeItemBean>?) {
        adapter.loadMore(list)
    }

    //适配
    val adapter by lazy { HomeAdapter() }
    val presenter by lazy { HomePresenterImpl(this) }
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_home, null)
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
        recycleView.addOnScrollListener(object:RecyclerView.OnScrollListener(){
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
                if(newState==RecyclerView.SCROLL_STATE_IDLE){
                    //是否最后一条已经显示
                    val layoutManager = recyclerView.layoutManager
                    if(layoutManager is LinearLayoutManager){
                        val manager:LinearLayoutManager = layoutManager
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
}
