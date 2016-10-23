package com.example.lkj.seoul;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


    }

    public void changeFragment(View view) {
        int count = 0;
        int id = view.getId();

        switch (id) {
            case R.id.btHome:
                startActivity(new Intent(SettingActivity.this,HomeActivity.class));
                finish();
                break;
            case R.id.btCommuntiy:
                startActivity(new Intent(SettingActivity.this,CommunityActivity.class));
                finish();
                break;
            case R.id.btWishlist:
                startActivity(new Intent(SettingActivity.this,WishListActivity.class));
                finish();
                break;
            case R.id.btSetting:
                startActivity(new Intent(SettingActivity.this,SettingActivity.class));
                finish();
                break;

        }
    }
}
