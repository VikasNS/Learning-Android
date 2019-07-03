package com.vikas.learningandroid;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private DemoFragmentAdapter demoFragmentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pager);
        demoFragmentAdapter = new DemoFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(demoFragmentAdapter );
    }
}
