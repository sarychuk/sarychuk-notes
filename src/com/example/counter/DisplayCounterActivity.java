package com.example.counter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class DisplayCounterActivity extends Activity {
	
	public final static String EXTRA_MESSAGE = "com.example.counter.MESSAGE";

	public final String FILENAME = "Counter.sav";
	
	public CounterModel counterObject;
	private ArrayList<CounterModel> counterModels;
	private Integer index;
	private Button buttonCounter;
	private TextView typedCounterName;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_counter);
		
		// Create the counter
		index = getIntent().getExtras().getInt("index");
		
		counterObject = counterModels.get(index);
        
		typedCounterName = (TextView) findViewById(R.id.counterName);
		typedCounterName.setText(counterObject.getCounterName());
		typedCounterName.setTextSize(40);
		
		buttonCounter = (Button) findViewById(R.id.buttonCounter);
		buttonCounter.setText(Integer.toString(counterObject.getCounterCount()));
		
		// White
		typedCounterName.setTextColor(0xffffffff);
		
		// Show the Up button in the action bar.
		setupActionBar();	
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void incrementCounter(View view) {
		counterObject.incrementCounter();

		buttonCounter.setText(counterObject.getCounterCount());
	}
	
	public void resetCounter(View view) {
		counterObject.resetCounter();
		
		buttonCounter.setText(counterObject.getCounterCount());
	}

}
