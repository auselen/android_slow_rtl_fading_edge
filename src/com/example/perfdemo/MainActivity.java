package com.example.perfdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView list = (ListView) findViewById(R.id.mainlist);
        list.setAdapter(new TrivialListAdapter());
    }
}
