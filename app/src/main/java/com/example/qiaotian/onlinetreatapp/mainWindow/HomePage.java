package com.example.qiaotian.onlinetreatapp.mainWindow;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.qiaotian.onlinetreatapp.Adapter.HomepageRecycleAdapter;
import com.example.qiaotian.onlinetreatapp.R;

import com.example.qiaotian.onlinetreatapp.WebViewActivity.HomepageWebView;
import com.example.qiaotian.onlinetreatapp.javabean.Bean;
import com.youth.banner.Banner;

import java.util.ArrayList;

import java.util.List;

/**
 * Created by qiaotian on 2018/3/12.
 */

public class HomePage extends Fragment implements View.OnClickListener{
    private View view;
    private Banner banner;

    Object[] image1 = new Object[]{
          R.drawable.bannerp11,
            R.drawable.bannerp22,
            R.drawable.bannerp33,
            R.drawable.bannerp44,
            R.drawable.bannerp55
    };


    Button homepage_url_0;
   Button homepage_url_1;
   Button homepage_url_2;
    Button homepage_url_3;
   Button homepage_url_4;
   Button homepage_url_5;

    private RecyclerView mRecyclerView;
    private HomepageRecycleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Bean> mDataList=new ArrayList<>();



    int [] image = {R.drawable.pinanyi,R.drawable.pinanyi,R.drawable.pinanyi,R.drawable.pinanyi,

    };

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_homepage, null);

        banner = (Banner)view.findViewById(R.id.banner);

        banner.setBannerStyle(Banner.CIRCLE_INDICATOR);

        banner.setIndicatorGravity(Banner.CENTER);

        banner.isAutoPlay(true);

        banner.setDelayTime(5000);

        banner.setImages(image1);

        banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {//设置点击事件
            @Override
            public void OnBannerClick(View view, int position) {
                Intent inte=null;
                inte=new Intent(getActivity(),HomepageWebView.class);
                startActivity(inte);
            }
        });

        homepage_url_0 = view.findViewById(R.id.homepage_url_0);
        homepage_url_0.setOnClickListener(this);

        homepage_url_1 = view.findViewById(R.id.homepage_url_1);
        homepage_url_1.setOnClickListener(this);

        homepage_url_2 = view.findViewById(R.id.homepage_url_2);
        homepage_url_2.setOnClickListener(this);

        homepage_url_3 = view.findViewById(R.id.homepage_url_3);
        homepage_url_3.setOnClickListener(this);

        homepage_url_4 = view.findViewById(R.id.homepage_url_4);
        homepage_url_4.setOnClickListener(this);

        homepage_url_5 = view.findViewById(R.id.homepage_url_5);
        homepage_url_5.setOnClickListener(this);


        initDate();
        initView();
        return view;
    }



    private void initDate() {
        mDataList= new ArrayList<Bean>();

        Bean data1=new Bean();
        data1.setTitle("外科");
        data1.setInformation("主题: 2718, 帖数: 2821\n" +
                "最后发表: 6 分钟前");
        mDataList.add(data1);

        Bean data2=new Bean();
        data2.setTitle("男科");
        data2.setInformation("主题: 292, 帖数: 296\n" +
                "最后发表: 5 小时前 ");
        mDataList.add(data2);

        Bean data3=new Bean();
        data3.setTitle("妇科");
        data3.setInformation("主题: 478, 帖数: 487\n" +
                "最后发表: 昨天 16:06 ");
        mDataList.add(data3);

        Bean data4=new Bean();
        data4.setTitle("医疗器械");
        data4.setInformation("主题: 587, 帖数: 600\n" +
                "最后发表: 6 小时前 ");
        mDataList.add(data4);

        Bean data5=new Bean();
        data5.setTitle("养生保健");
        data5.setInformation("主题: 111, 帖数: 114\n" +
                "最后发表: 前天 17:22 ");
        mDataList.add(data5);

        Bean data6=new Bean();
        data6.setTitle("整形美容");
        data6.setInformation("主题: 608, 帖数: 613\n" +
                "最后发表: 1 小时前 ");
        mDataList.add(data6);

        Bean data7=new Bean();
        data7.setTitle("内科");
        data7.setInformation("主题: 148, 帖数: 153\n" +
                "最后发表: 17 秒前 ");
        mDataList.add(data7);

        Bean data8=new Bean();
        data8.setTitle("儿科");
        data8.setInformation("主题: 261, 帖数: 288\n" +
                "最后发表: 2018-4-29 14:37 ");
        mDataList.add(data8);

    }

    private void initView() {

        mRecyclerView = (RecyclerView) view.findViewById(R.id.id_homepage_recycleview);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new HomepageRecycleAdapter(mDataList);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());//默认动画效果
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        mAdapter.setOnItemClickListener(new HomepageRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
             int i=position;
                switch (i) {

                    case 0:

                        Uri uri1 = Uri.parse("http://www.come888.cn/forum-65-1.html");

                        Intent intent1 = new Intent(Intent.ACTION_VIEW, uri1);

                        startActivity(intent1);
                        break;

                    case 1:


                        Uri uri2 = Uri.parse("http://www.come888.cn/forum-66-1.html");

                        Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);

                        startActivity(intent2);

                        break;

                    case 2:

                        Uri uri3 = Uri.parse("http://www.come888.cn/forum-67-1.html");

                        Intent intent3 = new Intent(Intent.ACTION_VIEW, uri3);

                        startActivity(intent3);

                        break;

                    case 3:

                        Uri uri4 = Uri.parse("http://www.come888.cn/forum-61-1.html");

                        Intent intent4 = new Intent(Intent.ACTION_VIEW, uri4);

                        startActivity(intent4);

                        break;

                    case 4:

                        Uri uri5 = Uri.parse("http://www.come888.cn/forum-62-1.html");

                        Intent intent5 = new Intent(Intent.ACTION_VIEW, uri5);

                        startActivity(intent5);

                        break;

                    case 5:

                        Uri uri6 = Uri.parse("http://www.come888.cn/forum-63-1.html");

                        Intent intent6 = new Intent(Intent.ACTION_VIEW, uri6);

                        startActivity(intent6);

                        break;

                    case 6:

                        Uri uri7 = Uri.parse("http://www.come888.cn/forum-64-1.html");

                        Intent intent7 = new Intent(Intent.ACTION_VIEW, uri7);

                        startActivity(intent7);

                        break;

                    case 7:

                        Uri uri8 = Uri.parse("http://www.come888.cn/forum-68-1.html");

                        Intent intent8 = new Intent(Intent.ACTION_VIEW, uri8);

                        startActivity(intent8);

                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }


    /**
     * 设置超链接监听
     * @param v
     */
    public void onClick(View v) {

        int id  = v.getId();

        switch (id) {

            case R.id.homepage_url_0:

                Uri uri1 = Uri.parse("http://www.haodf.com/");

                Intent intent1 = new Intent(Intent.ACTION_VIEW, uri1);

                startActivity(intent1);
                break;

            case R.id.homepage_url_1:


                Uri uri2 = Uri.parse("http://www.jk.cn/");

                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);

                startActivity(intent2);

                break;

            case R.id.homepage_url_2:

                Uri uri3 = Uri.parse("http://www.doctorjob.com.cn/");

                Intent intent3 = new Intent(Intent.ACTION_VIEW, uri3);

                startActivity(intent3);

                break;

            case R.id.homepage_url_3:

                Uri uri4 = Uri.parse("http://www.doctorjob.com.cn/");

                Intent intent4 = new Intent(Intent.ACTION_VIEW, uri4);

                startActivity(intent4);

                break;

            case R.id.homepage_url_4:

                Uri uri5 = Uri.parse("http://www.doctorjob.com.cn/");

                Intent intent5 = new Intent(Intent.ACTION_VIEW, uri5);

                startActivity(intent5);

                break;

            case R.id.homepage_url_5:

                Uri uri6 = Uri.parse("http://www.doctorjob.com.cn/");

                Intent intent6 = new Intent(Intent.ACTION_VIEW, uri6);

                startActivity(intent6);

                break;
            default:
                break;
        }

    }


}
