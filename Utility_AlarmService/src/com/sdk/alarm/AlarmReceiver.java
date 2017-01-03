package com.sdk.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		long systemTime = System.currentTimeMillis();
		if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {

		} else {
			Intent mIntent = new Intent("alarm");
			mIntent.putExtra("current-time", systemTime);
			LocalBroadcastManager.getInstance(context.getApplicationContext()).sendBroadcast(mIntent);
		}
	}
}