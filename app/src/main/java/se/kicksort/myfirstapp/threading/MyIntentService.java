package se.kicksort.myfirstapp.threading;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * helper methods.
 */
public class MyIntentService extends IntentService {

    private static final String ACTION_DOWNLOAD = "se.kicksort.myfirstapp.threading.action.DOWNLOAD";

    private static final String EXTRA_URL = "se.kicksort.myfirstapp.threading.extra.PARAM_URL";
    private static final String EXTRA_RECEIVER = "se.kicksort.myfirstapp.threading.extra.PARAM_RECEIVER";

    public MyIntentService() {
        super("MyIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    public static void startActionDownload(Context context, String url, ServiceActivity.MyReceiver myReceiver) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_DOWNLOAD);
        intent.putExtra(EXTRA_URL, url);
        intent.putExtra(EXTRA_RECEIVER, myReceiver);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_DOWNLOAD.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_URL);
                String result = Downloader.downloadData(param1);
                ResultReceiver receiver = intent.getParcelableExtra(EXTRA_RECEIVER);
                Bundle bundle = new Bundle();
                bundle.putString("data", result);
                receiver.send(100, bundle);
            }
        }
    }

}
