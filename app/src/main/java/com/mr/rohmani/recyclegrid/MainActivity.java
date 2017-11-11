package com.mr.rohmani.recyclegrid;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity{
    MyRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] data = getResources().getStringArray(R.array.menu_title);
        TypedArray image = getResources().obtainTypedArray(R.array.menu_image);

        // set up the RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvMakanan);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        adapter = new MyRecyclerViewAdapter(this, data, image);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(
                new recycleClickListener(MainActivity.this, recyclerView, new recycleClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {
                        // TODO Handle item click
                        startActivity(new Intent(MainActivity.this, DetailMenu.class).putExtra("index",position));
                    }

                    @Override
                    public void onLongClick(View view, int position) {}
                })
        );
    }


}
