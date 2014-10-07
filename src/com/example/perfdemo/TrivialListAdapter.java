package com.example.perfdemo;

import java.util.Random;

import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

public class TrivialListAdapter implements ListAdapter {
    
    private static final int COUNT = 1000;
    private static final String[] texts;
    
    static {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        texts = new String[COUNT];
        for (int t=0; t<COUNT; ++t) {
            sb.setLength(0);
            rand.setSeed(t);
            final int n;
            if (t % 20 == 1) {
                n = 100;
            } else {
                n = 1 + rand.nextInt(20);
            }
            for (int i=0; i < n; ++i) {
                sb.append((char)('a' + rand.nextInt(26)));
            }
            sb.append(" ");
            sb.append(t);
            texts[t] = sb.toString();
        }
    }
    
    @Override
    public int getCount() {
        return COUNT;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final TextView text;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.listitem, parent, false);
            text = (TextView)view.findViewById(R.id.text1);
            view.setTag(text);
        } else {
            text = (TextView)view.getTag();
        }
        
        text.setText(texts[position]);
        return view;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

}
