package com.example.seasons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class Main2Activity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);

        tabLayout.addTab(tabLayout.newTab().setText("Summer"));
        tabLayout.addTab(tabLayout.newTab().setText("Autumn"));
        tabLayout.addTab(tabLayout.newTab().setText("Rainy"));
        tabLayout.addTab(tabLayout.newTab().setText("Winter"));
        tabLayout.addTab(tabLayout.newTab().setText("Favorite"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final MyAdapter adapter = new MyAdapter(this,getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
   /* @Override
    public void sendData(String message) {
        String tag = "android:switcher:" + R.id.viewPager + ":" + 4;
        Favourites f = (Favourites) getSupportFragmentManager().findFragmentByTag(tag);

        //f.displayReceivedData(message);


    }*/



}


