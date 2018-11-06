package com.whuuuuu.douyinplayer.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.squareup.picasso.Picasso
import com.whuuuuu.douyinplayer.R
import com.whuuuuu.douyinplayer.model.HomeItemBean
import java.time.format.DecimalStyle
import kotlinx.android.synthetic.main.item_home.view.*

class HomeItemView:RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    /**
     * 初始化方法
     */
    init {
        View.inflate(context, R.layout.item_home, this)
    }

    /**
     * 刷新条目的操作
     */
    fun setData(data: HomeItemBean) {
        //歌曲名称
        title.setText(data.title)
        //简介
        desc.setText(data.id)
        //背景图片
        //Picasso.with(context).load(data.cover).into(bg)
        Picasso.get().load(data.cover).into(bg)
    }
}