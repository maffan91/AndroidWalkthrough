package com.affan.androidwalkthrough;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.affan.androidwalkthrough.adapters.CategoryListAdapter;
import com.affan.androidwalkthrough.adapters.LayoutListAdapter;
import com.affan.androidwalkthrough.listeners.OnCategoryItemClickListener;
import com.affan.androidwalkthrough.ui.activities.LayoutListingActivity;
import com.affan.androidwalkthrough.ui.activities.LoginActivity;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryList;
    CategoryListAdapter adapter;
    String[] categories;
    public static final String TITLE = "Categories";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(TITLE);
        initiateList();
    }

    private void initiateList(){
        categories = getResources().getStringArray(R.array.categories);
        categoryList = (RecyclerView) findViewById(R.id.categoriesList);
        categoryList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CategoryListAdapter(this,categories , new OnCategoryItemClickListener() {
            @Override
            public void onCategoryItemClickListener(CategoryListAdapter.CategoriesViewHolder view, int position) {
                Toasty.info(getApplicationContext(),"You Clicked:"+ view.categoryName.getText().toString()).show();


                switch (position){

                    case 0:{
                        startActivity(new Intent(getApplicationContext(), LayoutListingActivity.class));
                    }
                    break;
                    case 1:{

                    }
                    break;
                    case 2:{

                    }
                    break;
                    case 3:{

                    }
                    break;
                    case 4:{

                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    }
                    break;
                }






            }
        });
        categoryList.setAdapter(adapter);

    }


}
