package com.swarawan.yacretofit.view.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.swarawan.yacretofit.R;
import com.swarawan.yacretofit.model.response.ThreadResponseModel;
import com.swarawan.yacretofit.presenter.ThreadPresenter;
import com.swarawan.yacretofit.view.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rioswarawan on 11/24/16.
 */

public class ThreadActivity extends AppCompatActivity implements IThreadView {

    private RecyclerView rvNews;

    private LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    private ThreadPresenter presenter = new ThreadPresenter(this);

    private List<ThreadResponseModel.ThreadData> data;
    private ThreadAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<>();
        adapter = new ThreadAdapter(this, data);
        
        rvNews = (RecyclerView) findViewById(R.id.rvNews);
        rvNews.setLayoutManager(layoutManager);
        rvNews.setHasFixedSize(true);
        rvNews.setAdapter(adapter);


        presenter.attachView(this);
        presenter.getThread();
    }

    @Override
    public void onSuccessFetching(List<ThreadResponseModel.ThreadData> threads) {
        data.addAll(threads);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFailedFetching(String message) {
        Toast.makeText(ThreadActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
