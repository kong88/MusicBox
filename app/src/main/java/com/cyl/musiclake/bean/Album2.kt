package com.cyl.musiclake.bean

import org.litepal.crud.LitePalSupport
import java.io.Serializable

class Album2 : LitePalSupport, Serializable {

    var id: String ?= null
    var name: String? = null
    var cover: String? = null


    constructor() {}

//    constructor(id: String, name: String, artistName: String, artistId: Long, count: Int) {
//        this.name = name
//        this.albumId = id
//        this.artistName = artistName
//        this.artistId = artistId
//        this.count = count
//    }
//
//    override fun toString(): String {
//        return "Album{" +
//                "name='" + name + '\''.toString() +
//                ", artistId=" + artistId +
//                ", artistName='" + artistName + '\''.toString() +
//                ", artistId=" + artistId +
//                ", count=" + count +
//                '}'.toString()
//    }
}