package com.example.punto2jp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CustomViewHolder> {

    private List<RetroUsers> dataList;
    public MyAdapter(List<RetroUsers> dataList){

        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        public final View myView;
        TextView textUser;
        TextView textUsername;
        CustomViewHolder(View itemView) {
            super(itemView);
            myView = itemView;

            textUser = myView.findViewById(R.id.user);
            textUsername = myView.findViewById(R.id.username);

        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.textUser.setText(dataList.get(position).getUser());
        holder.textUsername.setText(dataList.get(position).getUsername());
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}