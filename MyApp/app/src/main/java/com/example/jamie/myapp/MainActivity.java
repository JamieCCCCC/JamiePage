package com.example.jamie.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private ProgressBarView progressBarView = null;
    private Button mission = null;
    private Button models = null;
    private Button run = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressBarView = new ProgressBarView(this);
        this.setContentView(R.layout.activity_main);
        mission = (Button)findViewById(R.id.button2);
        mission.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this, MissionActivity.class);
                startActivity(i);
            }
        });
        models = (Button)findViewById(R.id.button3);
        models.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent j = new Intent(MainActivity.this, FigureActivity.class);
                startActivity(j);
            }
        });
        run = (Button)findViewById(R.id.button1);
        run.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent v = new Intent(MainActivity.this, RunActivity.class);
                startActivity(v);
            }
        });
    }
}
