package com.example.karpena2.recyclertest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.karpena2.recyclertest.mock.MockAdapter;
import com.example.karpena2.recyclertest.mock.MockGenerator;

import java.util.Random;

public class RecyclerFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {


    private RecyclerView mRecycler;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private final MockAdapter mMockAdapter = new MockAdapter();
    private View mErrorView;
    private Random mRandom = new Random();


    public static RecyclerFragment newInstance() {

        return new RecyclerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_recycler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mRecycler = view.findViewById(R.id.recycler);
        mSwipeRefreshLayout = view.findViewById(R.id.refresher);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mErrorView = view.findViewById(R.id.error_view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycler.setAdapter(mMockAdapter);
        mMockAdapter.addData(MockGenerator.generate(20), false);
    }

    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                int count = mRandom.nextInt(4);

                if (count == 0) {
                    showError();
                } else {
                    showData(count);
                }


                if (mSwipeRefreshLayout.isRefreshing()) {
                    mSwipeRefreshLayout.setRefreshing(false);
                }

            }
        }, 2000);


    }

    private void showData(int count) {
        mMockAdapter.addData(MockGenerator.generate(count), true);
        mErrorView.setVisibility(View.GONE);
        mRecycler.setVisibility(View.VISIBLE);
    }

    private void showError() {
        mErrorView.setVisibility(View.VISIBLE);
        mRecycler.setVisibility(View.GONE);

    }
}
