package com.example.ferdilarahmi.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    final public static int RC_CHANGE_INPUT=10;
    @Bind(R.id.btn)
    Button btn;
    @Bind(R.id.et_one)
    EditText etOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn)
    public void onClick() {
        Intent intent = new Intent(this, NextActivity.class);
        String data = etOne.getText().toString();
        intent.putExtra("input", data);
        startActivityForResult(intent,RC_CHANGE_INPUT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_CHANGE_INPUT && resultCode == RESULT_OK){
            String result = data.getExtras().getString("result");
            etOne.setText(result);
        }
    }
}
