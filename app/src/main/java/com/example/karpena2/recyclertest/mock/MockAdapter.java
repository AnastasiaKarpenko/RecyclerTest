package com.example.karpena2.recyclertest.mock;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

public class MockAdapter extends RecyclerView.Adapter<MockHolder> {
    private List<Mock> mMockList;


    @NonNull
    @Override
    public MockHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MockHolder mockHolder, int i) {

    }


    @Override
    public int getItemCount() {
        return mMockList.size();
    }
}
