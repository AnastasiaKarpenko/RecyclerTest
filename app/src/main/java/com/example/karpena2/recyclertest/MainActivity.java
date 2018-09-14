package com.example.karpena2.recyclertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ContactsAdapter.OnItemClickListener{

    // Add a Fragment with RecyclerView | done
    // Add an Adapter, Holder and Generator of Data | done
    // Add data refresh and state of error | done
    // Add data loading from the contacts app | done
    // Handle on click
    // Add decorators

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, RecyclerFragment.newInstance())
                    .commit();
        }
    }

    @Override
    public void onItemClick() {

    }
}
