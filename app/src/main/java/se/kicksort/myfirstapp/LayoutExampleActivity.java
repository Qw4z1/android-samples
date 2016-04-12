package se.kicksort.myfirstapp;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LayoutExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_example);

        ViewGroup root = (ViewGroup) findViewById(R.id.root);

        LinearLayout linearLayout = createLayoutProgrammatically(this);
        root.addView(linearLayout);

        inflateDynamically(root);
    }

    public LinearLayout createLayoutProgrammatically(Context context) {
        LinearLayout layout = new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT );
        layout.setLayoutParams(params);
        layout.setBackgroundColor(Color.BLUE);

        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView textView = new TextView(context);
        textView.setLayoutParams(textParams);
        textView.setText("Programmatically added view");

        layout.addView(textView);

        return layout;
    }

    public void inflateDynamically(ViewGroup root) {
        LayoutInflater inflater = getLayoutInflater();
        inflater.inflate(R.layout.simple_layout, root);
    }
}
