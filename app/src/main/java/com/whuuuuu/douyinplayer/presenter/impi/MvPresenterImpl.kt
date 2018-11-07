package com.whuuuuu.douyinplayer.presenter.impi

import com.whuuuuu.douyinplayer.model.MvBean
import com.whuuuuu.douyinplayer.net.MvRequest
import com.whuuuuu.douyinplayer.net.ResponseHandler
import com.whuuuuu.douyinplayer.presenter.interf.MvPresenter
import com.whuuuuu.douyinplayer.view.MvView

class MvPresenterImpl(val mvView:MvView):MvPresenter, ResponseHandler<List<MvBean>> {
    override fun onError(type: Int, msg: String?) {
        mvView.onError(msg)
    }

    override fun onSuccess(type: Int, result: List<MvBean>) {
        mvView.onSuccess(result)
    }

    override fun loadDatas() {
        MvRequest(this).execute()
    }
}