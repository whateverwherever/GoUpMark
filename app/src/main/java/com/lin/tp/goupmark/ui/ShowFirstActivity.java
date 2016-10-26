package com.lin.tp.goupmark.ui;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lin.tp.goupmark.R;

public class ShowFirstActivity extends AppCompatActivity {
    ImageView img_ads=null;
    TextView text_time=null;
    private int time=5;
    private Handler myHandler;
    CountThread countThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_showfirst);
        img_ads = (ImageView) findViewById(R.id.showAds);
        text_time = (TextView) findViewById(R.id.textView);

        myHandler = new Handler();
        countThread = new CountThread();
        countThread.start();
    }
    private class CountThread extends Thread{
        public void run()
        {
            while(time!=0){
                myHandler.post(runnableUi);
                if (time==3)
                {
                    myHandler.post(runaddImage);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            Intent intent=new Intent(ShowFirstActivity.this,LoginActivity.class);
            startActivity(intent);
            ShowFirstActivity.this.finish();
        }
    }
    Runnable runnableUi = new Runnable(){
        @Override
        public void run(){
            time--;
            text_time.setText("倒计时"+time);

        }
    };
    Runnable runaddImage=new Runnable() {
        @Override
        public void run() {
            img_ads.setImageResource(R.mipmap.showfirst);
        }
    };

}
