package com.example.bibeka.iva;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class faterlogin extends AppCompatActivity {
    private ProgressDialog load;
    TextView namedrop1,iddrop1,pindrop1,phonedrop1,valuedrop1;
    String pin = "";
    String name = "";
    String id = "";
    String value = "";
    String phoneno1 = "";
    String password = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faterlogin);
        reference();

        String dataFromIntent = getIntent().getStringExtra("r");
        String Rg=dataFromIntent;



        load = ProgressDialog.show(this,"Please wait...","Fetching Details...",false,false);
        String url2 = Config.DATA_URL+Rg;

        StringRequest stringRequest1 = new StringRequest(url2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response11) {
                showJSON11(response11);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(faterlogin.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue2 = Volley.newRequestQueue(this);
        requestQueue2.add(stringRequest1);
    }

    private void reference() {
        namedrop1=(TextView)findViewById(R.id.namedrop);
        iddrop1=(TextView)findViewById(R.id.iddrop);
        pindrop1=(TextView)findViewById(R.id.pindrop);
        phonedrop1=(TextView)findViewById(R.id.phonedrop);
        valuedrop1=(TextView)findViewById(R.id.votedrop);
    }

    private void showJSON11(String response11) {


        try {
            JSONObject jsonObject = new JSONObject(response11);
            JSONArray result1 = jsonObject.getJSONArray(Config.JSON_ARRAY);
            JSONObject collegeData1 = result1.getJSONObject(0);
            name = collegeData1.getString(Config.KEY_NAME);
            id = collegeData1.getString(Config.KEY_ID);
            pin = collegeData1.getString(Config.KEY_PIN);
            value = collegeData1.getString(Config.VALUE);
            phoneno1 = collegeData1.getString(Config.KEY_phoneno);
            password = collegeData1.getString(Config.KEY_password);


        }
        catch (JSONException e) {
            e.printStackTrace();
        }


        namedrop1.setText(name);
        iddrop1.setText(id);
        pindrop1.setText(pin);
        phonedrop1.setText(phoneno1);
        Integer value1=Integer.parseInt(value);
        if (value1==0)
        {
            valuedrop1.setText("PENDING");
        }
        else
        {
            valuedrop1.setText("VOTED");

        }

       /* Toast.makeText(this, "Name :"+name, Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Id :"+id, Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Pin :"+pin, Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Value :"+value, Toast.LENGTH_LONG).show();
        Toast.makeText(this, "password"+password, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "phoneo"+phoneno1, Toast.LENGTH_SHORT).show();*/
        load.dismiss();


    }

    public void vote(View view) {
        Intent i = new Intent(faterlogin.this,voterlogolist.class);
        startActivity(i);
        i.putExtra("pin",pin);
        i.putExtra("name",name);
        i.putExtra("id",id);
        i.putExtra("phoneno",phoneno1);
        i.putExtra("value",value);
        i.putExtra("password",password);
        startActivity(i);

    }
}

