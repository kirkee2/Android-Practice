package com.example.lkj.seoul.ListViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.lkj.seoul.R;

import java.util.ArrayList;

/**
 * Created by admin on 2016-05-04.
 */
public class MainAdapter extends ArrayAdapter<MainList> {
    private ArrayList<MainList> items;
    private Context context;
    private int resId;

    public MainAdapter(Context context, int textViewResourceId, ArrayList<MainList> objects){
        super(context,textViewResourceId,objects);
        this.context = context;
        resId = textViewResourceId;
        this.items = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(resId,null);
        }

        MainList mL = items.get(position);

        if(mL != null){
            TextView t1 = (TextView)convertView.findViewById(R.id.example);

            if(t1 !=null){
                t1.setText(mL.getName());
            }


            t1.setText(mL.getName());


        }
        return convertView;
    }

}
