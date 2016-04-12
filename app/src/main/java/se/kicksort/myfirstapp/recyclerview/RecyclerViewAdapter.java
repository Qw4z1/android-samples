package se.kicksort.myfirstapp.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import se.kicksort.myfirstapp.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ExampleViewHolder> {

    String[] mString;

    public RecyclerViewAdapter(String[] string) {
        mString = string;
    }

    @Override public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_example, parent, false);
        ExampleViewHolder holder = new ExampleViewHolder(view);
        return holder;
    }

    @Override public void onBindViewHolder(ExampleViewHolder holder, int position) {
        holder.textView.setText(mString[position]);
    }

    @Override public int getItemCount() {
        return mString.length;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
