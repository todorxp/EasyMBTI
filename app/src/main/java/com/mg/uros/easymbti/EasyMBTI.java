package com.mg.uros.easymbti;


import android.app.Application;
import android.content.Context;

public class EasyMBTI extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();




        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }
}
