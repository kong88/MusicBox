package com.cyl.musiclake.ui.music.mv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cyl.musicapi.netease.MvInfoDetail;
import com.cyl.musiclake.R;
import com.cyl.musiclake.base.BaseFragment;
import com.cyl.musiclake.bean.Album2;
import com.cyl.musiclake.common.Extras;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AlbumsFragment extends BaseFragment<AlbumsPresenter2> implements MvListContract.View {

    private static final String TAG = "AlbumsFragment";
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;


    //适配器
    private AlbumsAdater mAdapter;
    private List<Album2> mvList = new ArrayList<>();

    public static AlbumsFragment newInstance() {
        Bundle args = new Bundle();
        AlbumsFragment fragment = new AlbumsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_recyclerview_notoolbar;
    }

    @Override
    public void initViews() {
        //适配器
        mAdapter = new AlbumsAdater(mvList);
        mAdapter.bindToRecyclerView(mRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter.setEnableLoadMore(true);
        mAdapter.setEnableLoadMore(false);
        mPresenter.loadAlbum("1");
//        mAdapter.setOnLoadMoreListener(() -> mRecyclerView.postDelayed(() -> {
//            //成功获取更多数据
//            mPresenter.loadAlbum("1");
//        }, 1000), mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initInjector() {
        mFragmentComponent.inject(this);
    }

    @Override
    protected void loadData() {
        showLoading();
        mvList.clear();
        mPresenter.loadMv(0);
    }

    @Override
    protected void retryLoading() {
        super.retryLoading();
        mvList.clear();
        mPresenter.loadMv(0);
    }

    @Override
    protected void listener() {
        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent(mFragmentComponent.getActivity(), MvDetailActivity.class);
            intent.putExtra(Extras.MV_TITLE, mvList.get(position).getName());
            intent.putExtra(Extras.MV_ID, String.valueOf(mvList.get(position).getId()));
            startActivity(intent);
        });
    }

    @Override
    public void showLoading() {
        super.showLoading();
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
    }


    @Override
    public void showMvList(List<MvInfoDetail> mvList) {

    }

    @Override
    public void showAlbumList(List<Album2> mvList) {
        this.mvList.addAll(mvList);
        mAdapter.setNewData(this.mvList);
    }

}