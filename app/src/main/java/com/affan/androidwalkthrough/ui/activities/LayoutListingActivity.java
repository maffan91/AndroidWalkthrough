package com.affan.androidwalkthrough.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.affan.androidwalkthrough.R;
import com.affan.androidwalkthrough.adapters.LayoutListAdapter;
import com.affan.androidwalkthrough.listeners.OnLayoutItemClickListener;

import es.dmoral.toasty.Toasty;

public class LayoutListingActivity extends AppCompatActivity {

    public static final String TITLE = "Layout Tasks";
    RecyclerView layoutListRecyclerView;
    LayoutListAdapter adapter;
    String[] layoutList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_listing);
        setTitle(TITLE);
        initList();
    }

    private void initList(){

        layoutList = getResources().getStringArray(R.array.layoutTasks);
        layoutListRecyclerView = (RecyclerView) findViewById(R.id.layoutRecyclerView);
        layoutListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LayoutListAdapter(this, layoutList, new OnLayoutItemClickListener() {
            @Override
            public void onLayoutItemClickListener(LayoutListAdapter.ViewHolder viewHolder, int position) {

                Toasty.info(getApplicationContext(),"You Clicked" + layoutList[position]).show();
            }
        });
        layoutListRecyclerView.setAdapter(adapter);
    }
}
