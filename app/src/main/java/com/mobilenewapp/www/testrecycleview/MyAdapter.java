package com.mobilenewapp.www.testrecycleview;

import android.content.Context;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<List_Data>list_data;
    private Context context;

    public MyAdapter(List<List_Data> list_data, MainActivity context) {
        this.list_data = list_data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.data_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        List_Data listData=list_data.get(position);

        Picasso.with(context)
                .load(listData
                        .getImage_url())
                .into(holder.img);

        holder.txtname.setText(listData.getName());

    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }


    public void clearApplications() {
        int size = this.list_data.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                list_data.remove(0);
            }

            this.notifyItemRangeRemoved(0, size);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView txtname;
        public ViewHolder(View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.image_view);
            txtname=(TextView)itemView.findViewById(R.id.text_name);
        }
    }
}