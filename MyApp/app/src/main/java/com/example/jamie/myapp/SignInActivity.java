package com.example.jamie.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class SignInActivity extends AppCompatActivity{
    private EditText username = null;
    private EditText password = null;
    private Button signin = null;
    private Button signup = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        username = (EditText) findViewById(R.id.editText1);
        password = (EditText) findViewById(R.id.editText2);
        signin = (Button) findViewById(R.id.button1);
        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        signup = (Button) findViewById(R.id.button2);
        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });
    }
    public void signin(View view) {
        if (username.getText().toString().equals("username") &&
                password.getText().toString().equals("password")) {
            Toast.makeText(getApplicationContext(), "Sign in successfully.",
                    Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Wrong credentials.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
