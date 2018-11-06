package com.whuuuuu.douyinplayer.util

import android.content.Intent
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Toast
import com.whuuuuu.douyinplayer.R
import com.whuuuuu.douyinplayer.ui.activity.SettingActivity

/**
 * ClassName:ToolBarManager
 * Description:所有界面toolbar的管理类
 */
interface ToolBarManager {
    val toolbar:Toolbar
    /**
     * 初始化主界面中的toolbar
     */
    fun initMainToolBar(){
        toolbar.setTitle("马哥影音")
        toolbar.inflateMenu(R.menu.main)

        toolbar.setOnMenuItemClickListener {
            toolbar.context.startActivity(Intent(toolbar.context, SettingActivity::class.java))
            true
        }

//        toolbar.setOnMenuItemClickListener(object:Toolbar.OnMenuItemClickListener {
//            override fun onMenuItemClick(item: MenuItem?): Boolean {
//                when(item?.itemId){
//                    R.id.setting->{
//                        // 跳转到设置界面
//                        toolbar.context.startActivity(Intent(toolbar.context, SettingActivity::class.java))
//                    }
//                }
//                return true
//            }
//        })
    }

    /**
     * 处理设置界面的toolbar
     */
    fun initSettingToolbar() {
        toolbar.setTitle("设置界面")
    }
}