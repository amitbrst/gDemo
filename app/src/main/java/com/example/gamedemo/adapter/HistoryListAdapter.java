package com.example.gamedemo.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gamedemo.R;
import com.example.gamedemo.models.HistoryList;

import java.util.ArrayList;
import java.util.List;

public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.ViewHolder>{
    private List<HistoryList> listData = new ArrayList<HistoryList>();
    public HistoryListAdapter(List<HistoryList>  listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.history_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull HistoryListAdapter.ViewHolder holder, int position) {
        final HistoryList myListData = listData.get(position);
        holder.textView1.setText(myListData.getB1());
        holder.imageView1.setImageResource(myListData.getWF1());
        holder.textView2.setText(myListData.getB2());
        holder.imageView2.setImageResource(myListData.getWF2());
        holder.textView3.setText(myListData.getB3());
        holder.imageView3.setImageResource(myListData.getWF3());
        if(position==0)
        {
            holder.NewDisplayer.setVisibility(View.VISIBLE);
        }
        else
        {
            holder.NewDisplayer.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView1;
        public TextView textView1;
        public ImageView imageView2;
        public TextView textView2;
        public ImageView imageView3;
        public TextView textView3;
        public LinearLayout linearLayout;
        public LinearLayout NewDisplayer;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView1 = (ImageView) itemView.findViewById(R.id.HBG1);
            this.textView1 = (TextView) itemView.findViewById(R.id.HBGT1);
            this.imageView2 = (ImageView) itemView.findViewById(R.id.HBG2);
            this.textView2 = (TextView) itemView.findViewById(R.id.HBGT2);
            this.imageView3 = (ImageView) itemView.findViewById(R.id.HBG3);
            this.textView3 = (TextView) itemView.findViewById(R.id.HBGT3);
            this.NewDisplayer=(LinearLayout) itemView.findViewById(R.id.NewItem);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.HisItemLayout);
        }

    }
}

