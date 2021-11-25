package com.example.bibeka.iva;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class vote extends AppCompatActivity {
    TextView name2,id2,pin2,party2,vote2;
    String unamedataFromIntent,uiddataFromIntent,upassworddataFromIntent,uphonenodataFromIntent,uvaluedataFromIntent;
    String dataFromIntent;
    Integer voteupdate,valueupdate;
    String iddataFromIntent;
    String namedataFromIntent;
    String pindataFromIntent;
    String partydataFromIntent;
    String votedataFromIntent;

    private static final String URl ="https://onlyforyou446.000webhostapp.com/voted.php?Rg=";
    private static final String URl1 ="https://onlyforyou446.000webhostapp.com/voted1.php?Rg1=";

    private static final String KEY_NAME="vname";
    private static final String KEY_ID="vid";
    private static final String KEY_PASSWORD ="vpassword";
    private static final String KEY_PHONENO="vphoneno";
    private static final String KEY_PIN="vpin";
    private static final String KEY_VALUE="vvalue";
    public static final String KEY_vote = "vote2";
    private ProgressDialog load;
    private ProgressDialog load1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);
        name2=(TextView)findViewById(R.id.namedrop);
        id2=(TextView)findViewById(R.id.iddrop);
        party2=(TextView)findViewById(R.id.phonedrop);
        pin2=(TextView)findViewById(R.id.pindrop);
        vote2=(TextView)findViewById(R.id.votedrop);


         iddataFromIntent = getIntent().getStringExtra("id1");
         namedataFromIntent = getIntent().getStringExtra("name1");
         pindataFromIntent = getIntent().getStringExtra("pin1");
         partydataFromIntent = getIntent().getStringExtra("party1");
         votedataFromIntent = getIntent().getStringExtra("vote1");
        voteupdate=Integer.parseInt(votedataFromIntent);



        //User Data Get Though Intent.


        dataFromIntent = getIntent().getStringExtra("pin");
        unamedataFromIntent = getIntent().getStringExtra("name");
        uiddataFromIntent = getIntent().getStringExtra("id");
        uvaluedataFromIntent = getIntent().getStringExtra("value");
        upassworddataFromIntent = getIntent().getStringExtra("password");
        uphonenodataFromIntent = getIntent().getStringExtra("phoneno");
        valueupdate=Integer.parseInt(uvaluedataFromIntent);




        name2.setText(namedataFromIntent);
        id2.setText(iddataFromIntent);
        party2.setText(partydataFromIntent);
        pin2.setText(pindataFromIntent);
        vote2.setText(votedataFromIntent);

        //Data Showed By Toast
       /* Toast.makeText(this, ""+dataFromIntent, Toast.LENGTH_SHORT).show();

        Toast.makeText(this, ""+unamedataFromIntent, Toast.LENGTH_SHORT).show();

        Toast.makeText(this, ""+uiddataFromIntent, Toast.LENGTH_SHORT).show();

        Toast.makeText(this, ""+uvaluedataFromIntent, Toast.LENGTH_SHORT).show();

        Toast.makeText(this, ""+upassworddataFromIntent, Toast.LENGTH_SHORT).show();

        Toast.makeText(this, ""+uphonenodataFromIntent, Toast.LENGTH_SHORT).show();*/

    }

    public void vote(View view) {
        if (valueupdate==0)
        {
            valueupdate= valueupdate+1;
            voteupdate=voteupdate+1;
            uvaluedataFromIntent=valueupdate.toString().trim();
            votedataFromIntent=voteupdate.toString().trim();
            String Rg=uiddataFromIntent;


            load = ProgressDialog.show(this,"Please wait...","You Are On The Way...",false,false);

            StringRequest request= new StringRequest(Request.Method.POST, URl+Rg, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(getApplicationContext(), "Please Wait ", Toast.LENGTH_SHORT).show();
                    load.dismiss();
                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), "Check Internet Connection Or Alrady Registed", Toast.LENGTH_LONG).show();
                        }

                    })
            {
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> param = new HashMap<String, String>();
                   /* param.put(KEY_NAME,unamedataFromIntent);
                    param.put(KEY_ID,uiddataFromIntent);
                    param.put(KEY_PASSWORD,upassworddataFromIntent);
                    param.put(KEY_PHONENO,uphonenodataFromIntent);
                    param.put(KEY_PIN,dataFromIntent);*/
                    param.put(KEY_VALUE,uvaluedataFromIntent);
                    return param;

                }
            };
            RequestQueue requestqueue = Volley.newRequestQueue(this);
            requestqueue.add(request);
               votedataupdate();

        }
               else
                  {

                       //COMMAND RUN IF VALUE IS MORE THAN 1
                      Toast.makeText(this, "You are alrady Voated", Toast.LENGTH_SHORT).show();
                  }
    }

    private void votedataupdate() {
        String Rg1=iddataFromIntent;
        load1 = ProgressDialog.show(this,"Please wait...","You Are On The Way...",false,false);

        StringRequest request= new StringRequest(Request.Method.POST, URl1+Rg1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Vote Succesful", Toast.LENGTH_SHORT).show();
                load1.dismiss();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Check Internet Connection Or Alrady Registed", Toast.LENGTH_LONG).show();
                    }

                })
        {
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> param = new HashMap<String, String>();
                   /* param.put(KEY_NAME,unamedataFromIntent);
                    param.put(KEY_ID,uiddataFromIntent);
                    param.put(KEY_PASSWORD,upassworddataFromIntent);
                    param.put(KEY_PHONENO,uphonenodataFromIntent);
                    param.put(KEY_PIN,dataFromIntent);*/
                param.put(KEY_vote,votedataFromIntent);
                return param;

            }
        };
        RequestQueue requestqueue = Volley.newRequestQueue(this);
        requestqueue.add(request);

    }
}
