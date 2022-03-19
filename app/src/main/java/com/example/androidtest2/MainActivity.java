package com.example.androidtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ScriptEngine jse = new ScriptEngineManager().getEngineByName("javascript");

    Button bt_mc, bt_mPlus, bt_mMinus, bt_mr;
    Button bt_division, bt_product, bt_minus, bt_plus, bt_equals;
    Button bt_0, bt_1, bt_2, bt_3, bt_4, bt_5, bt_6, bt_7, bt_8, bt_9;
    Button bt_percent, bt_dot, bt_c;
    ImageButton bt_back;
    EditText et_m, et;

    boolean is_m = false;

    public void init() {
        bt_mc = findViewById(R.id.bt_mc);
        bt_mPlus = findViewById(R.id.bt_mPlus);
        bt_mMinus = findViewById(R.id.bt_mMinus);
        bt_mr = findViewById(R.id.bt_mr);

        bt_division = findViewById(R.id.bt_division);
        bt_product = findViewById(R.id.bt_product);
        bt_minus = findViewById(R.id.bt_minus);
        bt_plus = findViewById(R.id.bt_plus);
        bt_equals = findViewById(R.id.bt_equals);

        bt_0 = findViewById(R.id.bt_0);
        bt_1 = findViewById(R.id.bt_1);
        bt_2 = findViewById(R.id.bt_2);
        bt_3 = findViewById(R.id.bt_3);
        bt_4 = findViewById(R.id.bt_4);
        bt_5 = findViewById(R.id.bt_5);
        bt_6 = findViewById(R.id.bt_6);
        bt_7 = findViewById(R.id.bt_7);
        bt_8 = findViewById(R.id.bt_8);
        bt_9 = findViewById(R.id.bt_9);

        bt_percent = findViewById(R.id.bt_percent);
        bt_dot = findViewById(R.id.bt_dot);
        bt_c = findViewById(R.id.bt_c);

        bt_back = findViewById(R.id.bt_back);

        et_m = findViewById(R.id.et_m);
        et = findViewById(R.id.et);

        // set onClickListener
        bt_division.setOnClickListener(this);
        bt_product.setOnClickListener(this);
        bt_minus.setOnClickListener(this);
        bt_plus.setOnClickListener(this);
//        bt_equals.setOnClickListener(this); //!!

        bt_0.setOnClickListener(this);
        bt_1.setOnClickListener(this);
        bt_2.setOnClickListener(this);
        bt_3.setOnClickListener(this);
        bt_4.setOnClickListener(this);
        bt_5.setOnClickListener(this);
        bt_6.setOnClickListener(this);
        bt_7.setOnClickListener(this);
        bt_8.setOnClickListener(this);
        bt_9.setOnClickListener(this);

        bt_percent.setOnClickListener(this);
        bt_dot.setOnClickListener(this);
        bt_c.setOnClickListener(this);

        bt_back.setOnClickListener(this);
    }


    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    @Override
    public void onClick(View v) {
        String textContent = et.getText().toString();
        if (textContent.equals("error")) {
            et.setText("");
            textContent = "";
        }
        int len = textContent.length();
        char lastChar = len == 0 ? '#' : textContent.charAt(len - 1);
        char last2Char = len <= 1 ? '#' : textContent.charAt(len - 2);
        switch (v.getId()) {
            case R.id.bt_0:
                if (len == 18) return;
                if (len == 1 && lastChar == '0') return;
            case R.id.bt_1:
            case R.id.bt_2:
            case R.id.bt_3:
            case R.id.bt_4:
            case R.id.bt_5:
            case R.id.bt_6:
            case R.id.bt_7:
            case R.id.bt_8:
            case R.id.bt_9:
                if (len == 18) return;
                if (len == 1 && lastChar == '0') et.setText(((Button) v).getText());
                else et.setText(textContent + ((Button) v).getText());
                break;
            case R.id.bt_division:
                if (len == 18) return;
                if (lastChar == '÷') return;
                if (lastChar == '×' || lastChar == '-' || lastChar == '+') {
                    if (!(last2Char == '+' || last2Char == '-' || last2Char == '×' || last2Char == '÷')) {
                        String tmp = textContent.substring(0, len - 1);
                        et.setText(tmp + '÷');
                    }
                    return;
                }
                et.setText(textContent + "÷");
                break;
            case R.id.bt_product:
                if (len == 18) return;
                if (lastChar == '×') return;
                if (lastChar == '÷' || lastChar == '-' || lastChar == '+') {
                    if (!(last2Char == '+' || last2Char == '-' || last2Char == '×' || last2Char == '÷')) {
                        String tmp = textContent.substring(0, len - 1);
                        et.setText(tmp + '×');
                    }
                    return;
                }
                et.setText(textContent + "×");
                break;
            case R.id.bt_minus:
                if (len == 18) return;
                if (lastChar == '-') return;
                if (lastChar == '+') {
                    String tmp = textContent.substring(0, len - 1);
                    et.setText(tmp + '-');
                    return;
                }
                if (!(last2Char == '+' || last2Char == '-' || last2Char == '×' || last2Char == '÷')) {
                    et.setText(textContent + "-");
                }
                break;
            case R.id.bt_plus:
                if (len == 18) return;
                if (lastChar == '+') return;
                if (lastChar == '÷' || lastChar == '-' || lastChar == '×') {
                    if (!(last2Char == '+' || last2Char == '-' || last2Char == '×' || last2Char == '÷')) {
                        String tmp = textContent.substring(0, len - 1);
                        et.setText(tmp + '+');
                    }
                    return;
                }
                et.setText(textContent + "+");
                break;
            case R.id.bt_percent:
                if (len == 18) return;
                et.setText(textContent + "%");
                break;
            case R.id.bt_dot:
                if (len == 18) return;
                if (lastChar == '.') return;
                et.setText(textContent + ".");
                break;
            case R.id.bt_back:
                int tmplen = textContent.length() - 1;
                if (tmplen <= 0) {
                    et.setText("");
                } else {
                    String tmp = textContent.substring(0, tmplen);
                    et.setText(tmp);
                }
                break;
            case R.id.bt_c:
                et.setText("");
                break;
        }
    }

    private static final String debug = "debug";

    boolean isExpReasonable(String exp) {
        String[] tmp = exp.split("\\+|-|×|÷");
        for (String s : tmp) {
            Log.d(debug, s);
            int cntDot = 0;
            int len = s.length();
            if (s.charAt(len - 1) == '%') len--;
            for (int i = 0; i < len; ++i) {
                if (s.charAt(i) == '%') return false;
                if (s.charAt(i) == '.') cntDot++;
            }
            if (cntDot > 1) return false;
        }
        return true;
    }

    double changeNumber() {
        String s = et.getText().toString();
        if(!isExpReasonable(s)) {
            et.setText("error");
            return -1;
        }
        s.replace('÷', '/');
        s.replace('×', '*');
        String t = "";
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '÷') t = t + '/';
            else if (s.charAt(i) == '×') t = t + '*';
            else t = t + s.charAt(i);
        }
        String ans = "0";
        Log.d(debug, s);
        Log.d(debug, t);
        s = t;

        try {
            ans = jse.eval(s).toString();
            Log.d(debug, ans);
            et.setText(ans);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return Double.parseDouble(ans);
    }

    double number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        init();


        et.setEnabled(false);
        et_m.setEnabled(false);

        bt_mPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!is_m) {
                    is_m = true;
                    number = 0;
                    et_m.setText("M");
                }

                double tmpNum = changeNumber();
                if (!et.getText().toString().equals("error")) number = number + tmpNum;
                else number = 0;
            }
        });

        bt_mMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!is_m) {
                    is_m = true;
                    number = 0;
                    et_m.setText("M");
                }
                double tmpNum = changeNumber();
                if (!et.getText().toString().equals("error")) number = number - tmpNum;
                else number = 0;
            }
        });

        bt_mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                is_m = false;
                number = 0;
                et_m.setText("");
            }
        });

        bt_mr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!is_m) return;
                String s = "" + number;
                String context = et.getText().toString();
                context = context + s;
                if (context.length() <= 18) et.setText(context);
            }
        });

        bt_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeNumber();
            }
        });
    }
}