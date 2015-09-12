package com.example.jiji30000.listactivity;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StringBuffer stringBuffer = new StringBuffer();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10 ; ++i){
            stringBuffer.append(i);
            list.add(stringBuffer.toString());
            stringBuffer.setLength(0);
        }
        setListAdapter(new ListViewAdapter(this, R.layout.list_item, list));
    }

    class ViewHolder {
        TextView tv;
    }

    public class ListViewAdapter extends ArrayAdapter<String> {
        private LayoutInflater inflater;
        private int itemLayout;
        private String str;

        public ListViewAdapter(Context context, int itemLayout,  List<String> list) {
            super(context, 0, list);
            this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.itemLayout = itemLayout;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = inflater.inflate(itemLayout, parent, false);
                holder = new ViewHolder();
                holder.tv = (TextView) convertView.findViewById(R.id.textView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            str = getItem(position);
            holder.tv.setText(str);
            return convertView;
        }
    }
}