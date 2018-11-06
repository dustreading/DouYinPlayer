package com.whuuuuu.douyinplayer.ui.activity

import android.preference.PreferenceManager
import android.support.v7.widget.Toolbar
import com.whuuuuu.douyinplayer.R
import com.whuuuuu.douyinplayer.base.BaseActivity
import com.whuuuuu.douyinplayer.util.ToolBarManager
import org.jetbrains.anko.find

/**
 * ClassName:SettingActivity
 * Description:设置界面
 */
class SettingActivity:BaseActivity(),ToolBarManager{
    override val toolbar: Toolbar by lazy { find<Toolbar>(R.id.toolbar )}
    override fun getLayoutId(): Int {
        return R.layout.activity_setting
    }

    override fun initData() {
        initSettingToolbar()
        //获取推送通知有没有选中
        val sp = PreferenceManager.getDefaultSharedPreferences(this)
        val push = sp.getBoolean("push", false)
        println("push=$push")
    }
}