package com.example.lkj.seoul.Fragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.lkj.seoul.Java.AutoScrollViewPager;
import com.example.lkj.seoul.Java.InfinitePagerAdapter;
import com.example.lkj.seoul.ListViewAdapter.MainAdapter;
import com.example.lkj.seoul.ListViewAdapter.MainList;
import com.example.lkj.seoul.R;

import java.util.ArrayList;

public class MainFragment extends Fragment {

    private ListView listView;
    private ArrayList<MainList> mainLists;
    private MainAdapter adapter;

    public MainFragment(){

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

        final String season[] = {"봄", "여름", "가을", "겨울"};
        final String sort[] = {"인기순", "최신순", "클릭순"};
        final String location[] = {"강북", "강남"};

        final Spinner spin1 = (Spinner) view.findViewById(R.id.sort);
        final Spinner spin2 = (Spinner) view.findViewById(R.id.subject);
        final Spinner spin3 = (Spinner) view.findViewById(R.id.style);

        ArrayAdapter<String> ad1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, season);
        ArrayAdapter<String> ad2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, sort);
        ArrayAdapter<String> ad3 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, location);

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

        listView = (ListView) view.findViewById(R.id.listView);


        for(int i = 0 ; i <10 ; i++){
            mainLists.add(i, new MainList("",i+""));
        }

        adapter = new MainAdapter(getActivity(), R.layout.main_item, mainLists);


        listView.setAdapter(adapter);

        View header = inflater.inflate(
                R.layout.listview_header, null, false);

        listView.addHeaderView(header);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),mainLists.get(position-1).getName(),Toast.LENGTH_LONG).show();

            }
        });




        return view;
    }

}
