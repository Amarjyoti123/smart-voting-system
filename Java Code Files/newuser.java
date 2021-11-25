package com.example.bibeka.iva;

import android.app.ProgressDialog;
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

public class newuser extends AppCompatActivity {
EditText e1,e2,e3,e4,e5;
    Integer value;
    String name,id,pass,valuepass;
    String phoneno,pin;
    private static final String URl ="https://onlyforyou446.000webhostapp.com/voterlistadd.php";
    private static final String KEY_NAME="vname";
    private static final String KEY_ID="vid";
    private static final String KEY_PASSWORD ="vpassword";
    private static final String KEY_PHONENO="vphoneno";
    private static final String KEY_PIN="vpin";
    private static final String KEY_VALUE="vvalue";
    private ProgressDialog load;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newuser);
        reffrence();
    }


    private void reffrence() {
        e1=(EditText)findViewById(R.id.vname);
        e2=(EditText)findViewById(R.id.vtno);
        e3=(EditText)findViewById(R.id.vphno);
        e4=(EditText)findViewById(R.id.vpass);
        e5=(EditText)findViewById(R.id.vpin);
    }




    public void signup(View view) {
        name=e1.getText().toString();
        id=e2.getText().toString();
        phoneno=e3.getText().toString();
        pass=e4.getText().toString();
        pin=e5.getText().toString();
        value=0;
        valuepass=value.toString();
       // Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();
        if (TextUtils.isEmpty(name))
        {
            e1.setError("Please Enter Your Name");
        }
        else
        {

            if (TextUtils.isEmpty(id))
            {
                e2.setError("Please Enter Your Id");
            }
            else
            {

                if (TextUtils.isEmpty(phoneno))
                {
                    e3.setError("Please Enter Your Phone no");
                }
                else
                {
                    if (phoneno.length()==10)
                    {

                        if (TextUtils.isEmpty(pass))
                        {
                            e4.setError("Please Enter Your Password");
                        }
                        else
                        {
                            if (TextUtils.isEmpty(pin))
                            {
                                e5.setError("Please Enter Your Pin");
                            }
                            else
                            {
                                if (pin.length()==6)
                                {


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
                                            param.put(KEY_PASSWORD,pass);
                                            param.put(KEY_PHONENO,phoneno);
                                            param.put(KEY_PIN,pin);
                                            param.put(KEY_VALUE,valuepass);
                                            return param;

                                        }
                                    };
                                    RequestQueue requestqueue = Volley.newRequestQueue(this);
                                    requestqueue.add(request);

                                }
                                else
                                {
                                    e5.setError("Please Enter Correct Pin");
                                }
                            }
                        }
                    }
                    else
                    {
                        e3.setError("Please Enter Correct Phone no");
                    }
                }
            }
        }



    }
}
