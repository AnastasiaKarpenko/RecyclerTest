package com.example.karpena2.recyclertest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ContactsAdapter.OnItemClickListener, LoaderManager.LoaderCallbacks<String> {
    public static final String TAG = MainActivity.class.getSimpleName();
    private String ID = "ID";

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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cancel_request:
                if(getSupportLoaderManager().hasRunningLoaders()) {
                    getSupportLoaderManager().destroyLoader(0);
                    Log.d(TAG, "loader destroyed");
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemClick(String id) {
        Bundle bundle = new Bundle();
        bundle.putString(ID, id);

        getSupportLoaderManager().restartLoader(0, bundle, this).forceLoad();
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new PhoneNumberLoader(this, bundle.getString(ID));
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String s) {
        if (s != null) {
            startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:" + s)));
        } else {
            Toast.makeText(this, "This contact has no number", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}
