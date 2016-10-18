package com.example.lkj.seoul;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.lkj.seoul.Fragment.MainFragment;
import com.example.lkj.seoul.Fragment.SettingFragment;


public class ViewPagerMain extends AppCompatActivity {
    FragmentPagerAdapter adapterViewPager;
    private TabLayout tabLayout;
    Fragment currentFragment =new Fragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);

        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapterViewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
        //tabLayout.setSelectedTabIndicatorColor(-256);
        tabLayout.setSelectedTabIndicatorHeight(0);
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 2;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    //return new MainFragment();
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    //return new SettingFragment();
                default:
                    return null;
            }
        }


        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            if(position == 0){
                return "Main";
            }else if(position == 1){
                return "Setting";
            }else if(position == 2){
                return "c";
            }else if(position == 3){
                return "d";
            }else{
                return "a";
            }
        }


    }



}
