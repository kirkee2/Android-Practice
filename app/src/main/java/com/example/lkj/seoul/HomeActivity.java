package com.example.lkj.seoul;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lkj.seoul.Fragment.CommunityFragment;
import com.example.lkj.seoul.Fragment.MainFragment;
import com.example.lkj.seoul.Fragment.SettingFragment;
import com.example.lkj.seoul.Fragment.WishListFragment;
import com.example.lkj.seoul.ListViewAdapter.MainAdapter;
import com.example.lkj.seoul.ListViewAdapter.MainList;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {


    private ListView listView;
    private ArrayList<MainList> mainLists;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final String season[] = {"봄", "여름", "가을", "겨울"};
        final String sort[] = {"인기순", "최신순", "클릭순"};
        final String location[] = {"강북", "강남"};

        final Spinner spin1 = (Spinner) findViewById(R.id.sort);
        final Spinner spin2 = (Spinner) findViewById(R.id.subject);
        final Spinner spin3 = (Spinner) findViewById(R.id.style);

        ArrayAdapter<String> ad1 = new ArrayAdapter<String>(HomeActivity.this, android.R.layout.simple_spinner_item, season);
        ArrayAdapter<String> ad2 = new ArrayAdapter<String>(HomeActivity.this, android.R.layout.simple_spinner_item, sort);
        ArrayAdapter<String> ad3 = new ArrayAdapter<String>(HomeActivity.this, android.R.layout.simple_spinner_item, location);

        ad1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ad2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ad3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin1.setAdapter(ad1);
        spin2.setAdapter(ad2);
        spin3.setAdapter(ad3);
        /*
        pager = (AutoScrollViewPager) view.findViewById(R.id.view_pager);

        pagerAdapter = new InfinitePagerAdapter(view.getSupportFragmentManager());

        pager.setAdapter(pagerAdapter);
        pager.startAutoScroll();
        */

        mainLists = new ArrayList<MainList>();

        mainLists.clear();

        listView = (ListView)findViewById(R.id.listView);


        for(int i = 0 ; i <10 ; i++){
            mainLists.add(i, new MainList("",i+""));
        }

        adapter = new MainAdapter(HomeActivity.this, R.layout.main_item, mainLists);


        listView.setAdapter(adapter);

        View header = this.getLayoutInflater().inflate(R.layout.listview_header, null, false);

        listView.addHeaderView(header);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(HomeActivity.this,mainLists.get(position).getName(),Toast.LENGTH_LONG).show();

            }
        });

    }

    public void changeFragment(View view) {
        int count = 0;
        int id = view.getId();

        switch (id) {
            case R.id.btHome:
                startActivity(new Intent(HomeActivity.this,HomeActivity.class));
                finish();
                break;
            case R.id.btCommuntiy:
                startActivity(new Intent(HomeActivity.this,CommunityActivity.class));
                finish();
                break;
            case R.id.btWishlist:
                startActivity(new Intent(HomeActivity.this,WishListActivity.class));
                finish();
                break;
            case R.id.btSetting:
                startActivity(new Intent(HomeActivity.this,SettingActivity.class));
                finish();
                break;

        }
    }
}
