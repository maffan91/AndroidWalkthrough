package com.affan.androidwalkthrough.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.affan.androidwalkthrough.R;
import com.affan.androidwalkthrough.listeners.OnLayoutItemClickListener;

import org.w3c.dom.Text;

/**
 * Created by affan on 4/22/17.
 */

public class LayoutListAdapter extends RecyclerView.Adapter<LayoutListAdapter.ViewHolder> {

    private Context context;
    private String[] layoutList;
    private OnLayoutItemClickListener mListener;

    public LayoutListAdapter(Context context, String[] layoutList,OnLayoutItemClickListener mListener) {
        this.context = context;
        this.layoutList = layoutList;
        this.mListener = mListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_items,null);
        return new LayoutListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.layoutName.setText(layoutList[position]);
        holder.layoutName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onLayoutItemClickListener(holder,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return layoutList.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView layoutName;

        ViewHolder(View itemView) {
            super(itemView);
            layoutName = (TextView) itemView.findViewById(R.id.layoutName);
        }
    }
}
