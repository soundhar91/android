package com.example.programcontestnotifier;

import java.util.TimeZone;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
    	 Context context = getApplicationContext();
         if (Badge.isBadgingSupported(context)) {
             Badge badge = Badge.getBadge(context);
             Badge badge1 = new Badge();
             badge1.mPackage = context.getPackageName();
             badge1.mClass = getClass().getName(); // This should point to Activity declared as android.intent.action.MAIN
             badge1.mBadgeCount = 1;
             badge1.save(context);
             // This indicates there is no badge record for your app yet
             if (badge == null) {
             	Log.d("No Badge Record\n","good luck");
             	
                 return true;
             } else {
                 Log.d("Badge", badge.toString());
             }
         }



        return true;
    }
    public void get_timezone_fork(View v)
    {
    	Intent in = new Intent(this,DisplayEvents.class);
    	startActivity(in);
    }
    
}
