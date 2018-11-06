package com.whuuuuu.douyinplayer.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.whuuuuu.douyinplayer.R
import com.whuuuuu.douyinplayer.base.BaseActivity
import com.whuuuuu.douyinplayer.util.FragmentUtil
import com.whuuuuu.douyinplayer.util.ToolBarManager
import kotlinx.android.synthetic.main.activity_main.*
import me.majiajie.pagerbottomtabstrip.PageNavigationView
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

class MainActivity : BaseActivity(), ToolBarManager {
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        initMainToolBar()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, FragmentUtil.fragmentUtil.getFragment(0))
        transaction.commit()
    }

    override fun initListener() {
        //初始化下边栏
        var tab:PageNavigationView = tab as PageNavigationView
        var navigationController = tab.material()
            .addItem(R.mipmap.ic_bottom_home_icon, "首页")
            .addItem(R.mipmap.ic_bottom_mv_unselect, "MV")
            .addItem(R.mipmap.ic_bottom_vlist_unselect, "V榜")
            .addItem(R.mipmap.ic_bottom_mvlist_unselect, "阅单")
            .build();
        //设置tab切换的监听
        navigationController.addSimpleTabItemSelectedListener { index, old ->
            // 选中时触发
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, FragmentUtil.fragmentUtil.getFragment(index), index.toString())
                transaction.commit()
            }

    }
}
