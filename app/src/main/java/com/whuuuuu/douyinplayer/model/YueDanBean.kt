package com.itheima.player.model.bean

/**
 * ClassName:YueDanBean
 * Description:
 */
class YueDanBean {

    var playLists: List<PlayListsBean>? = null

    class PlayListsBean {
        var id: String? = null
        var title: String? = null
        var tags: String? = null
        var like: String? = null
        var nolike: String? = null
        var cover: String? = null
        var views: String? = null
        var addtime: String? = null
        var mhost: String? = null
        var type: Int = 0
        var cursor: Int = 0
        var desc: Int = 0
        var is_new: Int = 0
        var link: String? = null
        var video: String? = null
    }
}
