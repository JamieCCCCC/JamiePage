package com.example.jamie.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RunActivity extends AppCompatActivity {
    private Button finish = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);
        finish = (Button)findViewById(R.id.finish);
        finish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(RunActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
