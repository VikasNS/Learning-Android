package com.vikas.learningandroid;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private Adapter adapter;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(new Adapter(getSupportFragmentManager()));

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


    }
}
