package com.example.stevtymez.myapplication;

import android.app.ProgressDialog;
import android.icu.text.IDNA;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class home extends AppCompatActivity {
private EditText name;
private EditText password;
private Button btn1, but2;
private TextView tvInfo;
private int counter = 5;
private FirebaseAuth firebaseAuth;
private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        name = (EditText)findViewById(R.id.name);
        password = (EditText)findViewById(R.id.password);
        btn1 = (Button)findViewById(R.id.btn1);
        firebaseAuth =FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        FirebaseUser  user =firebaseAuth.getCurrentUser();
        if(user != null){
            finish();
            startActivity(new Intent(home.this,list.class));
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(), password.getText().toString());
            }
        });
        but2 = findViewById(R.id.butt);
        // loading of sign activity
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this, sign.class));
            }
        });

    }

    private void validate(String name, String password) {
        progressDialog.setMessage("Varification taking place");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(name, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(home.this, "login sucessful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(home.this,list.class));
                }
                else{
                    Toast.makeText(home.this, "login failed", Toast.LENGTH_SHORT).show();
                    counter--;
                    tvInfo.setText("No of attempts remaining:" + counter);


                    if(counter==0){
                        btn1.setEnabled(false);
                    }
                }
            }
        });
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
