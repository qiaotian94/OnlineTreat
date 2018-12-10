package com.example.qiaotian.onlinetreatapp.mainWindow;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qiaotian.onlinetreatapp.Adapter.DynamicAdapter;
import com.example.qiaotian.onlinetreatapp.Adapter.HomepageRecycleAdapter;
import com.example.qiaotian.onlinetreatapp.R;
import com.example.qiaotian.onlinetreatapp.javabean.ApplicationBean;
import com.example.qiaotian.onlinetreatapp.javabean.Bean;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by qiaotian on 2018/3/12.
 */

public class Dynamic extends Fragment {


    private RecyclerView  mRecyclerView ;
    private View view;
    private ArrayList<Bean> mDataList;
    private RecyclerView.LayoutManager mLayoutManager;
    private DynamicAdapter mAdapter;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dynamic, null);
        android.support.v7.widget.Toolbar toolbar = view.findViewById(R.id.dynamic_toolbar);
        toolbar.setTitle("动态");
        toolbar.setTitleTextColor(Color.WHITE);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        initDate();
        initView();
        return view;

    }


    private void initDate() {
        mDataList= new ArrayList<Bean>();
         Bean data1=new Bean();

        data1.setTitle("恢复人类听力，波士顿公司获A轮3200万美元融资");
        data1.setInformation("位于大波士顿地区的初创公司Frequency Therapeutics近日获得3200万美元A轮融资。该公司的种子轮投资来自CoBro Ventures，还包括Morningside Ventures、Emigrant Capital Corp.、Korean Investment Partnership、Alexandria Real Estate Equities等");
        mDataList.add(data1);

        Bean data2=new Bean();
        data2.setTitle("打破时空限制，远程数字病理离深层应用还有多远？");
        data2.setInformation("近年来全国各地区以一家或多家大型医疗机构为中心的区域性远程数字病理诊断中心如雨后春笋般建立起来，覆盖了越来越多的基层医院，通过远程数字病理会诊平台可进行远程病理诊断、疑难病理专家会诊、远程教学等服务。");
        mDataList.add(data2);

        Bean data3=new Bean();
        data3.setTitle("数问生物和Abcam携手开发伴随诊断试剂");
        data3.setInformation("5月3日，Abcam与数问生物签署了一份合作备忘录，依据此协议，Abcam和数问生物将共同利用双方优势，在生产高质量抗体和伴随诊断试剂盒开发及商业化上深入合作，致力于满足制药行业的需求等");
        mDataList.add(data3);

        Bean data4=new Bean();
        data4.setTitle("FDA批准的伴随诊断产品盘点");
        data4.setInformation("伴随诊断是体外诊断市场中最有发展前景，也是发展最快的领域之一，它通过检测特殊药物在特定患者体内的疗效和安全性来指导治疗方案的制定。");
        mDataList.add(data4);

        Bean data5=new Bean();
        data5.setTitle("美发布首个心脏病患儿心肺复苏声明");
        data5.setInformation("美国一研究团队在最近一期《JAMA 眼科学》杂志上发表论文称，他们开发出一种人工智能（AI）算法，能够自动诊断早产儿视网膜病，诊断准确率要超过大多数专业医生。");
        mDataList.add(data5);

        Bean data6=new Bean();
        data6.setTitle("湖南5家医院医疗器械使用不合规被通报");
        data6.setInformation("近日，湖南省食药监发布了11 起医疗器械经营与使用不合规的通报。其中包括湘潭爱尔眼科医院、株洲华肤皮肤病专科医院、长沙市中心医院、湖南省人民医院、中南大学湘雅医院5 家医疗器械使用单位");
        mDataList.add(data6);

        Bean data7=new Bean();
        data7.setTitle("CRISPR技术让稀有血型供给不再恐慌");
        data7.setInformation("世界范围内，血液供应一直是一项长期挑战。虽然，大多数人可以安全地从血库中拿到所需血液，但是少部分需要频繁反复输血的遗传疾病患者最终会因次要血型抗原水平的不相容性，对几乎所有供体血液产生免疫反应等");
        mDataList.add(data7);

    }

    private void initView() {

        mRecyclerView =  (RecyclerView) view.findViewById(R.id.id_dynamic_recycleview);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new DynamicAdapter(mDataList);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());//默认动画效果
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        mAdapter.setOnItemClickListener(new DynamicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int i = position;
                switch (i) {

                    case 0:

                        Uri uri1 = Uri.parse("http://www.cmdi.org.cn/publish/default/zhixuntop_1/content/2018050416031513805.htm");

                        Intent intent1 = new Intent(Intent.ACTION_VIEW, uri1);

                        startActivity(intent1);
                        break;

                    case 1:


                        Uri uri2 = Uri.parse("http://www.cmdi.org.cn/publish/default/zhixuntop_1/content/2018050415214519536.htm");

                        Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);

                        startActivity(intent2);

                        break;

                    case 2:

                        Uri uri3 = Uri.parse("http://www.cmdi.org.cn/publish/default/zhixuntop_1/content/2018050315392414003.htm");

                        Intent intent3 = new Intent(Intent.ACTION_VIEW, uri3);

                        startActivity(intent3);

                        break;

                    case 3:

                        Uri uri4 = Uri.parse("http://www.cmdi.org.cn/publish/default/zhixuntop_1/content/2018050411273418557.htm");

                        Intent intent4 = new Intent(Intent.ACTION_VIEW, uri4);

                        startActivity(intent4);

                        break;

                    case 4:

                        Uri uri5 = Uri.parse("http://www.cmdi.org.cn/publish/default/zhixuntop_1/content/2018050410224614735.htm");

                        Intent intent5 = new Intent(Intent.ACTION_VIEW, uri5);

                        startActivity(intent5);

                        break;

                    case 5:

                        Uri uri6 = Uri.parse("http://www.cmdi.org.cn/publish/default/zhixuntop_1/content/2018050311100812647.htm");

                        Intent intent6 = new Intent(Intent.ACTION_VIEW, uri6);

                        startActivity(intent6);

                        break;

                    case 6:

                        Uri uri7 = Uri.parse("http://www.cmdi.org.cn/publish/default/zhixuntop_1/content/2018042817191913652.htm");

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

}





