package com.example.bibeka.iva;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

public class newcandicates extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    Integer value;
    String name,id,pass,vote;
    String phoneno,pin;
    private static final String URl ="https://onlyforyou446.000webhostapp.com/nominilistadd.php";
    private static final String KEY_NAME="cname";
    private static final String KEY_ID="cid";
    private static final String KEY_PARTY ="cparty";
    private static final String KEY_PIN="cpin";
    private static final String KEY_VOTE="cvote";
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newcandicates);
        e1=(EditText)findViewById(R.id.vname);
        e2=(EditText)findViewById(R.id.vtno);//patryn
        e3=(EditText)findViewById(R.id.vphno);//id
        e5=(EditText)findViewById(R.id.vpin);
    }

    public void signup(View view) {
        name=e1.getText().toString();
        phoneno=e2.getText().toString();
        id=e3.getText().toString();
        pin=e5.getText().toString();
        value=0;
        vote=value.toString();
        Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();
        load = ProgressDialog.show(this,"Please wait...","You Are On The Way...",false,false);
        StringRequest request= new StringRequest(Request.Method.POST, URl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Resgistation Succesful", Toast.LENGTH_SHORT).show();
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
                param.put(KEY_NAME,name);
                param.put(KEY_ID,id);
                param.put(KEY_PARTY,phoneno);
                param.put(KEY_PIN,pin);
                param.put(KEY_VOTE,vote);
                return param;

            }
        };
        RequestQueue requestqueue = Volley.newRequestQueue(this);
        requestqueue.add(request);
    }
}
