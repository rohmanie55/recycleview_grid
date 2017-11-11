package com.mr.rohmani.recyclegrid;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMenu extends AppCompatActivity {
TextView tvJudul, tvDesc;
    ImageView img;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        String[] data = getResources().getStringArray(R.array.menu_title);
        String[] desc = getResources().getStringArray(R.array.menu_desc);
        TypedArray image = getResources().obtainTypedArray(R.array.menu_image);

        Intent i = getIntent();
        if(i.getExtras()!=null){
            index = i.getIntExtra("index",0);
        }

        tvJudul = (TextView) findViewById(R.id.judul);
        tvDesc = (TextView) findViewById(R.id.detail);
        img = (ImageView) findViewById(R.id.gambar);
        tvJudul.setText(data[index]);
        img.setImageResource(image.getResourceId(index, -1));
        tvDesc.setText(desc[index]);
    }
}
