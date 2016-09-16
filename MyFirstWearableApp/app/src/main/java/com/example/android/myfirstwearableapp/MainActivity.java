package com.example.android.myfirstwearableapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);

        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
            }
        });
    }

    public void changeText(View view){
        Log.i("hello", "world");
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText("I've been clicked!");

        //create a timer
        Timer timer = new Timer();
        //create a new timer task
        myTask testFunc = new myTask();

        //schedule timer to perform a task after 10 seconds
        timer.schedule(testFunc, 10000);

    }

    class myTask extends TimerTask{
        public void run(){
            //prints to console
            Log.i("it's been", "10 seconds");
        }
    }
}
