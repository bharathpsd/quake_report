package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Satya on 1/30/2018.
 */

public class Earthquake {
    /*To Hold Magnitude of Earthquake*/
    private double mMagnitude;

    /*To Hold Place of Earthquake*/
    private String mPlace;

    /*To Hold Date of the Earthquake*/
    private long mDate;

    /*To Hold URL of the Earthquake*/
    private String mUrl;

    Earthquake(double magnitude,String place,String time,String url){
        mMagnitude = magnitude;
        mPlace = place;
        mDate = timeToMilli(time);
        mUrl = url;
      //  splitString();
    }

    private long timeToMilli(String time){
        long timeInMilliseconds = Long.parseLong(time);
        return timeInMilliseconds;
    }

    public long getTimeInMilliseconds(){
        return mDate;
    }

    public double getMagnitude(){
        return mMagnitude;
    }

    public String getPlace(){
        return mPlace;
    }

    public String getUrl(){ return mUrl; }

    /*public String getDate(){
        return mDate;
    }*/


}
