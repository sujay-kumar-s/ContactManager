package com.example.aqua.contactmanager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import io.realm.RealmResults;

/**
 * Created by aqua on 12/22/2016.
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter {
    RealmResults<Contact> results;
    Context ctx;
    public RecyclerviewAdapter(RealmResults results, Context ctx)
    {
        this.results=results;
        this.ctx=ctx;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(ctx).inflate(R.layout.row,null,false);
        RowHolder rowHolder=new RowHolder(v);


        return rowHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       RowHolder rowHolder= (RowHolder) holder;
        rowHolder.nametv.setText(results.get(position).getName());
        rowHolder.phonetv.setText(results.get(position).getPhone());

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class RowHolder extends RecyclerView.ViewHolder
    {
        ImageView piciv;
        TextView nametv;
        TextView phonetv;
        public RowHolder(View itemView) {
            super(itemView);
            piciv= (ImageView) itemView.findViewById(R.id.piciv);
            nametv= (TextView) itemView.findViewById(R.id.nametv);
            phonetv= (TextView) itemView.findViewById(R.id.numbertv);
        }
    }
}
