package com.example.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
     	Log.d("No Badge Record\n","good luck");
        getMenuInflater().inflate(R.menu.main, menu);
      	 Context context = getApplicationContext();
         if (Badge.isBadgingSupported(context)) {
             Badge badge = Badge.getBadge(context);

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
}
