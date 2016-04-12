package se.kicksort.myfirstapp.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import se.kicksort.myfirstapp.R;

public class ExampleAdapter extends BaseAdapter {

    LayoutInflater mLayoutInflater;
    String[] mStrings;

    public ExampleAdapter(Context context, String[] strings) {
        mLayoutInflater = LayoutInflater.from(context);
        mStrings = strings;
    }

    @Override public int getCount() {
        if (mStrings == null) {
            return 0;
        } else {
            return mStrings.length;
        }
    }

    @Override public Object getItem(int position) {
        if (mStrings == null) {
            return null;
        } else {
            return mStrings[position];
        }
    }

    @Override public long getItemId(int position) {
        return position;
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.listitem_example, parent, false);
            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(holder);
        }
        holder = (ViewHolder) convertView.getTag();
        holder.textView.setText(mStrings[position]);
        return convertView;
    }

    private static class ViewHolder {
        TextView textView;
    }
}
