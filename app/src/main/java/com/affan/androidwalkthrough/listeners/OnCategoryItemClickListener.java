package com.affan.androidwalkthrough.listeners;

import android.view.View;

import com.affan.androidwalkthrough.adapters.CategoryListAdapter;

/**
 * Created by affan on 4/22/17.
 */

public interface OnCategoryItemClickListener {

    void onCategoryItemClickListener(CategoryListAdapter.CategoriesViewHolder view,int position);
}
