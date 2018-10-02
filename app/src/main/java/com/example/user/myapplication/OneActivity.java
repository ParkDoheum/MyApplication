package com.example.user.myapplication;

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
        init();
    }

    private void init() {
        dd1 = findViewById(R.id.btn_1);
        dd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OneActivity.this,"버튼1",Toast.LENGTH_SHORT).show();
            }
        });

        dd2 = findViewById(R.id.btn_2);
        dd2.setOnClickListener(new Button2());
    }

    class Button2 implements View.OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }
}



