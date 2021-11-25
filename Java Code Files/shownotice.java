package com.example.bibeka.iva;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class shownotice extends AppCompatActivity {
    ListView listView;
    String Rg;

    Button button;

    // Server Http URL
    String HTTP_URL = "https://onlyforyou446.000webhostapp.com/notice.php";


    // String to hold complete JSON response object.
    String FinalJSonObject;
    String unamedataFromIntent, uiddataFromIntent, upassworddataFromIntent, uphonenodataFromIntent, uvaluedataFromIntent;
    String dataFromIntent;
    String Name1, id1, pin1, party1, vote1;
    List<noticesub> CustomSubjectNamesList;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shownotice);
        listView = (ListView) findViewById(R.id.listView1);
        progressBar = (ProgressBar) findViewById(R.id.ProgressBar1);

        // dataFromIntent = getIntent().getStringExtra("pin");
        // Rg="752057";

       /* unamedataFromIntent = getIntent().getStringExtra("name");
        uiddataFromIntent = getIntent().getStringExtra("id");
        uvaluedataFromIntent = getIntent().getStringExtra("value");
        upassworddataFromIntent = getIntent().getStringExtra("password");
        uphonenodataFromIntent = getIntent().getStringExtra("phoneno");*/


        //Showing progress bar just after button click.
        progressBar.setVisibility(View.VISIBLE);

        // Creating StringRequest and set the JSON server URL in here.
        StringRequest stringRequest = new StringRequest(HTTP_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // After done Loading store JSON response in FinalJSonObject string variable.
                        FinalJSonObject = response;

                        // Calling method to parse JSON object.
                        new shownotice.ParseJSonDataClass(shownotice.this).execute();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        // Showing error message if something goes wrong.
                        // Toast.makeText(bjpnominatorlist.this,error.getMessage(),Toast.LENGTH_LONG).show();

                    }
                });

        // Creating String Request Object.
        RequestQueue requestQueue = Volley.newRequestQueue(shownotice.this);

        // Passing String request into RequestQueue.
        requestQueue.add(stringRequest);
    }

    private class ParseJSonDataClass extends AsyncTask<Void, Void, Void> {

        public Context context;

        // Creating List of Subject class.


        public ParseJSonDataClass(Context context) {

            this.context = context;
        }

        @Override
        protected void onPreExecute() {

            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            try {

                // Checking whether FinalJSonObject is not equals to null.
                if (FinalJSonObject != null) {

                    // Creating and setting up JSON array as null.
                    JSONArray jsonArray = null;
                    try {

                        // Adding JSON response object into JSON array.
                        jsonArray = new JSONArray(FinalJSonObject);

                        // Creating JSON Object.
                        JSONObject jsonObject;

                        // Creating Subject class object.
                        noticesub subject;

                        // Defining CustomSubjectNamesList AS Array List.
                        CustomSubjectNamesList = new ArrayList<noticesub>();

                        for (int i = 0; i < jsonArray.length(); i++) {

                            subject = new noticesub();

                            jsonObject = jsonArray.getJSONObject(i);

                            //Storing ID into subject list.
                            subject.Subject_DATE = jsonObject.getString("date");

                            //Storing Subject name in subject list.
                            subject.Subject_SUBJECT = jsonObject.getString("subject");



                            // Adding subject list object into CustomSubjectNamesList.
                            CustomSubjectNamesList.add(subject);
                        }
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result)

        {
            // After all done loading set complete CustomSubjectNamesList with application context to ListView adapter.
            noticelistviewadapter adapter = new noticelistviewadapter(CustomSubjectNamesList, context);

            // Setting up all data into ListView.
            listView.setAdapter(adapter);

            // Hiding progress bar after all JSON loading done.
            progressBar.setVisibility(View.GONE);

        }

    }
}
