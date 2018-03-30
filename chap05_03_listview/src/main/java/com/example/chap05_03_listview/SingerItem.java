package com.example.chap05_03_listview;

/**
 * Created by BK on 2018-03-21.
 */

public class SingerItem {

    String name;
    String phonNum;
    int No;
    int resId;

    public SingerItem(String name, String phonNum){
        this.name = name;
        this.phonNum = phonNum;
    }

    public SingerItem(String name, String phonNum, int no, int resId){
        this.name = name;
        this.phonNum = phonNum;
        this.No = no;
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public String getPhonNum() {
        return phonNum;
    }

    public int getNo() {
        return No;
    }

    public int getResId() {
        return resId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhonNum(String phonNum) {
        this.phonNum = phonNum;
    }

    public void setNo(int no) {
        No = no;
    }

    public void setRedId(int redId) {
        this.resId = redId;
    }
}
