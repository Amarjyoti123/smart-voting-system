package com.example.bibeka.iva;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class adminlogin extends AppCompatActivity {
    EditText E1,E2;
    String adminid,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

         E1=(EditText)findViewById(R.id.iddrop);
        E2=(EditText)findViewById(R.id.password);

    }

    public void loginadmin(View view) {
        adminid=E1.getText().toString().trim();
        password=E2.getText().toString().trim();
        if (TextUtils.isEmpty(adminid))
        {
            E1.setError("Please Enter Your Id");
        }

        else
        {
            if (TextUtils.isEmpty(password))
            {
                E2.setError("Please Enter Your Password");
            }

            else
            {
                if (adminid.equals("govadmin"))
                {
                    if (password.equals("govadmin"))
                    {
                        Intent a = new Intent(adminlogin.this,newcandicates.class);
                        startActivity(a);
                    }
                    else{
                        Toast.makeText(this, "Entered  Password Is Wrong Please Renter", Toast.LENGTH_LONG).show();

                    }

                }
                else
                {
                    Toast.makeText(this, "Entered Admin Id  Is Wrong Please Renter", Toast.LENGTH_LONG).show();
                }
            }
        }


    }
}
