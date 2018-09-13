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

public class RecyclerFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{


    private RecyclerView mRecycler;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private final MockAdapter mMockAdapter = new MockAdapter();

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
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycler.setAdapter(mMockAdapter);
        mMockAdapter.addData(MockGenerator.generate(20));
    }

    @Override
    public void onRefresh() {



    }
}
