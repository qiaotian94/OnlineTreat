package com.example.qiaotian.onlinetreatapp.mainWindow;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.qiaotian.onlinetreatapp.R;
import com.example.qiaotian.onlinetreatapp.doctor.FindDoctor;
import com.example.qiaotian.onlinetreatapp.doctor.HealthyRecord;
import com.example.qiaotian.onlinetreatapp.doctor.IllItem;
import com.example.qiaotian.onlinetreatapp.doctor.IllRecoder;
import com.example.qiaotian.onlinetreatapp.doctor.Medicine;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by qiaotian on 2018/3/12.
 */

public class Message extends Fragment{
    private View view;
    //设置数据
    private ImageButton imgbtn1;
    private ImageButton imgbtn2;
    private ImageButton imgbtn3;
    private ImageButton imgbtn4;
    private ImageButton imgbtn5;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_message, null);

        android.support.v7.widget.Toolbar toolbar = view.findViewById(R.id.message_toolbar);
        toolbar.setTitle("我的医生");
        toolbar.setTitleTextColor(Color.WHITE);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

       initData();

    setListener();
      return view;
}


       private void initData() {
        imgbtn1=view.findViewById(R.id.myimgbtn_1);
        imgbtn2=view.findViewById(R.id.myimgbtn_2);
        imgbtn3=view.findViewById(R.id.myimgbtn_3);
        imgbtn4=view.findViewById(R.id.myimgbtn_4);
        imgbtn5=view.findViewById(R.id.myimgbtn_5);

    }
    public void setListener() {
        OnClick onClick = new OnClick();
        imgbtn1.setOnClickListener(onClick);
        imgbtn2.setOnClickListener(onClick);
        imgbtn3.setOnClickListener(onClick);
        imgbtn4.setOnClickListener(onClick);
        imgbtn5.setOnClickListener(onClick);
    }
    private class OnClick implements View.OnClickListener{
        public void onClick(View v){
            Intent inte=null;
            switch(v.getId()){
                case R.id.myimgbtn_1:
                    inte=new Intent(getActivity(),FindDoctor.class);
                    break;
                case R.id.myimgbtn_2:
                    inte=new Intent(getActivity(),Medicine.class);
                    break;
                case R.id.myimgbtn_3:
                  inte=new Intent(getActivity(), IllRecoder.class);
                    break;
                case R.id.myimgbtn_4:
                      inte=new Intent(getActivity(), IllItem.class);
                    break;
                case R.id.myimgbtn_5:
                    inte=new Intent(getActivity(), HealthyRecord.class);
                    break;

            }
            startActivity(inte);
        }
    }


}

