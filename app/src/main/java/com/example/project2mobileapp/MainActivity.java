package com.example.project2mobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    Button btn;
    int[] images = {R.drawable.bakery, R.drawable.fruit,R.drawable.veg};
    private int[] icons = {
            R.drawable.bakery,
            R.drawable.fruit,
            R.drawable.veg
    };
    
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewpager_id);
        btn = findViewById(R.id.button);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFrag(new FragmentBakery(), "Bakery");
        adapter.AddFrag(new FragmentFruit(), "Fruit");
        adapter.AddFrag(new FragmentVeg(), "Veg");




        //for (int i = 0; i < tabLayout.getTabCount(); i++) {
         //   tabLayout.getTabAt(i).setIcon(icons[i]);
        //}

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.bakery);
        tabLayout.getTabAt(1).setIcon(R.drawable.fruit);
        tabLayout.getTabAt(2).setIcon(R.drawable.veg);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),sign_up.class));
            }
        });
    }
}