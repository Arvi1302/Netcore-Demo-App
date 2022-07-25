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

    }
}
