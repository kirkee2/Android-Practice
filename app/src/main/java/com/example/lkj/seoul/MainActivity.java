package com.example.lkj.seoul;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.lkj.seoul.Fragment.CommunityFragment;
import com.example.lkj.seoul.Fragment.MainFragment;
import com.example.lkj.seoul.Fragment.SettingFragment;
import com.example.lkj.seoul.Fragment.WishListFragment;


public class MainActivity extends FragmentActivity {

    private ImageButton home;
    private ImageButton community;
    private ImageButton wishlist;
    private ImageButton setting;
    private ImageButton selected;
    private MainFragment mainFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = new MainFragment();

        FragmentManager fragmentManager = getFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.MainPagefragment, mainFragment);

        fragmentTransaction.commit();


        home = (ImageButton) findViewById(R.id.btHome);
        community = (ImageButton) findViewById(R.id.btCommuntiy);
        wishlist = (ImageButton) findViewById(R.id.btWishlist);
        setting = (ImageButton) findViewById(R.id.btSetting);
        selected = home;
    }

    public void changeFragment(View view) {
        int count = 0;
        int id = view.getId();
        Fragment fragment = null;

        switch (id) {
            case R.id.btHome:
                selected.setBackgroundColor(0xFFFFFFFF);
                selected.invalidate();
                selected = home;
                home.setBackgroundColor(0xFFB3E5FC);
                home.invalidate();
                fragment = new MainFragment();
                break;
            case R.id.btCommuntiy:
                selected.setBackgroundColor(0xFFFFFFFF);
                selected.invalidate();
                selected = community;
                community.setBackgroundColor(0xFFB3E5FC);
                community.invalidate();
                fragment = new CommunityFragment();
                break;
            case R.id.btWishlist:
                selected.setBackgroundColor(0xFFFFFFFF);
                selected.invalidate();
                selected = wishlist;
                wishlist.setBackgroundColor(0xFFB3E5FC);
                wishlist.invalidate();
                fragment = new WishListFragment();
                break;
            case R.id.btSetting:
                selected.setBackgroundColor(0xFFFFFFFF);
                selected.invalidate();
                selected = setting;
                setting.setBackgroundColor(0xFFB3E5FC);
                setting.invalidate();
                fragment = new SettingFragment();
                break;

        }


        FragmentManager fragmentManager = getFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.MainPagefragment, fragment);

        //fragmentTransaction.addToBackStack(null);


        //fragmentTransaction.commitAllowingStateLoss();
        fragmentTransaction.commit();

    }

}

