package com.example.bibeka.iva;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
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

public class Login extends AppCompatActivity {
    EditText ed1,ed2;
    String v1id,v1pass;
    public String lurl = "https://onlyforyou446.000webhostapp.com/voteruserlogin.php";
    private static final String KEY_ID = "v_id";
    private static final String KEY_PASSWORD = "v_Password";
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        reffrence();
    }

    private void reffrence() {

        ed1=(EditText)findViewById(R.id.vid);
        ed2=(EditText)findViewById(R.id.vpass);


    }

    public void login(View view) {
       v1id=ed1.getText().toString();
       v1pass=ed2.getText().toString();


        if (TextUtils.isEmpty(v1id))
        {
            ed1.setError("Please Enter Your Id");
        }
        else
        {

            if (TextUtils.isEmpty(v1pass))
            {
                ed2.setError("Please Enter Your password");
            }
            else
            {
                load = ProgressDialog.show(this,"Please wait...","You Are On The Way...",false,false);
                StringRequest request1 = new StringRequest(Request.Method.POST, lurl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if (response.trim().equals("success")) {
                            Toast.makeText(getApplicationContext(), "YOU ARE LOGED IN", Toast.LENGTH_SHORT).show();
                            load.dismiss();
                            Intent a = new Intent(Login.this,faterlogin.class);
                            a.putExtra("r",v1id);
                            startActivity(a);



                        } else {
                            Toast.makeText(getApplicationContext(), "CHECK YOUR ID AND PASSWORD OR INTENET CONNECTION", Toast.LENGTH_LONG).show();
//   /
                        }

                    }
                },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), "Error OCCURED OR CHECK YOUR INTENET CONNECTION", Toast.LENGTH_SHORT).show();
                            }

                        })

                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> map = new HashMap<String,String>();
                        map.put(KEY_ID,v1id);
                        map.put(KEY_PASSWORD,v1pass);
                        return map;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(request1);
            }
        }

    }
}
