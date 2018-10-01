package com.example.user.myapplication;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PrintStartActivity extends AppCompatActivity {
    private EditText et_no;
    private Button btn_print;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_start);
        getSupportActionBar().setTitle("별찍기");
        init();
    }

    private int checkInteger(String v) {
        int result = 0;
        try {
            result = Integer.parseInt(v);
        } catch(Exception e) {}
        return result;
    }

    private void init() {
        et_no = findViewById(R.id.et_no);
        btn_print = findViewById(R.id.btn_print);
        btn_print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = et_no.getText().toString();
                int no = checkInteger(value);

                if(no > 0) {
                    String result = "";
                    for(int i=1; i<=no; i++) {
                        for(int j=0; j<i; j++) {
                            result += "*";
                        }
                        result += "\n";
                    }
                    tv_result.setText(result);
                }
            }
        });

        tv_result = findViewById(R.id.tv_result);
    }
}
