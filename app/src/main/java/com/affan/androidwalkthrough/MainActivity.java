package com.affan.androidwalkthrough;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.affan.androidwalkthrough.adapters.CategoryListAdapter;
import com.affan.androidwalkthrough.listeners.OnCategoryItemClickListener;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryList;
    CategoryListAdapter adapter;
    public static final String TITLE = "Categories";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(TITLE);
        initiateList();
    }

    private void initiateList(){

        categoryList = (RecyclerView) findViewById(R.id.categoriesList);
        categoryList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CategoryListAdapter(this, getResources().getStringArray(R.array.categories), new OnCategoryItemClickListener() {
            @Override
            public void onCategoryItemClickListener(CategoryListAdapter.CategoriesViewHolder view, int position) {
                Toasty.info(getApplicationContext(),"You Clicked:"+ view.categoryName.getText().toString()).show();
            }
        });
        categoryList.setAdapter(adapter);

    }


}
