package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//계산기
public class TwoActivity extends AppCompatActivity {
    EditText et_no1, et_no2;
    TextView tv_calc_symbol, tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        _init();
    }

    private void _init() {
        setTitle(R.string.calcTitle);
        et_no1 = findViewById(R.id.et_no1);
        et_no1.setShowSoftInputOnFocus(false);
        et_no2 = findViewById(R.id.et_no2);
        et_no2.setShowSoftInputOnFocus(false);

        tv_calc_symbol = findViewById(R.id.tv_calc_symbol);
        tv_result = findViewById(R.id.tv_result);
    }

    private int intParseFromString(String v) {
        int result = -1;
        try {
            result = Integer.parseInt(v);
        }catch(Exception e) {}
        return result;
    }

    private String doCalc(String v1, String v2, String symbol) {
        String result = "";
        int intV1 = intParseFromString(v1);
        int intV2 = intParseFromString(v2);


        switch(symbol) {
            case "+":
                result = Integer.toString(intV1 + intV2);
                break;
            case "-":
                result = Integer.toString(intV1 - intV2);
                break;
            case "/":
                if(intV2 == 0) {
                    result = "DIV 0";
                } else {
                    result = Double.toString((double)intV1 / intV2);
                }
                break;
            case "*":
                result = Integer.toString(intV1 * intV2);
                break;
        }
        return result;
    }

    //숫자 버튼 이벤트
    public void clkNoBtn(View view) {
        Log.i("test","이벤트 연결 성공!");

        String calcSymbol = tv_calc_symbol.getText().toString();

        if(view.getId() == R.id.btn_equal) {
            String val_1 = et_no1.getText().toString();
            String val_2 = et_no2.getText().toString();

            if(calcSymbol.equals("") || val_1.equals("") || val_2.equals("")) {
                tv_result.setText("Incomplete");
            } else {
                String result = doCalc(val_1, val_2, calcSymbol);
                tv_result.setText(result);
            }
        } else {
            //입력할 EditText 결정
            EditText target = null;
            if(calcSymbol.equals("")) {
                target = et_no1;
            } else {
                target = et_no2;
            }

            if(target != null) {
                if(view instanceof Button) {
                    //누른 버튼의 텍스트 값
                    Button b = (Button)view;
                    String pressNo = b.getText().toString();

                    //기존에 있던 텍스트 값 + 누른 버튼의 텍스트 값
                    String existValue = target.getText().toString();
                    existValue += pressNo;

                    //합친 텍스트 값을 다시 타겟에 입력
                    target.setText(existValue);
                }
            }
        }


    }

    //오른쪽 버튼 이벤트
    public void clkRightBtn(View v) {
        if(v instanceof Button) {
            Button b = (Button)v;
            String str = b.getText().toString();// "/"
            if(str.equals("C")) {
                et_no1.setText("");
                et_no2.setText("");
                tv_calc_symbol.setText("");
                tv_result.setText("");
            } else {
                tv_calc_symbol.setText(str);
            }

        }
    }
}







