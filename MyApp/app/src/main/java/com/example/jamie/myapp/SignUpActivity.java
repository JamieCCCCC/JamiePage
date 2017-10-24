package com.example.jamie.myapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.app.AlertDialog;

public class SignUpActivity extends AppCompatActivity {
    private ImageView mImage = null;
    private Button createA = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        createA = (Button)findViewById(R.id.button1);
        createA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(i);
            }
        });
        mImage = (ImageView)findViewById(R.id.personal_icon);
        mImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showChoosePicDialog();
            }
        });
    }
    protected void showChoosePicDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Icon Setting");
        String[] items = {"Take Photo", "Choose from Album"};
    }
}
