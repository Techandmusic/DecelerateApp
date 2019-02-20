package com.apps.adam.decelerateanxietymanager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import io.paperdb.Paper;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Paper.init(this);
        //Create ViewPager for fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        //Create PagerAdapter
        PagerAdapter pagerAdapter = new DeceleratePagerAdapter(this, getSupportFragmentManager());
        //Set the adapter
        viewPager.setAdapter(pagerAdapter);
        //Create tab Layout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        //Call setupWithViewPager to connect tabs automatically
        tabLayout.setupWithViewPager(viewPager);


    }
}
