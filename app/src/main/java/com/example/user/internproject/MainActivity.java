package com.example.user.internproject;


import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

  /*  RecyclerView recyclerView;
    int[] images = {R.drawable.student,R.drawable.teacher,R.drawable.boy1,R.drawable.teacher1};

    MyAdapter myAdapter;
    String [] names,designations;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*recyclerView = findViewById(R.id.recyclerViewId);
        names = getResources().getStringArray(R.array.names);
        designations = getResources().getStringArray(R.array.designation);

        myAdapter = new MyAdapter(this,names,designations,images);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));*/


        // for fragment//
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        bottomNav.setSelectedItemId(R.id.local_id);
    }
       private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;
                switch (menuItem.getItemId()){
                    case R.id.local_id:
                        selectedFragment = new LocalFragment();
                        break;
                    case R.id.server_id:
                        selectedFragment = new ServerFragment();
                        break;
                    case R.id.more_id:
                        selectedFragment = new MoreFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , selectedFragment).commit();
                return true;
            }
        };
    }
