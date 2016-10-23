package com.example.lkj.seoul.ListViewAdapter;

/**
 * Created by admin on 2016-05-04.
 */
public class SettingList {
    private String name;

    public SettingList(){

    }

    public SettingList(String name){
        this.name = name;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }


    public String toString(){
        return "SettingList{ name = " + this.name + " }";
    }

}
