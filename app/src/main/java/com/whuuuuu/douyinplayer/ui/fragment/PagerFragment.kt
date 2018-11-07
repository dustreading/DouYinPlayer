package com.whuuuuu.douyinplayer.ui.fragment

import android.graphics.Color
import android.view.View
import android.widget.TextView
import com.whuuuuu.douyinplayer.R
import com.whuuuuu.douyinplayer.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_mv.*
import kotlinx.android.synthetic.main.fragment_mv.view.*

class PagerFragment:BaseFragment() {
    var name:String = ""
    override fun init() {
        name = arguments?.get("args").toString()
    }
    override fun initView(): View? {
//        val textView = TextView(context)
//        textView.text = name
//        textView.setTextColor(Color.RED)
//        return textView
        return View.inflate(context, R.layout.fragment_mv, null)
    }
}