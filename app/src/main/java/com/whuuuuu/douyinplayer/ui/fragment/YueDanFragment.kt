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
import com.whuuuuu.douyinplayer.base.BaseListAdapter
import com.whuuuuu.douyinplayer.base.BaseListFragment
import com.whuuuuu.douyinplayer.base.BaseListPresenter
import com.whuuuuu.douyinplayer.presenter.impi.YueDanPresenterImpl
import com.whuuuuu.douyinplayer.presenter.interf.YueDanPresenter
import com.whuuuuu.douyinplayer.view.YueDanView
import com.whuuuuu.douyinplayer.widget.YueDanItemView
import kotlinx.android.synthetic.main.fragment_list.*

class YueDanFragment: BaseListFragment<YueDanBean, YueDanBean.PlayListsBean, YueDanItemView>() {
    override fun getSpecialAdapter(): BaseListAdapter<YueDanBean.PlayListsBean, YueDanItemView> {
        return YueDanAdapter()
    }

    override fun getSpecialPresenter(): BaseListPresenter {
        return YueDanPresenterImpl(this)
    }

    override fun getList(response: YueDanBean?): List<YueDanBean.PlayListsBean>? {
        return response?.playLists
    }
}