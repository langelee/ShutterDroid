package io.bitfountain.matthewparker.shutterdroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.bitfountain.matthewparker.shutterdroid.api.Image;
import io.bitfountain.matthewparker.shutterdroid.api.ShutterStock;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    private List<Image> mImages;
    private ImagesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImages = new ArrayList<>();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mAdapter = new ImagesAdapter(this, mImages);
        recyclerView.setAdapter(mAdapter);

        ShutterStock.getRecent(new Date(), new Callback<List<Image>>() {
            @Override
            public void success(List<Image> images, Response response) {
                mImages.clear();
                mImages.addAll(images);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
