package com.example.fungwah.androidhomework3.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.example.fungwah.androidhomework3.R;

/**
 * Created by FungWah on 2017/10/12.
 */

public class GellarySwitcherActivity extends AppCompatActivity {

    private Gallery gallery;
    private ImageSwitcher switcher;
    private int resArr[] = {R.drawable.cai1, R.drawable.cai2, R.drawable.cai3, R.drawable.cai4, R.drawable.cai5};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g_s_activity);

        switcher = (ImageSwitcher) findViewById(R.id.switcher);
        gallery = (Gallery) findViewById(R.id.gallery);

        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                //新建一个ImageView
                ImageView imageView = new ImageView(GellarySwitcherActivity.this);
                //设置显示模式
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });
        switcher.setInAnimation(this, android.R.anim.fade_in);
        switcher.setOutAnimation(this, android.R.anim.fade_out);
        switcher.setImageResource(resArr[0]);

        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switcher.setImageResource((int) gallery.getItemIdAtPosition(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        gallery.setSpacing(10);
        gallery.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return resArr.length;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return resArr[i];
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                ImageView imageView = new ImageView(GellarySwitcherActivity.this);
                imageView.setImageResource(resArr[i]);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new Gallery.LayoutParams(400, 400));
                return imageView;
            }
        });


    }
}
