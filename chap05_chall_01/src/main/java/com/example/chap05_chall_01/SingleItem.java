package com.example.chap05_chall_01;

/**
 * Created by BK on 2018-03-28.
 */

public class SingleItem {

    String name;
    String birth;
    String tel;

    public SingleItem(String name, String birth, String tel){
        this.name = name;
        this.birth = birth;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public String getTel() {
        return tel;
    }
}

