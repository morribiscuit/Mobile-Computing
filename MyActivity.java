package com.example.AsyncHttpPostLab9;


        import android.app.Activity;
        import android.widget.TextView;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.TextView;
        import org.apache.http.HttpResponse;
        import org.apache.http.NameValuePair;
        import org.apache.http.StatusLine;
        import org.apache.http.client.ClientProtocolException;
        import org.apache.http.client.HttpClient;
        import org.apache.http.client.entity.UrlEncodedFormEntity;
        import org.apache.http.client.methods.HttpPost;
        import org.apache.http.impl.client.DefaultHttpClient;
        import org.apache.http.message.BasicNameValuePair;
        import org.apache.http.util.EntityUtils;
        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.io.IOException;
        import java.io.UnsupportedEncodingException;
        import java.net.HttpURLConnection;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.logging.Handler;


public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void processJSON(String json){
        try {
            JSONArray all = new JSONArray(json);
            for (int i=0; i<json.length(); i++){
                JSONObject item=all.getJSONObject(i);
                String license = item.getString("$license");
                String description = item.getString("description");
                TextView t = (TextView) findViewById (R.id.TextView);
                t.setText(i + ": " + license + "\n");
                System.out.println(license);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    public void button(View v){
        AsyncHttpPost.AsyncHandler handler = new AsyncHttpPost.AsyncHandler(); {
            AsyncHttpPost asyncHttpPost = new AsyncHttpPost(new AsyncHttpPost.AsyncHandler() {
                @Override
                public void handleResponse(String response) {
                    TextView t = (TextView) findViewById(R.id.TextView);
                    t.setText(response);
                    // response = AsyncHttpPost.execute("http://courses.ms.wits.ac.za/test.php");
                    processJSON(response);
                }




        });
        asyncHttpPost.execute("http://courses.ms.wits.ac.za/test.php");

       // TextView t = (TextView) findViewById (R.id.TextView);
       // AsyncHttpPost asyncHttpPost = new AsyncHttpPost(t);
       //add in execute to upload from the database
    }





}




