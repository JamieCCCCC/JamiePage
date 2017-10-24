package com.example.jamie.myapp;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MissionActivity extends ListActivity {
    //定义四个数组，分别做显示用
    private static String[] mission = new String[]
            { "Easy","Normal","Hard", ""};
    private static String[] condition = new String[]
            { "level below 15","level between 15 and 25","level above 25", ""};
    private static int[] icons = new int[]
            { R.drawable.lock,R.drawable.lock,R.drawable.lock, R.drawable.back};

    String inflater = Context.LAYOUT_INFLATER_SERVICE;
    LayoutInflater layoutInflater;
    private RatingAdapter raAdapter;

    //自定义一个Adapter继承BaseAdapter，要重写getCount(),getItem(),getItemId(),getView()四种方法
    private class RatingAdapter extends BaseAdapter
    {
        private Context context;

        public RatingAdapter(Context context)
        {
            this.context = context;
            layoutInflater = (LayoutInflater) context
                    .getSystemService(inflater);
        }

        public int getCount()
        {
            return mission.length;
        }

        public Object getItem(int position)
        {
            return mission[position];
        }

        public long getItemId(int position)
        {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            //对ListView布局
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(
                    R.layout.activity_mission, null);
            if(position != 3){
                ImageView icon = (ImageView) linearLayout.findViewById(R.id.icon);
                TextView missions = ((TextView) linearLayout.findViewById(R.id.missions));
                TextView conditions = (TextView) linearLayout.findViewById(R.id.conditions);
                icon.setImageResource(icons[position]);
                missions.setText(mission[position]);
                conditions.setText(condition[position]);
            }
            else{
                ImageView icon = (ImageView) linearLayout.findViewById(R.id.icon);
                icon.setImageResource(icons[position]);
                icon.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(MissionActivity.this, MainActivity.class);
                        startActivity(i);
                    }
                });
            }
            if(position == 0){
                linearLayout.setBackgroundColor(Color.parseColor("#A2CD5A"));
            }
            if(position == 1){
                linearLayout.setBackgroundColor(Color.parseColor("#EEC900"));
            }
            if(position == 2){
                linearLayout.setBackgroundColor(Color.parseColor("#EE3B3B"));
            }
            return linearLayout;
        }
    }

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        List<View> viewList = new ArrayList<View>();
        viewList.add(getLayoutInflater().inflate(R.layout.activity_main, null));
        raAdapter = new RatingAdapter(this);
        setListAdapter(raAdapter);
    }
}