package com.whuuuuu.douyinplayer.model

data class HomeItemBean(
    var id: String,
    var title: String,
    var tags: String?,
    var like: String,
    var nolike: String,
    var cover: String,
    var views: String,
    var addtime: String,
    var mhost: String?,
    var type: Int,
    var cursor: Int,
    var desc: Int,
    var is_new: Int,
    var link: String?,
    var video: String
)