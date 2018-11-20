package com.example.asus.alert;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class report extends AppCompatActivity {
    EditText text_topic, text_detail, text_location;
    RadioButton acc_eme, traffic, weather, secret_eme, identify, anonymous;
    ImageButton image_send;
    //RadioGroup group_type, group_send;
    DatabaseReference db, childRef, listLocation, listDetail,listType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        //create option button
        text_topic = findViewById(R.id.edittext_topic);
        text_detail = findViewById(R.id.edittext_detail);
        acc_eme = findViewById(R.id.ra_butt_acc_eme);
        traffic = findViewById(R.id.ra_butt_traffic);
        weather = findViewById(R.id.ra_butt_weahter);
        secret_eme = findViewById(R.id.ra_butt_secret_eme);
        identify = findViewById(R.id.ra_butt_identify);
        anonymous = findViewById(R.id.ra_butt_anonymous);
        image_send = findViewById(R.id.image_send);
        text_location = findViewById(R.id.edittext_location);

        //database
        db = FirebaseDatabase.getInstance().getReference();

        //image click to next page
        image_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //check data
                String get_topic = text_topic.getText().toString();
                String get_detail = text_detail.getText().toString();
                String get_location = text_location.getText().toString();

                //input text condition
                if (TextUtils.isEmpty(get_topic)) {
                    Toast.makeText(getApplicationContext(), "Please fill the topic!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(get_detail)) {
                    Toast.makeText(getApplicationContext(), "Please fill the Detail!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(get_location)) {
                    Toast.makeText(getApplicationContext(), "Please fill the location!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                //ref database topic
                childRef = db.child(get_topic);

                //choose button group_type
                if(acc_eme.isChecked()){
                    listType = childRef.child("Type of Alert");
                    listType.setValue("Accident / Emergency");
                }
                if (traffic.isChecked()){
                    listType = childRef.child("Type of Alert");
                    listType.setValue("Traffic");
                }
                if (weather.isChecked()){
                    listType = childRef.child("Type of Alert");
                    listType.setValue("Weather");
                }
                if (secret_eme.isChecked()){
                    listType = childRef.child("Type of Alert");
                    listType.setValue("Secret Emergency");
                }

                //choose button group_send
                if(identify.isChecked()){
                    listType = childRef.child("Send_type");
                    listType.setValue("Identify your username");
                }
                if (anonymous.isChecked()){
                    listType = childRef.child("Send_type");
                    listType.setValue("Anonymous");
                }

                //send data to database
                listDetail = childRef.child("Detail");
                listDetail.setValue(get_detail);
                listLocation = childRef.child("Location");
                listLocation.setValue(get_location);



                //click to next page
                Intent intent = new Intent(report.this, comple_alert.class);
                startActivity(intent);

               /* //send text on group_type
                group_type = findViewById(R.id.grouptype);
                int checkedRadioButtonId = group_type.getCheckedRadioButtonId();
                RadioButton checkRadioButton = (RadioButton) findViewById(checkedRadioButtonId);
                String check_group_type = checkRadioButton.getText().toString();

                //send text on group_send
                group_send = findViewById(R.id.groupsend);
                int checkedRadioButtonId1 = group_send.getCheckedRadioButtonId();
                RadioButton checkRadioButton1 = (RadioButton) findViewById(checkedRadioButtonId1);
                String check_group_send = checkRadioButton1.getText().toString();

                //send text to next page
                Intent intent = new Intent(report.this, comple_alert.class);
                intent.putExtra("text_group", check_group_type);
                intent.putExtra("text_send", check_group_send);
                intent.putExtra("text_topic", text_topic.getText().toString());
                intent.putExtra("text_detail", text_detail.getText().toString());
                intent.putExtra("text_location", text_location.getText().toString());
                startActivity(intent);
*/

            }
        });
    }
}
