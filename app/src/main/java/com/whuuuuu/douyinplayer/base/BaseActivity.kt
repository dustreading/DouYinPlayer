package com.whuuuuu.douyinplayer.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.whuuuuu.douyinplayer.R
import com.whuuuuu.douyinplayer.ui.activity.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_splash.view.*
import me.majiajie.pagerbottomtabstrip.PageNavigationView
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * ClassName:BaseActivity
 * Description:所有activity的基类
 */
abstract class BaseActivity:AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        initListener()
        initData()
        debug { "哈哈" }
    }

    /**
     * 获取布局id
     */
    abstract fun getLayoutId(): Int

    /**
     * adapter listener
     */
    open protected fun initListener() {

    }

    /**
     * 初始化数据
     */
    open protected fun initData() {

    }

    protected fun myToast(msg:String) {
        runOnUiThread { toast(msg) }
    }

    /**
     * 开启一个activity并且finish当前界面
     */
    inline fun <reified T:BaseActivity> startActivityAndFinish() {
        startActivity<T>()
        finish()
    }
}