package com.example.ferdilarahmi.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ferdila Rahmi on 12/4/2016.
 */
public class NextActivity extends AppCompatActivity {

    @Bind(R.id.btn)
    Button btn;
    @Bind(R.id.et_one)
    EditText etOne;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        ButterKnife.bind(this);

        String data = getIntent().getExtras().getString("input");
        etOne.setText(data);
    }

    @OnClick(R.id.btn)
    public void finishWithResult() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("result", etOne.getText().toString());
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
