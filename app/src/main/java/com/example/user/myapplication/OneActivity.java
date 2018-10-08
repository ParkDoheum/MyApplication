package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OneActivity extends AppCompatActivity {
    private Button dd1, dd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        _init();
    }

    private void _init() {
        dd1 = findViewById(R.id.btn_1);
        dd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OneActivity.this,"버튼1",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(OneActivity.this, TwoActivity.class);
                startActivity(intent);
            }
        });

        dd2 = findViewById(R.id.btn_2);
        dd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OneActivity.this, ThreeActivity.class);
                startActivity(intent);
                Toast.makeText(OneActivity.this,"버튼2",Toast.LENGTH_SHORT).show();
            }
        });
    }
}



