package com.cyl.musiclake.api.server

import com.cyl.musicapi.server.ApiService
import com.cyl.musiclake.bean.Album2
import com.cyl.musiclake.common.Constants
import com.cyl.musiclake.net.ApiManager
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe

object ApiServiceImpl {
    private val TAG = "ApiServiceImpl"

    val apiService by lazy { ApiManager.getInstance().create(ApiService::class.java, Constants.BASE_SERVICE_URL) }

    /**
     * 获取歌单歌曲
     */
    fun getAlbum(singerId: String): Observable<MutableList<Album2>> {
        return apiService.getAlbum(singerId)
                .flatMap { it ->
                    Observable.create(ObservableOnSubscribe<MutableList<Album2>> { e ->
                        try {
                            if (it.code == 200) {
                                val list = mutableListOf<Album2>()
                                it.data?.forEach{
                                    val album = Album2()
                                    album.id = it.id
                                    album.name = it.name
                                    album.cover = it.cover
                                    list.add(album)
                                }
                                e.onNext(list)
                                e.onComplete()
                            } else {
                                e.onError(Throwable("网络异常"))
                            }
                        } catch (ep: Exception) {
                            e.onError(ep)
                        }
                    })
                }
    }
}