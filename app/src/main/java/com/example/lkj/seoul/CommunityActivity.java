package com.example.lkj.seoul;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

public class CommunityActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        final String season[] = {"봄", "여름", "가을", "겨울"};
        final String sort[] = {"인기순", "최신순", "클릭순"};
        final String location[] = {"강북", "강남"};

        final Spinner spin1 = (Spinner) findViewById(R.id.sort);
        final Spinner spin2 = (Spinner) findViewById(R.id.subject);
        final Spinner spin3 = (Spinner) findViewById(R.id.style);

        ArrayAdapter<String> ad1 = new ArrayAdapter<String>(CommunityActivity.this, android.R.layout.simple_spinner_item, season);
        ArrayAdapter<String> ad2 = new ArrayAdapter<String>(CommunityActivity.this, android.R.layout.simple_spinner_item, sort);
        ArrayAdapter<String> ad3 = new ArrayAdapter<String>(CommunityActivity.this, android.R.layout.simple_spinner_item, location);

        ad1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ad2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ad3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin1.setAdapter(ad1);
        spin2.setAdapter(ad2);
        spin3.setAdapter(ad3);
    }

    public void changeFragment(View view) {
        int count = 0;
        int id = view.getId();

        switch (id) {
            case R.id.btHome:
                startActivity(new Intent(CommunityActivity.this,HomeActivity.class));
                finish();
                break;
            case R.id.btCommuntiy:
                startActivity(new Intent(CommunityActivity.this,CommunityActivity.class));
                finish();
                break;
            case R.id.btWishlist:
                startActivity(new Intent(CommunityActivity.this,WishListActivity.class));
                finish();
                break;
            case R.id.btSetting:
                startActivity(new Intent(CommunityActivity.this,SettingActivity.class));
                finish();
                break;

        }
    }
}
