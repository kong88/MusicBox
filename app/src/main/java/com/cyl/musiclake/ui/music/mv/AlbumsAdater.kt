package com.cyl.musiclake.ui.music.mv

import android.graphics.Color
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.cyl.musiclake.R
import com.cyl.musiclake.bean.Album2
import com.cyl.musiclake.utils.CoverLoader

class AlbumsAdater(list: List<Album2>) : BaseQuickAdapter<Album2, BaseViewHolder>(R.layout.item_mv_list, list) {

    override fun convert(helper: BaseViewHolder, detail: Album2) {
        helper.setText(R.id.tv_title, detail.name)
        if (helper.adapterPosition > 2) {
            helper.setTextColor(R.id.tv_num, Color.WHITE)
        } else {
            helper.setTextColor(R.id.tv_num, Color.RED)
        }
        helper.setText(R.id.tv_num, (helper.adapterPosition + 1).toString())
//        helper.setText(R.id.tv_playCount, "播放次数：" + FormatUtil.formatPlayCount(detail.playCount))
        CoverLoader.loadImageView(mContext, detail.cover, helper.getView<ImageView>(R.id.iv_cover))
    }
}