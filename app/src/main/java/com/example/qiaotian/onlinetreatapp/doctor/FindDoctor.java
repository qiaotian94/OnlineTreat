package com.example.qiaotian.onlinetreatapp.doctor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.qiaotian.onlinetreatapp.Adapter.ApplicationAdapter;
import com.example.qiaotian.onlinetreatapp.R;
import com.example.qiaotian.onlinetreatapp.javabean.ApplicationBean;

import java.util.ArrayList;

public class FindDoctor extends AppCompatActivity {

        RecyclerView mRecyclerView;
        private GridLayoutManager mLayoutManager;
        private ArrayList<ApplicationBean> mDataList;
        private ApplicationAdapter mAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_find_doctor);
            mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
            mockData();
            initView();
        }

        /**
         * 模拟数据
         */
        private void mockData() {
            mDataList = new ArrayList<>();
            ApplicationBean application=new ApplicationBean();
            application.setType(ApplicationBean.Type.TypeOne);
            application.setTitle("推荐医院");
            mDataList.add(application);

                ApplicationBean applicationBean3 = new ApplicationBean();
                applicationBean3.setType(ApplicationBean.Type.TypeTwo);
                applicationBean3.setIcon(R.mipmap.hospital);
                applicationBean3.setName("郑州大学一附院");
                applicationBean3.setInformation("河南省郑州市二七区建设东路1号");
                mDataList.add(applicationBean3);

              ApplicationBean applicationBean2 = new ApplicationBean();
            applicationBean2.setType(ApplicationBean.Type.TypeTwo);
            applicationBean2.setIcon(R.mipmap.hosptial2);
            applicationBean2.setName("河南省人民医院");
            applicationBean2.setInformation("河南省郑州市纬五路7号");
            mDataList.add(applicationBean2);


            ApplicationBean applicationBean4 = new ApplicationBean();
            applicationBean4.setTitle("部分科室");
            applicationBean4.setType(ApplicationBean.Type.TypeOne);
            mDataList.add(applicationBean4);


                ApplicationBean applicationBean5= new ApplicationBean();
                applicationBean5.setType(ApplicationBean.Type.TypeThree);
                applicationBean5.setName("妇产科");
                applicationBean5.setIcon(R.mipmap.fuchan);
                mDataList.add(applicationBean5);

            ApplicationBean applicationBean6= new ApplicationBean();
            applicationBean6.setType(ApplicationBean.Type.TypeThree);
            applicationBean6.setName("骨科");
            applicationBean6.setIcon(R.mipmap.guke);
            mDataList.add(applicationBean6);

            ApplicationBean applicationBean7= new ApplicationBean();
            applicationBean7.setType(ApplicationBean.Type.TypeThree);
            applicationBean7.setName("口腔科");
            applicationBean7.setIcon(R.mipmap.kouqiang);
            mDataList.add(applicationBean7);

            ApplicationBean applicationBean8= new ApplicationBean();
            applicationBean8.setType(ApplicationBean.Type.TypeThree);
            applicationBean8.setName("心理健康科");
            applicationBean8.setIcon(R.mipmap.xinli);
            mDataList.add(applicationBean8);



        }

        private void initView() {
            mLayoutManager = new GridLayoutManager(this, 4);

            mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    ApplicationBean applicationBean = mDataList.get(position);
                    if (applicationBean.getType() == ApplicationBean.Type.TypeOne) {
                        return 4;
                    } else if (applicationBean.getType() == ApplicationBean.Type.TypeTwo) {
                        return 2;
                    } else if (applicationBean.getType() == ApplicationBean.Type.TypeThree) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });
            mRecyclerView.setLayoutManager(mLayoutManager);
            mAdapter = new ApplicationAdapter(mDataList, this);
            mRecyclerView.setAdapter(mAdapter);


        }
    }



