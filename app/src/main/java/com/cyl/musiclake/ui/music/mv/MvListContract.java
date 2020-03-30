package com.cyl.musiclake.ui.music.mv;

import com.cyl.musicapi.netease.MvInfoDetail;
import com.cyl.musicapi.netease.MvInfoDetailInfo;
import com.cyl.musiclake.base.BaseContract;
import com.cyl.musiclake.bean.Album2;

import java.util.List;


public interface MvListContract {

    interface View extends BaseContract.BaseView {
        void showMvList(List<MvInfoDetail> mvList);
        void showAlbumList(List<Album2> mvList);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void loadMv(int offset);

        void loadRecentMv(int limit);

        void loadAlbum(String singerId);
    }
}
