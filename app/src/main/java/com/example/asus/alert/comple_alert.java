package com.example.asus.alert;

import android.app.ActionBar;
import android.os.Build;
import android.support.annotation.AnimatorRes;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toolbar;

import org.w3c.dom.Text;

public class comple_alert extends AppCompatActivity {

    ImageView alert;
    TextView text,text1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comple_alert);
        alert = findViewById(R.id.alertimage_completepage);
        text = findViewById(R.id.text_alert_success);
        text1 = findViewById(R.id.text_wait_update);
        //splash screen
        Animation splash = AnimationUtils.loadAnimation(this,R.anim.splashscreen);
        alert.startAnimation(splash);
        text.startAnimation(splash);
        text1.startAnimation(splash);

        //back alert_page
        final Intent i = new Intent(this,report.class);
        Thread timer = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();


        //intent receive input
//        Bundle bundle = getIntent().getExtras();
//        String text_topic = bundle.getString("text_topic");
//        String text_detail = bundle.getString("text_detail");
//        String group_type = bundle.getString("text_group");
//        String group_send = bundle.getString("text_send");
//        String text_location = bundle.getString("text_location");
//        TextView textview_location = findViewById(R.id.show_location);
//        TextView textview_topic = findViewById(R.id.show_topic);
//        TextView textview_detail = findViewById(R.id.show_detail);
//        TextView text_group_type = findViewById(R.id.choose_type);
//        TextView text_group_send = findViewById(R.id.choose_send);
//        textview_topic.setText("Text Topic = " + text_topic);
//        textview_detail.setText("Text Detail = " + text_detail);
//        text_group_type.setText("Text Type = " + group_type);
//        text_group_send.setText("Text Type = " + group_send);
//        textview_location.setText("Text Location = " + text_location);


    }
}