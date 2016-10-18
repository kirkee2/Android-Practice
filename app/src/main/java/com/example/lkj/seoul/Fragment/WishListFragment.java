package com.example.lkj.seoul.Fragment;

import android.app.Fragment;
import android.os.Bundle;
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

    private ListView listView;
    private ArrayList<MainList> mainLists;
    private MainAdapter adapter;

    public void WishListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_community, container, false);


        mainLists = new ArrayList<MainList>();

        listView = (ListView) view.findViewById(R.id.listView);

        new WebHook().execute(listView.toString(),null,null);

        adapter = new MainAdapter(getActivity(), R.layout.main_item, mainLists);

        mainLists.clear();

        for(int i = 0 ; i <10 ; i++){
            mainLists.add(i, new MainList("",i+""));
        }

        adapter = new MainAdapter(getActivity(), R.layout.main_item, mainLists);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),mainLists.get(position).getName(),Toast.LENGTH_LONG).show();

            }
        });

        return view;
    }
}