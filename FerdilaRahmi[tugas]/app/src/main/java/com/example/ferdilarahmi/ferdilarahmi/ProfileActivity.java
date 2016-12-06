package com.example.ferdilarahmi.ferdilarahmi;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ferdila Rahmi on 12/6/2016.
 */
public class ProfileActivity extends AppCompatActivity {
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.btn_personal)
    Button btnPersonal;
    @Bind(R.id.btn_edu)
    Button btnEdu;
    @Bind(R.id.btn_course)
    Button btnCourse;
    @Bind(R.id.line_lay_one)
    LinearLayout linearLayoutOne;
    @Bind(R.id.line_lay_two)
    LinearLayout linearLayoutTwo;
    @Bind(R.id.line_lay_three)
    LinearLayout linearLayoutThree;

    Boolean isResume = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        String name = getIntent().getExtras().getString("name", " ");

        tvName.setText(" "+name+", ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isResume)
        Toast.makeText(this, "Nais tu si yu egein", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        isResume = true;
    }

    @OnClick({R.id.btn_personal, R.id.btn_edu, R.id.btn_course})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_personal:
                linearLayoutOne.setVisibility(View.VISIBLE);
                linearLayoutTwo.setVisibility(View.GONE);
                linearLayoutThree.setVisibility(View.GONE);
                break;
            case R.id.btn_edu:
                linearLayoutOne.setVisibility(View.GONE);
                linearLayoutTwo.setVisibility(View.VISIBLE);
                linearLayoutThree.setVisibility(View.GONE);
                break;
            case R.id.btn_course:
                linearLayoutOne.setVisibility(View.GONE);
                linearLayoutTwo.setVisibility(View.GONE);
                linearLayoutThree.setVisibility(View.VISIBLE);
                break;
        }
    }
}
