package com.example.karpena2.recyclertest.mock;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.karpena2.recyclertest.R;

import java.util.ArrayList;
import java.util.List;

public class MockAdapter extends RecyclerView.Adapter<MockHolder> {
    private final List<Mock> mMockList = new ArrayList<>();


    @NonNull
    @Override
    public MockHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.li_mock, viewGroup, false);
        return new MockHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MockHolder mockHolder, int i) {
        mockHolder.bind(mMockList.get(i));

    }


    @Override
    public int getItemCount() {
        return mMockList.size();
    }

    public void addData(List<Mock> mocks, boolean refresh) {
        if (refresh) {
            mMockList.clear();
        }

        mMockList.addAll(mocks);
        notifyDataSetChanged();
    }
}
