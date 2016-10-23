package com.example.lkj.seoul;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;



import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.lkj.seoul.Connection.WebHook;
import com.example.lkj.seoul.Fragment.CommunityFragment;
import com.example.lkj.seoul.Fragment.MainFragment;
import com.example.lkj.seoul.Fragment.SettingFragment;
import com.example.lkj.seoul.Fragment.WishListFragment;
import com.example.lkj.seoul.Java.BackPressCloseHandler;


public class MainActivity extends FragmentActivity {

    private ImageButton home;
    private ImageButton community;
    private ImageButton wishList;
    private ImageButton setting;
    private ImageButton selected;
    private Fragment currentFragment = null;
    private long backKeyPressedTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment;

        mainFragment = new MainFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.MainPagefragment, mainFragment);

        fragmentTransaction.commit();


        home = (ImageButton) findViewById(R.id.btHome);
        community = (ImageButton) findViewById(R.id.btCommuntiy);
        wishList = (ImageButton) findViewById(R.id.btWishlist);
        setting = (ImageButton) findViewById(R.id.btSetting);
        selected = home;
        currentFragment = mainFragment;
    }

    public void changeFragment(View view) {
        int count = 0;
        int id = view.getId();

        switch (id) {
            case R.id.btHome:
                selected.setBackgroundColor(0xFFFFFFFF);
                selected.invalidate();
                selected = home;
                home.setBackgroundColor(0xFFB3E5FC);
                home.invalidate();
                currentFragment = new MainFragment();
                break;
            case R.id.btCommuntiy:
                selected.setBackgroundColor(0xFFFFFFFF);
                selected.invalidate();
                selected = community;
                community.setBackgroundColor(0xFFB3E5FC);
                community.invalidate();
                currentFragment = new CommunityFragment();
                break;
            case R.id.btWishlist:
                selected.setBackgroundColor(0xFFFFFFFF);
                selected.invalidate();
                selected = wishList;
                wishList.setBackgroundColor(0xFFB3E5FC);
                wishList.invalidate();
                currentFragment = new WishListFragment();
                break;
            case R.id.btSetting:
                selected.setBackgroundColor(0xFFFFFFFF);
                selected.invalidate();
                selected = setting;
                setting.setBackgroundColor(0xFFB3E5FC);
                setting.invalidate();
                currentFragment = new SettingFragment();
                break;

        }


        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.MainPagefragment, currentFragment);

        //fragmentTransaction.addToBackStack(null);


        //fragmentTransaction.commitAllowingStateLoss();
        fragmentTransaction.commit();

    }

    public void onBackPressed() {
        String arr[] = currentFragment.toString().split("\\{",2);
        if(arr[0].equals("MainFragment")){
            if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
                backKeyPressedTime = System.currentTimeMillis();
                Toast.makeText(this,"뒤로버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();

                return;
            }
            if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
                this.finish();
            }
        }else{
            selected.setBackgroundColor(0xFFFFFFFF);
            selected.invalidate();
            selected = home;
            home.setBackgroundColor(0xFFB3E5FC);
            home.invalidate();
            currentFragment = new MainFragment();

            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.MainPagefragment, currentFragment);

            fragmentTransaction.commit();
        }
    }
}

