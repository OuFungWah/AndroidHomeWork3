package com.example.fungwah.androidhomework3.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fungwah.androidhomework3.R;

/**
 * Created by FungWah on 2017/10/12.
 */

public class DrawerActivity extends AppCompatActivity {

    private SlidingDrawer drawer;
    private ImageButton imageButton;
    private ListView listView;
    private LinearLayout linearLayout;
    private String arr[] = {"植物大战僵尸","使命召唤","高达破坏者","2K18"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_activity);

        linearLayout = (LinearLayout)findViewById(R.id.content);
        drawer = (SlidingDrawer)findViewById(R.id.sliding_drawer);
        imageButton = (ImageButton)findViewById(R.id.handle);
        listView = new ListView(DrawerActivity.this);
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return arr.length;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                if(view == null){
                    view = new TextView(DrawerActivity.this);
                }
                ((TextView)view).setText(arr[i]);
                ((TextView)view).setTextSize(28);
                return view;
            }
        });
        linearLayout.addView(listView);
        drawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
            @Override
            public void onDrawerOpened() {
                imageButton.setImageResource(R.drawable.down);
            }
        });
        drawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
            @Override
            public void onDrawerClosed() {
                imageButton.setImageResource(R.drawable.up);
            }
        });
        drawer.setOnDrawerScrollListener(new SlidingDrawer.OnDrawerScrollListener() {
            @Override
            public void onScrollStarted() {
                Toast.makeText(DrawerActivity.this, "窗口开始拖动", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onScrollEnded() {
                Toast.makeText(DrawerActivity.this, "结束拖动", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
