package com.whuuuuu.douyinplayer.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.itheima.player.model.bean.YueDanBean
import com.squareup.picasso.Picasso
import com.whuuuuu.douyinplayer.R
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import kotlinx.android.synthetic.main.item_yuedan.view.*

/**
 * ClassName:YueDanItemView
 * Description:悦单界面每个条目的自定义view
 */
class YueDanItemView:RelativeLayout{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    init {
        View.inflate(context, R.layout.item_yuedan, this)
    }

    /**
     * 条目view的控件初始化
     */
    fun setData(data: YueDanBean.PlayListsBean) {
        //歌单名称
        title.text = data.title
        //创建者
        author_name.text = data.id
        //歌曲个数
        count.text = data.addtime
        //背景
        Picasso.get().load(data.cover).into(bg)
        //头像
        Picasso.get().load(data.cover).transform(CropCircleTransformation()).into(author_image)
    }
}