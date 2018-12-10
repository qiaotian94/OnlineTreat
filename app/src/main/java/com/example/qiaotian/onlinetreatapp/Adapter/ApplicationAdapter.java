package com.example.qiaotian.onlinetreatapp.Adapter;

/**
 * Created by qiaotian on 2018/4/26.
 */


        import android.content.Context;
        import android.content.Intent;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.example.qiaotian.onlinetreatapp.WebViewActivity.Gynecology;
        import com.example.qiaotian.onlinetreatapp.WebViewActivity.MainHosptial;
        import com.example.qiaotian.onlinetreatapp.R;
        import com.example.qiaotian.onlinetreatapp.javabean.ApplicationBean;

        import java.util.ArrayList;

/**
 * Created by huangjie on 2017/11/12.
 */

public class ApplicationAdapter extends RecyclerView.Adapter {
    //布局类型
    private static final int VIEW_TYPE_ONE = 1;
    private static final int VIEW_TYPE_TWO = 2;
    private static final int VIEW_TYPE_THREE = 3;
    private LayoutInflater inflater;
    private Context mContext;
    private ArrayList<ApplicationBean> mDataList;

    public ApplicationAdapter(ArrayList<ApplicationBean> mDataList, Context context) {
        this.mDataList = mDataList;
        mContext = context;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemViewType(int position) {

        if (mDataList.get(position).getType() == ApplicationBean.Type.TypeOne) {
            return VIEW_TYPE_ONE;
        } else if (mDataList.get(position).getType() == ApplicationBean.Type.TypeTwo) {
            return VIEW_TYPE_TWO;
        } else if (mDataList.get(position).getType() == ApplicationBean.Type.TypeThree) {
            return VIEW_TYPE_THREE;
        } else {
            return 0;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case VIEW_TYPE_ONE:
                viewHolder = new ViewHolderOne(inflater.inflate(R.layout.item_one, parent, false));
                break;
            case VIEW_TYPE_TWO:
                viewHolder = new ViewHolderTwo(inflater.inflate(R.layout.item_two, parent, false));
                break;
            case VIEW_TYPE_THREE:
                viewHolder = new ViewHolderThree(inflater.inflate(R.layout.item_three, parent, false));
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)) {
            case VIEW_TYPE_ONE:
                Log.e("huangjie", mDataList.get(position).getTitle());
                ((ViewHolderOne) holder).title.setText(mDataList.get(position).getTitle());
                break;
            case VIEW_TYPE_TWO:
                ((ViewHolderTwo) holder).title.setText(mDataList.get(position).getName());
                ((ViewHolderTwo) holder).information.setText(mDataList.get(position).getInformation());
                ((ViewHolderTwo) holder).icon.setImageDrawable(
                        mContext.getResources().getDrawable(mDataList.get(position).getIcon()));
                break;
            case VIEW_TYPE_THREE:
                ((ViewHolderThree) holder).title.setText(mDataList.get(position).getName());
                ((ViewHolderThree) holder).icon.setImageDrawable(
                        mContext.getResources().getDrawable(mDataList.get(position).getIcon()));

                break;
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }


    /**
     * 第一种布局类型ViewHolder
     */
    public static class ViewHolderOne extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView title;

        public ViewHolderOne(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }

    /**
     * 第二种布局类型ViewHolder
     */
    public static class ViewHolderTwo extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView icon;
        private TextView title;
        private TextView information;

        public ViewHolderTwo(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
            information = (TextView) itemView.findViewById(R.id.infor);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(),MainHosptial.class);
            view.getContext().startActivity(intent);
        }
    }

    /**
     * 第三种布局类型viewholder
     */
    public static class ViewHolderThree extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView icon;
        private TextView title;

        public ViewHolderThree(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(),Gynecology.class);
            view.getContext().startActivity(intent);
        }
    }

}





