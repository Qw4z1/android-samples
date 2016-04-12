package se.kicksort.myfirstapp.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import se.kicksort.myfirstapp.DummyContent;
import se.kicksort.myfirstapp.R;

public class ListViewActivity extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        mListView = (ListView) findViewById(R.id.list);
        ExampleAdapter adapter = new ExampleAdapter(this, DummyContent.TITLES);
        mListView.setAdapter(adapter);
    }
}
