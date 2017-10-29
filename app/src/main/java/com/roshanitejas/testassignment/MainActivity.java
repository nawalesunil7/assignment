package com.roshanitejas.testassignment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.adapter.SectionPagerAdapter;
import com.fragments.Schenario1;
import com.fragments.Schenario2;
import com.sunilnawale.testassignment.R;

public class MainActivity extends AppCompatActivity {
    private SectionPagerAdapter adapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new SectionPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        Addfragment(mViewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    public void Addfragment(ViewPager mViewPager) {
        adapter.addfragment(new Schenario1(),"Scenario1");
        adapter.addfragment(new Schenario2(),"Scenario2");
        mViewPager.setAdapter(adapter);

    }





}
