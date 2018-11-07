package com.whuuuuu.douyinplayer.ui.fragment

import android.graphics.Color
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.whuuuuu.douyinplayer.R
import com.whuuuuu.douyinplayer.adapter.MyFragmentPagerAdapter
import com.whuuuuu.douyinplayer.base.BaseFragment
import com.whuuuuu.douyinplayer.model.MvBean
import com.whuuuuu.douyinplayer.presenter.impi.MvPresenterImpl
import com.whuuuuu.douyinplayer.view.MvView
import kotlinx.android.synthetic.main.fragment_mv.*

class MvFragment:BaseFragment(), MvView {
    override fun onError(msg: String?) {
        myToast("加载数据失败")
    }

    override fun onSuccess(result: List<MvBean>) {
        viewPager.adapter = MyFragmentPagerAdapter(result, childFragmentManager)
        myToast("加载数据成功")
    }

    override fun initView(): View? {
        return View.inflate(this.context, R.layout.fragment_mv, null)
    }

    override fun initListener() {
        super.initListener()
    }

    override fun initData() {
        val presenter by lazy{ MvPresenterImpl(this) }
        presenter.loadDatas()
        tabLayout.setupWithViewPager(viewPager)
    }
}