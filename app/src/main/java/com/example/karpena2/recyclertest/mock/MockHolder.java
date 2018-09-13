package com.example.karpena2.recyclertest.mock;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.karpena2.recyclertest.R;

class MockHolder extends RecyclerView.ViewHolder {
    private TextView mName;
    private TextView mValue;

    public MockHolder(@NonNull View itemView) {
        super(itemView);
        mName = itemView.findViewById(R.id.tv_name);
        mValue = itemView.findViewById(R.id.tv_value);
    }

    public void bind(Mock mock) {
        mName.setText(mock.getName());
        mValue.setText(mock.getValue());
    }


}
