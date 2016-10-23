package com.example.lkj.seoul.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lkj.seoul.Connection.WebHook;
import com.example.lkj.seoul.ListViewAdapter.MainAdapter;
import com.example.lkj.seoul.ListViewAdapter.MainList;
import com.example.lkj.seoul.R;

import java.util.ArrayList;


public class WishListFragment extends Fragment {

    private FragmentPagerAdapter adapterViewPager;
    private TabLayout tabLayout;
    private ViewPager pager = null;


    public WishListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wishlist, container, false);


        pager = (ViewPager) view.findViewById(R.id.pager);

        adapterViewPager = new MyPagerAdapter(getActivity().getSupportFragmentManager());
        pager.setAdapter(adapterViewPager);

        adapterViewPager =new MyPagerAdapter(getActivity().getSupportFragmentManager());
        new setAdapterTask().execute();

        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
        tabLayout.setSelectedTabIndicatorColor(0xFFFF0000);
        tabLayout.setSelectedTabIndicatorHeight(50);

        return view;
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
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return new TmpFragment1();
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return new TmpFragment2();
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
            }else{
                return null;
            }
        }
    }

    private class setAdapterTask extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... params) {
            return null;
        }

        @Override
        protected void onPostExecute(Void result){
            pager.setAdapter(adapterViewPager);
        }
    }
}