package com.example.stevtymez.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class sign extends AppCompatActivity {
    private EditText username, password, email;
    private Button reg;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        setupUIViews();
        firebaseAuth = FirebaseAuth.getInstance();

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    //upload data to database
                String Email = email.getText().toString().trim();
                    String Password = password.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(sign.this, "Registration sucessful", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(sign.this, home.class));
                            } else {
                                Toast.makeText(sign.this,"Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });

}
private void setupUIViews(){
            username = (EditText)findViewById(R.id.username);
            password =(EditText)findViewById(R.id.password);
            email= (EditText)findViewById(R.id.email);
            reg = (Button)findViewById(R.id.reg);
}

    private boolean validate() {
        Boolean result= false;
        String name =username.getText().toString();
        String pass =password.getText().toString();
        String emai =email.getText().toString();

        if(name.isEmpty() && pass.isEmpty() && emai.isEmpty()){
            Toast.makeText(this, "please enter all the details", Toast.LENGTH_SHORT).show();
        }else {
            result = true;
        }
        return result;
    }
    }
