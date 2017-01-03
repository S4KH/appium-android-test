package com.example.hellosharedpreference;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private final String key = "SHARED_PREFERENCE_STRING_KEY";

	// input : "id1: f6ecbe56-5680-42b8-a809-71ad39cd92dc id2: 1 id3: 6"
	// output : "f6ecbe56-5680-42b8-a809-71ad39cd92dc" "1" " 6"

	private Button mButton1;
	private Button mButton2;
	private TextView result;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mButton1 = (Button) findViewById(R.id.button1);
		mButton2 = (Button) findViewById(R.id.button2);
		result = (TextView) findViewById(R.id.result);
	}

	public void runButton1Function1(View view) {

		BeaconInfoExtractor mBeaconInfoExtractor = new BeaconInfoExtractor();

		String str = "id1: f6ecbe56-5680-42b8-a809-71ad39cd92dc id2: 1 id3: 6";

		String uuid = mBeaconInfoExtractor.obtainUUID(str);
		String major = mBeaconInfoExtractor.obtainMajorID(str);
		String minor = mBeaconInfoExtractor.obtainMinorID(str);

		result.setText(uuid + "-" + major + "-" + minor);
	}

	public void runButton1Function2(View view) {

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
