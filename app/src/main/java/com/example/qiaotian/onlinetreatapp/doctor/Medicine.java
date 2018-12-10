package com.example.qiaotian.onlinetreatapp.doctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.example.qiaotian.onlinetreatapp.Adapter.MedicineAdapter;
import com.example.qiaotian.onlinetreatapp.WebViewActivity.MainHosptial;
import com.example.qiaotian.onlinetreatapp.R;

import java.util.ArrayList;
import java.util.List;


public class Medicine extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private MedicineAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<String> list=new ArrayList<>();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mockData();
        initView();
    }

    /**
     * 模拟数据
     */
    private void mockData() {
        list = new ArrayList<String>();
         list.add("感冒发热");
        list.add("抗菌消炎");
        list.add("骨科用药");
        list.add("儿科用药");
        list.add("妇科用药");
        list.add("抗肿瘤药");
        list.add("肠胃用药");
    }

    private void initView() {
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MedicineAdapter(list);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());//默认动画效果
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        mAdapter.setOnItemClickListener(new MedicineAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                
                Intent intent = new Intent(view.getContext(),MainHosptial.class);
                view.getContext().startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }
}


