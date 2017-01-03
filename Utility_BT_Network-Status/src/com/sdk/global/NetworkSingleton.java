package com.sdk.global;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkSingleton {
	
	public static boolean mCurrentNetworkStatus;
	private Context mContext;
	private String TAG = "NetworkSingleton";
	
	public NetworkSingleton(Context applicationContext) {
		super();
		mContext = applicationContext;
	}
	
	public boolean CheckInternet(Context ctx) {
	    ConnectivityManager connect = (ConnectivityManager) ctx
	            .getSystemService(Context.CONNECTIVITY_SERVICE);
	    
	    if(null==connect) {
	    	return false;
	    }else {
		    NetworkInfo wifi = connect.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		    NetworkInfo mobile = connect.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		    // Check if wifi or mobile network is available or not. If any of them is
		    // available or connected then it will return true, otherwise false;
		    if((null==wifi)&&(null==mobile)) {
		    	return false;
		    }else if((null!=wifi)&&(null==mobile)) {
		        return wifi.isConnected();
		    }else if((null==wifi)&&(null!=mobile)) {
		    	return mobile.isConnected();
		    }else { //((null!=wifi)&&(null!=mobile))
		    	return wifi.isConnected() || mobile.isConnected();
		    }
	    }  
	}
	
	public boolean getCurrentNetworkStatus() {
		
		try{
			mCurrentNetworkStatus=CheckInternet(mContext);
		}catch (Exception exc) {
			Log.i(TAG,"getCurrentNetworkStatus Exception :"+exc);
		}
		
		return mCurrentNetworkStatus;
	}	
}
