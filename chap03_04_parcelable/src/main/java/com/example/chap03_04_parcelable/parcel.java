package com.example.chap03_04_parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by BK on 2018-03-07.
 */

public class parcel implements Parcelable{

    int _a;
    String _b;
    String _c;

    public String getA(){
     return  String.valueOf(_a);
    }
    public String getB(){
        return  _b;
    }
    public String getC(){
        return  _c;
    }


    public parcel(int a, String b, String c){
        _a = a;
        _b = b;
        _c = c;
    }

    public parcel(Parcel src){
        _a = src.readInt();
        _b = src.readString();
        _c = src.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){

        @Override
        public parcel createFromParcel(Parcel source) {
            return new parcel(source);
        }

        @Override
        public parcel[] newArray(int size) {
            return new parcel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_a);
        dest.writeString(_b);
        dest.writeString(_c);
    }


}
