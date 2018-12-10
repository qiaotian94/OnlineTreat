package com.example.qiaotian.onlinetreatapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qiaotian.onlinetreatapp.R;
import com.example.qiaotian.onlinetreatapp.javabean.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiaotian on 2018/3/25.
 */

public class HomepageRecycleAdapter extends RecyclerView.Adapter<HomepageRecycleAdapter.ViewHolder> {

private List<Bean> date=new ArrayList<>();
//构造器，接受数据集
public HomepageRecycleAdapter(List<Bean> date) {
        this.date = date;
        }


public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
        }


public void onBindViewHolder(final ViewHolder holder, int position) {
        //将数据填充到具体的view中

        holder.icon.setImageResource(R.drawable.mes5);
        holder.title.setText( date.get(position).getTitle());
        holder.desc.setText(date.get(position).getInformation());
        // 如果设置了回调，则设置点击事件
        if (mOnItemClickListener != null) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        int position1 = holder.getLayoutPosition();
        mOnItemClickListener.onItemClick(holder.itemView, position1);
        }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
public boolean onLongClick(View v) {
        int position1 = holder.getLayoutPosition();
        mOnItemClickListener.onItemLongClick(holder.itemView, position1);
        return false;
        }
        });
        }
        }

public int getItemCount() {
        return date.size();
        }

class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView icon;
    public TextView title;
    public TextView desc;

    public ViewHolder(View itemView) {
        super(itemView);
        //由于itemView是item的布局文件，我们需要的是里面的textView，因此利用itemView.findViewById获 //取里面的textView实例，后面通过onBindViewHolder方法能直接填充数据到每一个textView了
        icon = (ImageView) itemView.findViewById(R.id.item_image);
        title = (TextView) itemView.findViewById(R.id.item_title);
        desc = (TextView) itemView.findViewById(R.id.item_desc);
    }
}

/**
 * 定义接口回调
 */
public interface OnItemClickListener {
    void onItemClick(View view, int position);
    void onItemLongClick(View view, int position);
}

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}



