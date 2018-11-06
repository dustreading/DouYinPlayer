package com.whuuuuu.douyinplayer.util

import com.whuuuuu.douyinplayer.R
import com.whuuuuu.douyinplayer.base.BaseFragment
import com.whuuuuu.douyinplayer.ui.fragment.HomeFragment
import com.whuuuuu.douyinplayer.ui.fragment.MvFragment
import com.whuuuuu.douyinplayer.ui.fragment.VBangFragment
import com.whuuuuu.douyinplayer.ui.fragment.YueDanFragment

/**
 * ClassName:FragmentUtil
 * Description:管理fragment的util类
 */
class FragmentUtil private constructor(){ //私有化构造方法
    val homeFragment by lazy { HomeFragment() }
    val mvFragment by lazy { MvFragment() }
    val vbangFragment by lazy { VBangFragment() }
    val yuedangFragment by lazy { YueDanFragment() }
    companion object {
        val fragmentUtil by lazy { FragmentUtil() }
    }

    /**
     * 根据tabid获取对应的fragment
     */
    fun getFragment(tabId:Int):BaseFragment{
        when(tabId) {
            0 -> return homeFragment
            1 -> return mvFragment
            2 -> return vbangFragment
            else -> return yuedangFragment
        }
    }
}