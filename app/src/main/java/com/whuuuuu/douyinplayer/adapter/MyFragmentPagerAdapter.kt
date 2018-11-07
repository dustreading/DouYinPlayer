package com.whuuuuu.douyinplayer.adapter

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.View
import com.whuuuuu.douyinplayer.model.MvBean
import com.whuuuuu.douyinplayer.ui.fragment.PagerFragment

class MyFragmentPagerAdapter(val titles:List<MvBean>, val fm: FragmentManager):FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return titles.size
    }

    override fun getItem(p0: Int): Fragment {
//        val fragment = PagerFragment()
//
//        val bundle = Bundle()
//        bundle.putString("args", titles.get(p0).name)
//        fragment.arguments = bundle
//
//        return fragment
        return PagerFragment()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles.get(position).name
    }
}