package com.example.qiaotian.onlinetreatapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qiaotian.onlinetreatapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiaotian on 2018/4/27.
 */

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.ViewHolder> {

    private List<String> date=new ArrayList<>();
    //构造器，接受数据集
    public MedicineAdapter(List<String> date) {
        this.date = date;
    }


    public MedicineAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_one, parent, false);
        MedicineAdapter.ViewHolder holder = new MedicineAdapter.ViewHolder(view);
        return holder;
    }


    public void onBindViewHolder(final MedicineAdapter.ViewHolder holder, int position) {
        //将数据填充到具体的view中
        holder.title.setText(date.get(position));
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
        public TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            //由于itemView是item的布局文件，我们需要的是里面的textView，因此利用itemView.findViewById获 //取里面的textView实例，后面通过onBindViewHolder方法能直接填充数据到每一个textView了
            title = (TextView) itemView.findViewById(R.id.text);
        }
    }

    /**
     * 定义接口回调
     */
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    private MedicineAdapter.OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(MedicineAdapter.OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}


