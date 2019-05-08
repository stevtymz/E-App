package com.example.stevtymez.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
//KIKWALO STEVEN 2017/BIT/147

public class MainActivity extends AppCompatActivity {
    Button t;
    public static final String me="custome message";


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = findViewById(R.id.btn3);
        // loading of home activity
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent explicitIntent = new Intent(getApplicationContext(),home.class);
                startActivity(explicitIntent);
                }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(me,"onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(me,"onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(me,"onResume");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int y=item.getItemId();
        switch (y){

            case R.id.item1:
                Intent myintent =new Intent(MainActivity.this,home.class);
                startActivity(myintent);
                break;
            case R.id.item3:
                Intent myintent1 =new Intent(MainActivity.this,search.class);
                startActivity(myintent1);
                break;
            case R.id.item4:
                Intent myintent2 =new Intent(MainActivity.this,sign.class);
                startActivity(myintent2);
                break;

            case R.id.item5:
                Intent myintent3 =new Intent(MainActivity.this,tabbed.class);
                startActivity(myintent3);
                break;

            case R.id.item6:
                Intent myintent4 =new Intent(MainActivity.this,list.class);
                startActivity(myintent4);
                break;
            default:
                return false;

        }




        return super.onOptionsItemSelected(item);
    }

    public void openhome(View view) {

    }
}
