package com.example.ferdilarahmi.ferdilarahmi;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.btn_enter)
    Button btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "tengkyu ... biye", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_enter)
    public void onClick() {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("name", etName.getText().toString());
        startActivity(intent);
    }
}
