package com.example.programcontestnotifier;

import java.util.TimeZone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class DisplayEvents extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_events);
		Intent in = 	getIntent();
		TimeZone tz = getCurrentTimeZone();
		// get the json object and populate a list
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_events, menu);
		return true;
	}
	public TimeZone getCurrentTimeZone()
	{
		TimeZone tz = TimeZone.getDefault();
    	Log.e("The timezone name", tz.getDisplayName());
    	Log.e("The time zone", tz.getID());
    	return tz;
	}
	

}
