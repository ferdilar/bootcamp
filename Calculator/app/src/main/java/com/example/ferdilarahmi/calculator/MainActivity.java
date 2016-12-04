package com.example.ferdilarahmi.calculator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ferdila Rahmi on 12/3/2016.
 */
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.et_one)
    EditText etOne;
    @Bind(R.id.et_two)
    EditText etTwo;
    @Bind(R.id.btn_add)
    Button btnAdd;
    @Bind(R.id.et_three)
    EditText etThree;
    @Bind(R.id.btn_res)
    Button btnRes;
    @Bind(R.id.tv_res)
    TextView tvRes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
         /*old*/
        /*btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int int1 = Integer.parseInt(etOne.getText().toString());
                int int2 = Integer.parseInt(etTwo.getText().toString());
                int result = int1+int2;
                tvRes.setText(String.valueOf(result));
            }
        });*/
    }

    @OnClick(R.id.btn_add)
    void add(){
        if(etThree.getVisibility()==View.VISIBLE){
            etThree.setVisibility(View.GONE);
            etThree.setText("");
            btnAdd.setText("+");
        }else{
            etThree.setVisibility(View.VISIBLE);
            btnAdd.setText("-");
        }
    }
    @OnClick(R.id.btn_res)
    void res(){
        int int1=0;
        int int2=0;
        int int3=0;
        if(!etOne.getText().toString().equals("")){
            int1 = Integer.parseInt(etOne.getText().toString());
        }
        if(!etTwo.getText().toString().equals("")){
            int2 = Integer.parseInt(etTwo.getText().toString());
        }
        if(!etThree.getText().toString().equals("")){
            int3 = Integer.parseInt(etThree.getText().toString());
        }
        int result1 = (int1 - (int1*int2/100));
        int result2 = (result1 - (result1*int3/100));
        tvRes.setText(String.valueOf(result2));
    }

            /*@OnClick(R.id.btn_add)
            void add(){
                int int1 = Integer.parseInt(etOne.getText().toString());
                int int2 = Integer.parseInt(etTwo.getText().toString());
                int result = int1+int2;
                tvRes.setText(String.valueOf(result));
            }*/

    /*@OnClick({R.id.btn_add, R.id.btn_substract, R.id.btn_multiply, R.id.btn_divided})
    void calculate(View view){
        int int1 = Integer.parseInt(etOne.getText().toString());
        int int2 = Integer.parseInt(etTwo.getText().toString());
        int result = 0;
        switch (view.getId()) {
            case R.id.btn_add : result = int1 + int2;
                break;
            case R.id.btn_substract : result = int1 - int2;
                break;
            case R.id.btn_multiply : result = int1 * int2;
                break;
            case R.id.btn_divided : result = int1 / int2;
                break;
        }
        tvRes.setText(String.valueOf(result));
    }*/
}
