package com.zomatoapplication.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class AppStatus {

    private static AppStatus instance = new AppStatus();
    ConnectivityManager connectManager;
    NetworkInfo wifiInfo, mobileInfo;
    boolean connected = false;

    public static AppStatus getInstance() {
        return instance;
    }

    public boolean isOnline(Context context) {
        try {
            connectManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectManager.getActiveNetworkInfo();
            connected = networkInfo != null && networkInfo.isAvailable()
                    && networkInfo.isConnected();
            return connected;

        } catch (Exception e) {
            System.out.println(Constants.CONNECTION_EXCEPTION + e.getMessage());
        }
        return connected;
    }
}

