package com.roshanitejas.testassignment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.adapter.SectionPagerAdapter;
import com.fragments.Schenario1;
import com.fragments.Schenario2;
import com.sunilnawale.testassignment.R;
import com.sunilnawale.testassignment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addfragment(new Schenario1(), "Scenario1");
        adapter.addfragment(new Schenario2(), "Scenario2");
        binding.container.setAdapter(adapter);
        binding.tabs.setupWithViewPager(binding.container);
    }

}
