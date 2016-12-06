package com.example.ferdilarahmi.calculator;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    @Bind(R.id.btn_substract)
    Button btnSubstract;
    @Bind(R.id.btn_multiply)
    Button btnMultiply;
    @Bind(R.id.btn_divided)
    Button btnDivided;
    @Bind(R.id.tv_res)
    TextView tvRes;
    Boolean isResumeFrontBackground = false ;

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

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isResumeFrontBackground)
            Toast.makeText(this, "On Resume Called", Toast.LENGTH_SHORT).show();
            isResumeFrontBackground = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        etOne.setText("");
        etTwo.setText("");
    }

    /*@OnClick(R.id.btn_add)
            void add(){
                int int1 = Integer.parseInt(etOne.getText().toString());
                int int2 = Integer.parseInt(etTwo.getText().toString());
                int result = int1+int2;
                tvRes.setText(String.valueOf(result));
            }*/

    @OnClick({R.id.btn_add, R.id.btn_substract, R.id.btn_multiply, R.id.btn_divided})
    void calculate(View view) {
        int int1 = Integer.parseInt(etOne.getText().toString());
        int int2 = Integer.parseInt(etTwo.getText().toString());
        int result = 0;
        switch (view.getId()) {
            case R.id.btn_add:
                result = int1 + int2;
                break;
            case R.id.btn_substract:
                result = int1 - int2;
                break;
            case R.id.btn_multiply:
                result = int1 * int2;
                break;
            case R.id.btn_divided:
                result = int1 / int2;
                break;
        }
        tvRes.setText(String.valueOf(result));
    }
}
