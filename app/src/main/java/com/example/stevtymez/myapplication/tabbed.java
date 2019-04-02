package com.example.stevtymez.myapplication;

import android.content.res.TypedArray;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class tabbed extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        // Adding fragments
        adapter.AddFragment(new FragmentFashion(), "Fashion");
        adapter.AddFragment(new FragmentFood(), "Food");
        adapter.AddFragment(new FragmentOther(), "Others");
        //adapter Setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
