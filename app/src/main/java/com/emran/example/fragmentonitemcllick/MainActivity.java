package com.emran.example.fragmentonitemcllick;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPagerAdapter adapter;
    private ViewPager viewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        TabItem chats = findViewById(R.id.tabs_chats);
        TabItem calls = findViewById(R.id.tabs_calls);
        TabItem status = findViewById(R.id.tabs_status);
        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        //Icon Fragment Display//
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_info);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_detail);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_fav);

        //Add Fragment //
        /*adapter.AddFragment(new InfoFragment(),"Info");
        adapter.AddFragment(new Detail_Fragment(),"Detail");
        adapter.AddFragment(new FavFragment(),"Favourate");*/

        viewPager.setAdapter(adapter);
//        tabLayout.setupWithViewPager(viewPager);


        //Change color swipe fragment//

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 1) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                    tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#ffffff"));
                } else if (tab.getPosition() == 2) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                } else {
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimaryDark));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimaryDark));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}