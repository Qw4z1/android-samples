package se.devies.myfirstapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private static final String EXTRA_TEXT = "se.kicksort.myfirstapp.EXTRA_TEXT";

    public static void startSecondActivity(Context context, String text) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(EXTRA_TEXT, text);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String theText = "";
        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_TEXT)) {
            theText = intent.getStringExtra(EXTRA_TEXT);
        }
        TextView textView = (TextView) findViewById(R.id.text2);
        textView.setText(theText);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this, "Replace with your own action", Toast.LENGTH_LONG).show();
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
