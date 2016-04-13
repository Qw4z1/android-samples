package se.kicksort.myfirstapp.threading;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;

import android.support.v4.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import se.kicksort.myfirstapp.R;

public class ServiceActivity extends AppCompatActivity {

    private static final String URL = "http://www.kicksort.se";
    private TextView mTextView;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTextView = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                MyIntentService.startActionDownload(getApplicationContext(),
                        URL,
                        new MyReceiver(mHandler));
            }
        });


    }

    class UIRunnable implements Runnable {

        private String text;

        public UIRunnable(String text) {
            this.text = text;
        }

        @Override public void run() {
            mTextView.setText(text);
        }
    }

    @SuppressLint("ParcelCreator")
    class MyReceiver extends ResultReceiver {

        /**
         * Create a new ResultReceive to receive results.  Your
         * {@link #onReceiveResult} method will be called from the thread running
         * <var>handler</var> if given, or from an arbitrary thread if null.
         *
         * @param handler
         */
        public MyReceiver(Handler handler) {
            super(handler);
        }

        @Override protected void onReceiveResult(int resultCode, Bundle resultData) {
            String result = resultData.getString("data");
            runOnUiThread(new UIRunnable(result));
        }
    }
}
