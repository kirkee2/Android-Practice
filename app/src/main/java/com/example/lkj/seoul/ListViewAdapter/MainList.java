package com.example.lkj.seoul.ListViewAdapter;

/**
 * Created by admin on 2016-05-04.
 */
public class MainList {
    private String name;
    private String image;

    public MainList(){

    }

    public MainList(String name){
        this.name = name;
    }

    public MainList(String image, String name) {
        this.image = image;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public String getImage() {
        return this.image;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setImage(String image){
        this.image = image;
    }

    public String toString(){
        return "SettingList{ name = " + this.name + " image = " + this.image + " }";
    }

}
