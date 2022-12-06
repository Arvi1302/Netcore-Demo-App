package com.example.myintegrate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.netcore.android.Smartech;
import com.netcore.android.smartechpush.SmartPush;
import com.netcore.android.smartechpush.notification.channel.SMTNotificationChannel;

import java.lang.ref.WeakReference;
import java.util.HashMap;

import io.hansel.hanselsdk.Hansel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Hansel.pairTestDevice(getIntent().getDataString());
        HashMap<String, Object> payloads = new HashMap<>();
        payloads.put("name", "Nexus 5");
        payloads.put("prid", 2);
        payloads.put("price", 15000.00);
        payloads.put("prqt", 1);

        Smartech.getInstance(new WeakReference<>(getApplicationContext())).trackEvent("Add To Cart", payloads);

        new DeeplinkReceiver().onReceive(this, getIntent());


//        SmartPush.getInstance(new WeakReference<>(getApplicationContext())).createNotificationChannelGroup("1234","Integrate");
//        SMTNotificationChannel.Builder smtBuilder = new SMTNotificationChannel.Builder("4321","Myinte", NotificationManager.IMPORTANCE_MAX);
//        smtBuilder.setChannelDescription("CEE Integration is done");
//        smtBuilder.setChannelGroupId("1234");
//        SMTNotificationChannel smtNotificationChannel = smtBuilder.build();
//        SmartPush.getInstance(new WeakReference<>(getApplicationContext())).createNotificationChannel(smtNotificationChannel);
    }
}