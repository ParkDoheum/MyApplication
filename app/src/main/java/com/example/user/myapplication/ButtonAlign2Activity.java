package com.example.user.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ButtonAlign2Activity extends AppCompatActivity {
    private TextView tv_content;
    private Button btn_1, btn_2, btn_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_align2);
        tv_content = findViewById(R.id.tv_content);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
    }

    public void clkBtn1(View v) {
        Button btn = (Button)v;
        tv_content.setText(btn.getText());

        if(v.getId() == R.id.btn_1) {
            btn_1.setText("1");
            btn_2.setText("0");
            btn_3.setText("0");
        } else if (v.getId() == R.id.btn_2) {
            btn_1.setText("0");
            btn_2.setText("2");
            btn_3.setText("0");
        } else if(v.getId() == R.id.btn_3) {
            btn_1.setText("0");
            btn_2.setText("0");
            btn_3.setText("3");
        }
    }
}
