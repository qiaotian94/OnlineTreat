package com.example.qiaotian.onlinetreatapp.doctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.qiaotian.onlinetreatapp.R;
import com.example.qiaotian.onlinetreatapp.login.LoginActivity;
import com.example.qiaotian.onlinetreatapp.login.LogonActivity;
import com.example.qiaotian.onlinetreatapp.record.AddIllActivity;
import com.example.qiaotian.onlinetreatapp.record.LookIllActivity;

public class IllRecoder extends AppCompatActivity {
private Button rebtn1,rebtn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ill_recoder);
        initData();
        initView();
    }

    private void initData() {
        rebtn1=findViewById(R.id.rebtn1);
        rebtn2=findViewById(R.id.rebtn2);

    }
    private void initView() {
        rebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(IllRecoder.this,AddIllActivity.class);
                startActivity(intent);

            }
        });
        rebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(IllRecoder.this,LookIllActivity.class);
                startActivity(intent);

            }
        });
    }
}
