package com.example.hellosharedpreference;

import com.sdk.global.NetworkSingleton;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private final String key = "SHARED_PREFERENCE_STRING_KEY";

	private Button mButton1;
	private Button mButton2;
	private TextView resultTxt;
	private NetworkSingleton mNetworkSingleton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mButton1 = (Button) findViewById(R.id.button1);
		mButton2 = (Button) findViewById(R.id.button2);
		resultTxt = (TextView) findViewById(R.id.result);

	}

	public void runButton1Function1(View view) {

		BluetoothAdapter bluetooth = BluetoothAdapter.getDefaultAdapter();
		int mBTStatusValue = bluetooth.getState(); // 10 : BT State Off, 12 : BT
													// State On

		if (10 == mBTStatusValue) {
			resultTxt.setText("Bluetooth Status OFF");
			// Toast.makeText(this, "Bluetooth Status OFF",
			// Toast.LENGTH_SHORT).show();
		} else if (12 == mBTStatusValue) {
			resultTxt.setText("Bluetooth Status ON");
			// Toast.makeText(this, "Bluetooth Status ON",
			// Toast.LENGTH_SHORT).show();
		}
	}

	public void runButton1Function2(View view) {

		mNetworkSingleton = new NetworkSingleton(this.getApplicationContext());
		boolean mCurrentNetworkStatus = mNetworkSingleton.getCurrentNetworkStatus();
		if (false == mCurrentNetworkStatus) {
			resultTxt.setText("Network Status OFF");
			// Toast.makeText(this, "Network Status OFF",
			// Toast.LENGTH_SHORT).show();
		} else {
			resultTxt.setText("Network Status ON");
			// Toast.makeText(this, "Network Status ON",
			// Toast.LENGTH_SHORT).show();
		}
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
