package com.example.stevtymez.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
//KIKWALO STEVEN 2017/BIT/147

public class MainActivity extends AppCompatActivity {

    public static final String me="custome message";
    public void openhome( View v){
      setContentView(R.layout.activity_home);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

            case R.id.imageView2:
                Intent myintent =new Intent(MainActivity.this,home.class);
                startActivity(myintent);
                break;
            case R.id.item3:
                Intent myintent1 =new Intent(MainActivity.this,search.class);
                startActivity(myintent1);
                break;
            case R.id.imageView4:
                Intent myintent2 =new Intent(MainActivity.this,sign.class);
                startActivity(myintent2);
                break;

            default:
                return false;

        }




        return super.onOptionsItemSelected(item);
    }

}