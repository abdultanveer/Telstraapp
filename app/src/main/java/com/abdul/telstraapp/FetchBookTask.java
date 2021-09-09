package com.abdul.telstraapp;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class FetchBookTask extends AsyncTask<String,Void,String> {
    public static String TAG = FetchBookTask.class.getSimpleName();

    private TextView TitleText;
    private TextView AuthorText;

    public FetchBookTask(TextView mTitleText, TextView mAuthorText) {
        TitleText = mTitleText;
        AuthorText = mAuthorText;
    }



    @Override
    protected String doInBackground(String... inputString) {
        return NetworkUtils.getBookInfo(inputString[0]);
    }

    @Override
    protected void onPostExecute(String jsonString) {
        super.onPostExecute(jsonString);
        Log.i(TAG,jsonString);

    }
}
