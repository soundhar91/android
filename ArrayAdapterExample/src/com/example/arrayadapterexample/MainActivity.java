package com.example.arrayadapterexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] s = {"hi","myname","is","soundar"};
        final ArrayList<String> al = new ArrayList<String>();
        int i;
        for(i=0;i<s.length;i++)
        {
        	al.add(s[i]);
        }
        
        final MyAdapter mad = new MyAdapter(this,android.R.layout.simple_list_item_1,al);
        
        ListView list_view = (ListView) findViewById(R.id.listview);
        
        list_view.setAdapter(mad);
        
        
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                int position, long id) {
              final String item = (String) parent.getItemAtPosition(position);
              view.animate().setDuration(1000).alpha(0)
                  .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                      al.remove(item);
                      mad.notifyDataSetChanged();
                      view.setAlpha(1);
                    }
                  });
            }

          });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

final class MyAdapter extends ArrayAdapter<String>
{
	HashMap<String,Integer> h = new HashMap<String,Integer >();
	int i;
	
	public MyAdapter(Context t,int a,List<String> objects)
	{
		super(t,a,objects);
		for(i=0;i<objects.size();i++)
		{
				h.put(objects.get(i), i+10);
		}
	}
	@Override
	public long getItemId(int position)
	{
		String temp = getItem(position);
		return h.get(temp);
	}
	
	
}
