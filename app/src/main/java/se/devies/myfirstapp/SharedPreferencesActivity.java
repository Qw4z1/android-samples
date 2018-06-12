package se.devies.myfirstapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPreferencesActivity extends AppCompatActivity implements View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener {

    public static final String PREFS_NAME = "MyFirstApp";
    public static final String FIRST_KEY = "first_key";
    public static final String SECOND_KEY = "second_key";

    private SharedPreferences mPrefs;
    private EditText mEditText;
    private TextView mTextView;
    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        mPrefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        mEditText = (EditText) findViewById(R.id.editText);
        mTextView = (TextView) findViewById(R.id.textView);
        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(this);
    }

    @Override protected void onResume() {
        super.onResume();
        mPrefs.registerOnSharedPreferenceChangeListener(this);
        if (mPrefs.contains(FIRST_KEY)) {
            mEditText.setText(mPrefs.getString(FIRST_KEY, "Default text"));
        }
    }

    @Override protected void onPause() {
        super.onPause();
        mPrefs.unregisterOnSharedPreferenceChangeListener(this);
        String text = mEditText.getText().toString();
        mPrefs.edit().putString(FIRST_KEY, text).apply();
    }

    @Override public void onClick(View v) {
        mPrefs.edit().putString(SECOND_KEY, mEditText.getText().toString()).apply();
    }

    @Override public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals(SECOND_KEY)) {
            mTextView.setText(sharedPreferences.getString(key, "no valu"));
        }
    }
}
