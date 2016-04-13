package se.kicksort.myfirstapp.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import se.kicksort.myfirstapp.R;

public class CustomViewXml extends LinearLayout{
    public CustomViewXml(Context context) {
        super(context);
        init(context);
    }

    public CustomViewXml(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomViewXml(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setOrientation(VERTICAL);
        LayoutInflater.from(context).inflate(R.layout.custom_view_layout, this, true);
    }

}
