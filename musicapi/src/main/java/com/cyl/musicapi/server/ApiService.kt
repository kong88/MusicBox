package com.cyl.musicapi.server

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("MusicController/listAlbum")
    fun getAlbum(@Query("singerId") singerId: String): Observable<AlbumInfo>

}