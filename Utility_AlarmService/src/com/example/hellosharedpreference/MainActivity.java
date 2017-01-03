package com.example.hellosharedpreference;

import java.util.Calendar;

import com.sdk.alarm.AlarmReceiver;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@SuppressWarnings("unused")
	private Button mButton1;
	@SuppressWarnings("unused")
	private Button mButton2;

	private TextView resultTxt;

	private static PendingIntent pendingIntent;
	private static long timeWhenAlarmSet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mButton1 = (Button) findViewById(R.id.button1);
		mButton2 = (Button) findViewById(R.id.button2);
		resultTxt = (TextView) findViewById(R.id.result);

		LocalBroadcastManager.getInstance(this.getApplicationContext()).registerReceiver(mMessageReceiver,
				new IntentFilter("alarm"));
	}

	public void runButton1Function1(View view) {

		setAlarm(this.getApplicationContext());

	}

	public void runButton1Function2(View view) {

	}

	private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {

			long defaultValue = 0;
			long current_alarm_alert_time = 0;
			current_alarm_alert_time = intent.getLongExtra("current-time", defaultValue);

			runToast(current_alarm_alert_time);
		}
	};

	protected void runToast(long current_alarm_alert_time) {

		long time_diff = (current_alarm_alert_time - timeWhenAlarmSet) - 5000; // 5000
																				// :
																				// 5sec

		if (time_diff < 100) {
			resultTxt.setText("" + time_diff);
			 Toast.makeText(this, "Alarm Success : time difference=[" +
			 time_diff + " msec]", Toast.LENGTH_SHORT).show();

		} else {
			resultTxt.setText("" + time_diff);
			 Toast.makeText(this, "Alarm Fail : time difference=[" + time_diff
			 + " msec]", Toast.LENGTH_SHORT).show();
		}
	}

	private static void setAlarm(Context context) {
		AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

		Calendar calendar = Calendar.getInstance();

		timeWhenAlarmSet = System.currentTimeMillis();
		calendar.setTimeInMillis(timeWhenAlarmSet);

		// calendar.add(Calendar.DATE, 1);
		calendar.add(Calendar.SECOND, 5);

		Intent alarmIntent = new Intent(context.getApplicationContext(), AlarmReceiver.class);
		pendingIntent = PendingIntent.getBroadcast(context.getApplicationContext(), 0, alarmIntent, 0);
		manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
