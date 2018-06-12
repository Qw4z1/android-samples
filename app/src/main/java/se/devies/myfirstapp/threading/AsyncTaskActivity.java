package se.devies.myfirstapp.threading;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import se.devies.myfirstapp.R;

public class AsyncTaskActivity extends AppCompatActivity {

    private TextView mTextView;
    private TextView mProgressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        mTextView = (TextView) findViewById(R.id.textView);
        mProgressText = (TextView) findViewById(R.id.progressText);
    }

    public void onResume() {
        super.onResume();
        DownloadFilesTask task = new DownloadFilesTask();
        task.execute("http://www.kicksort.se");
    }


    private class DownloadFilesTask extends AsyncTask<String, Integer, String> {

        @Override protected String doInBackground(String... urls) {
            String response = "";
            int count = urls.length;

            for (int i = 0; i < count; i++) {
                response += Downloader.downloadData(urls[i]);
                publishProgress((int) ((i / (float) count) * 100));
                if (isCancelled()) {
                    break;
                }
            }
            return response;
        }

        @Override protected void onProgressUpdate(Integer... values) {
            mProgressText.setText("Downloaded " + values);
        }

        @Override protected void onPostExecute(String result) {
            mTextView.setText(result);
        }
    }

}
