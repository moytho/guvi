package com.guvi.gt.lataxidriver.net.WSAsyncTasks;

import android.os.AsyncTask;

import org.json.JSONObject;

import com.guvi.gt.lataxidriver.model.TripBean;
import com.guvi.gt.lataxidriver.net.invokers.TripCompletionInvoker;

/**
 * Created by Jemsheer K D on 12 June, 2017.
 * Package com.guvi.gt.lataxidriver.net.WSAsyncTasks
 * Project LaTaxiDriver
 */

public class TripCompletionTask extends AsyncTask<String, Integer, TripBean> {

    private TripCompletionTaskListener tripCompletionTaskListener;

    private JSONObject postData;

    public TripCompletionTask(JSONObject postData) {
        super();
        this.postData = postData;
    }

    @Override
    protected TripBean doInBackground(String... params) {
        System.out.println(">>>>>>>>>doInBackground");
        TripCompletionInvoker tripCompletionInvoker = new TripCompletionInvoker(null, postData);
        return tripCompletionInvoker.invokeTripCompletionWS();
    }

    @Override
    protected void onPostExecute(TripBean result) {
        super.onPostExecute(result);
        if (result != null)
            tripCompletionTaskListener.dataDownloadedSuccessfully(result);
        else
            tripCompletionTaskListener.dataDownloadFailed();
    }

    public static interface TripCompletionTaskListener {
        void dataDownloadedSuccessfully(TripBean tripBean);

        void dataDownloadFailed();
    }

    public TripCompletionTaskListener getTripCompletionTaskListener() {
        return tripCompletionTaskListener;
    }

    public void setTripCompletionTaskListener(TripCompletionTaskListener tripCompletionTaskListener) {
        this.tripCompletionTaskListener = tripCompletionTaskListener;
    }
}
