package com.example.fungwah.androidhomework3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fungwah.androidhomework3.activity.GellarySwitcherActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.first_btn);

        btn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.first_btn:
                startActivity(new Intent(MainActivity.this, GellarySwitcherActivity.class));
                break;
            case R.id.second_btn:
                break;
            case R.id.third_btn:
                break;
        }
    }
}
