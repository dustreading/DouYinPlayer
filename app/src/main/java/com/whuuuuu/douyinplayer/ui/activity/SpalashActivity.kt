package com.whuuuuu.douyinplayer.ui.activity

import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPropertyAnimatorListener
import android.view.View
import com.whuuuuu.douyinplayer.R
import com.whuuuuu.douyinplayer.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity

class SplashActivity:BaseActivity(), ViewPropertyAnimatorListener {
    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initData() {
        ViewCompat.animate(imageView).scaleX(1.0f).scaleY(1.0f).setListener(this).setDuration(2000)
    }

    override fun onAnimationStart(p0: View?) {

    }

    override fun onAnimationCancel(p0: View?) {

    }

    override fun onAnimationEnd(p0: View?) {
        // 进入主界面
        // startActivity<MainActivity>()
        // finish()
        startActivityAndFinish<MainActivity>()
    }
}