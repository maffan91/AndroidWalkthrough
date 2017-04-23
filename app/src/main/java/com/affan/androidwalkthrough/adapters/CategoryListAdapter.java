package com.affan.androidwalkthrough.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.affan.androidwalkthrough.R;
import com.affan.androidwalkthrough.listeners.OnCategoryItemClickListener;

import java.util.List;

/**
 * Created by affan on 4/22/17.
 */

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoriesViewHolder>{

    private String[] categories;
    private Context context;
    private OnCategoryItemClickListener mListener;

    public CategoryListAdapter(Context context,String[] categories,OnCategoryItemClickListener mListener){

        this.categories = categories;
        this.context = context;
        this.mListener = mListener;
    }

    @Override
    public CategoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.categories_items,null);
        return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CategoriesViewHolder holder, final int position) {
        holder.categoryName.setText(categories[position]);
        holder.categoryName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onCategoryItemClickListener(holder,position);
            }
        });
    }



    @Override
    public int getItemCount() {
        return categories.length;
    }



    public static class CategoriesViewHolder extends RecyclerView.ViewHolder{

        public TextView categoryName;

        CategoriesViewHolder(View view){
            super(view);
            categoryName = (TextView) view.findViewById(R.id.categoryName);
        }
    }

}
