package com.example.bibeka.iva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class firstactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstactivity);
    }

    public void adduser(View view) {
        Intent i = new Intent(firstactivity.this,newuser.class);
        //Toast.makeText(this, "login here", Toast.LENGTH_SHORT).show();
        startActivity(i);

    }

    public void loginuser(View view) {
        Intent i = new Intent(firstactivity.this,Login.class);
       // Toast.makeText(this, "Join here", Toast.LENGTH_SHORT).show();
        startActivity(i);

    }

    public void Winner(View view) {
        Intent i = new Intent(firstactivity.this,winerlist.class);
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        startActivity(i);
    }

    public void notice(View view) {
        Intent i = new Intent(firstactivity.this,shownotice.class);
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        startActivity(i);

    }

    public void admin(View view) {
        Intent i = new Intent(firstactivity.this,adminlogin.class);
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        startActivity(i);
    }
}
