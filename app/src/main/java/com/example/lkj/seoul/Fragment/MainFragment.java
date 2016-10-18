package com.example.lkj.seoul.Fragment;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.lkj.seoul.Java.AutoScrollViewPager;
import com.example.lkj.seoul.Java.InfinitePagerAdapter;
import com.example.lkj.seoul.R;

public class MainFragment extends Fragment {

    public void MainFragment(){

    }

    private InfinitePagerAdapter pagerAdapter;
    private AutoScrollViewPager pager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        /*
        pager = (AutoScrollViewPager) view.findViewById(R.id.view_pager);

        pagerAdapter = new InfinitePagerAdapter(view.getSupportFragmentManager());

        pager.setAdapter(pagerAdapter);
        pager.startAutoScroll();
        */




        return view;
    }

}
