package com.example.fungwah.androidhomework3.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fungwah.androidhomework3.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ofw on 2017/10/12.
 */

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        listView = (ListView) findViewById(R.id.listview);

        list.add("我是第一项");
        list.add("我是第二项");
        list.add("我是第三项");
        list.add("我是第四项");
        list.add("我是第五项");

        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int position) {
                return list.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView==null){
                    convertView = new TextView(ListViewActivity.this);
                    convertView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,400));
                }
                ((TextView)convertView).setTextSize(28);
                ((TextView)convertView).setText(list.get(position));
                return convertView;
            }

        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this, list.get(i), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
