package com.abdul.telstraapp;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

        try {
            JSONObject rootJsonObject = new JSONObject(jsonString);
            JSONArray itemsArray = rootJsonObject.getJSONArray("items");
            for(int i = 0; i<itemsArray.length(); i++){
                JSONObject book = itemsArray.getJSONObject(i);
                String title=null;
                String authors=null;
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");
                try {
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");
                } catch (Exception e){
                    e.printStackTrace();
                }

                if (title != null && authors != null){
                    TitleText.setText(title);
                    AuthorText.setText(authors);
                    return;
                }
                TitleText.setText("No Results Found");
                AuthorText.setText("");
            }


            } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
