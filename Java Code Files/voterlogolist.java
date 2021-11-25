package com.example.bibeka.iva;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class voterlogolist extends AppCompatActivity {
    String Rg;
    String unamedataFromIntent,uiddataFromIntent,upassworddataFromIntent,uphonenodataFromIntent,uvaluedataFromIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voterlogolist);
        String pindataFromIntent = getIntent().getStringExtra("pin");
        Rg=pindataFromIntent;
        unamedataFromIntent = getIntent().getStringExtra("name");
         uiddataFromIntent = getIntent().getStringExtra("id");
        uvaluedataFromIntent = getIntent().getStringExtra("value");
         upassworddataFromIntent = getIntent().getStringExtra("password");
         uphonenodataFromIntent = getIntent().getStringExtra("phoneno");

    }

    public void bjd(View view) {
        Intent i = new Intent(voterlogolist.this,nominatorlist.class);
        i.putExtra("pin",Rg);
        i.putExtra("name",unamedataFromIntent);
        i.putExtra("id",uiddataFromIntent);
        i.putExtra("phoneno",uphonenodataFromIntent);
        i.putExtra("value",uvaluedataFromIntent);
        i.putExtra("password",upassworddataFromIntent);
        startActivity(i);

    }

    public void bjp(View view) {
        Intent i = new Intent(voterlogolist.this,bjpnominatorlist.class);
        i.putExtra("pin",Rg);
        i.putExtra("name",unamedataFromIntent);
        i.putExtra("id",uiddataFromIntent);
        i.putExtra("phoneno",uphonenodataFromIntent);
        i.putExtra("value",uvaluedataFromIntent);
        i.putExtra("password",upassworddataFromIntent);
        startActivity(i);

    }

    public void bsp(View view) {
        Intent i = new Intent(voterlogolist.this,bahujansamajnominatorlist.class);
        i.putExtra("pin",Rg);
        i.putExtra("name",unamedataFromIntent);
        i.putExtra("id",uiddataFromIntent);
        i.putExtra("phoneno",uphonenodataFromIntent);
        i.putExtra("value",uvaluedataFromIntent);
        i.putExtra("password",upassworddataFromIntent);
        startActivity(i);


    }

    public void congress(View view) {
        Intent i = new Intent(voterlogolist.this,congressnominatorlist.class);
        i.putExtra("pin",Rg);
        i.putExtra("name",unamedataFromIntent);
        i.putExtra("id",uiddataFromIntent);
        i.putExtra("phoneno",uphonenodataFromIntent);
        i.putExtra("value",uvaluedataFromIntent);
        i.putExtra("password",upassworddataFromIntent);
        startActivity(i);

    }

    public void ajp(View view) {
        Intent i = new Intent(voterlogolist.this,amjantapartynominatorlist.class);
        i.putExtra("pin",Rg);
        i.putExtra("name",unamedataFromIntent);
        i.putExtra("id",uiddataFromIntent);
        i.putExtra("phoneno",uphonenodataFromIntent);
        i.putExtra("value",uvaluedataFromIntent);
        i.putExtra("password",upassworddataFromIntent);
        startActivity(i);

    }
}
