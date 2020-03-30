package com.cyl.musicapi.server

import com.google.gson.annotations.SerializedName

data class AlbumInfo(@SerializedName("data")
                         val data: List<AlbumBean>,
                         @SerializedName("code")
                         val code: Int = 0)

data class AlbumBean(@SerializedName("id")
                       val id: String,
                         @SerializedName("name")
                       val name: String,
                         @SerializedName("cover")
                       val cover: String)