package com.example.stevtymez.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int y=item.getItemId();
        switch (y){

            case R.id.item1:
                Intent myintent =new Intent(home.this,home.class);
                startActivity(myintent);
                break;
            case R.id.item3:
                Intent myintent1 =new Intent(home.this,search.class);
                startActivity(myintent1);
                break;
            case R.id.item4:
                Intent myintent2 =new Intent(home.this,sign.class);
                startActivity(myintent2);
                break;

            case R.id.item5:
                Intent myintent3 =new Intent(home.this,tabbed.class);
                startActivity(myintent3);
                break;

            case R.id.item6:
                Intent myintent4 =new Intent(home.this,list.class);
                startActivity(myintent4);
                break;

            case R.id.item7:
                Intent myintent5 =new Intent(home.this,markets.class);
                startActivity(myintent5);
                break;
            default:
                return false;

        }




        return super.onOptionsItemSelected(item);
    }
}
