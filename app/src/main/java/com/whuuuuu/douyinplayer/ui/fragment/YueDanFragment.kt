package com.whuuuuu.douyinplayer.ui.fragment

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.itheima.player.model.bean.YueDanBean
import com.whuuuuu.douyinplayer.R
import com.whuuuuu.douyinplayer.adapter.YueDanAdapter
import com.whuuuuu.douyinplayer.base.BaseFragment
import com.whuuuuu.douyinplayer.presenter.impi.YueDanPresenterImpl
import com.whuuuuu.douyinplayer.presenter.interf.YueDanPresenter
import com.whuuuuu.douyinplayer.view.YueDanView
import kotlinx.android.synthetic.main.fragment_list.*

class YueDanFragment:BaseFragment(), YueDanView {
    val adapter by lazy { YueDanAdapter() }
    val presenter by lazy { YueDanPresenterImpl(this) }
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_list, null)
    }

    override fun initListener() {
        recycleView.layoutManager = LinearLayoutManager(context)
        recycleView.adapter = adapter
        //初始化刷新的控件
        refreshLayout.setColorSchemeColors(Color.RED, Color.YELLOW, Color.BLUE)
        //监听刷新控件
        refreshLayout.setOnRefreshListener {
            presenter.loadDatas()
        }
        //监听列表滑动
        recycleView.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                if(newState==RecyclerView.SCROLL_STATE_IDLE){
                    //空闲状态 判断最后可见条目是否列表最后一条
                    val layoutManager = recyclerView?.layoutManager
                    if(!(layoutManager is LinearLayoutManager)) return
                    //显示列表 kotlin智能类型转换
                    val lastPos = layoutManager.findLastVisibleItemPosition()
                    if(lastPos==adapter.itemCount-1){
                        //加载更多已经显示
                        presenter.loadMore(adapter.itemCount-1)
                    }
                }
            }
        })
    }

    override fun initData() {
        //加载数据
        presenter.loadDatas()
    }

    override fun onError(list: String?) {
        //隐藏刷新控件
        refreshLayout.isRefreshing = false
        myToast("加载数据失败")
    }

    override fun loadSuccess(response: YueDanBean?) {
        myToast("加载数据成功")
        //隐藏刷新控件
        refreshLayout.isRefreshing = false
        //刷新adapter
        adapter.updateList(response?.playLists)
    }

    override fun loadMore(response: YueDanBean?) {
        //刷新列表
        adapter.loadMore(response?.playLists)
    }
}