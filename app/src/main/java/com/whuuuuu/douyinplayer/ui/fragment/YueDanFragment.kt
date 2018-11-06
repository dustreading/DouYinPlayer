package com.whuuuuu.douyinplayer.ui.fragment

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
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
    }

    override fun initData() {
        //加载数据
        presenter.loadDatas()
    }

    override fun onError(list: String?) {
        myToast("加载数据失败")
    }

    override fun loadSuccess(response: YueDanBean?) {
        //刷新adapter
        adapter.updateList(response?.playLists)
    }

    override fun loadMore(response: YueDanBean?) {
    }
}