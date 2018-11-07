package com.whuuuuu.douyinplayer.ui.fragment

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.whuuuuu.douyinplayer.R
import com.whuuuuu.douyinplayer.adapter.HomeAdapter
import com.whuuuuu.douyinplayer.base.BaseFragment
import com.whuuuuu.douyinplayer.base.BaseListAdapter
import com.whuuuuu.douyinplayer.base.BaseListFragment
import com.whuuuuu.douyinplayer.base.BaseListPresenter
import com.whuuuuu.douyinplayer.model.HomeItemBean
import com.whuuuuu.douyinplayer.presenter.impi.HomePresenterImpl
import com.whuuuuu.douyinplayer.view.HomeView
import com.whuuuuu.douyinplayer.widget.HomeItemView
import kotlinx.android.synthetic.main.fragment_list.*

class HomeFragment:BaseListFragment<List<HomeItemBean>, HomeItemBean, HomeItemView>(){
    override fun getSpecialAdapter(): BaseListAdapter<HomeItemBean, HomeItemView> {
        return HomeAdapter()
    }

    override fun getSpecialPresenter(): BaseListPresenter {
        return HomePresenterImpl(this)
    }

    override fun getList(response: List<HomeItemBean>?): List<HomeItemBean>? {
        return response
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //解绑presenter
        presenter.destoryView()
    }
}