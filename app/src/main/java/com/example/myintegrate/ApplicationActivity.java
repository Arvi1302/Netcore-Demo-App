package com.example.myintegrate;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import com.netcore.android.Smartech;
import com.netcore.android.logger.SMTDebugLevel;
import com.netcore.android.smartechpush.SmartPush;
import com.netcore.android.smartechpush.notification.SMTNotificationOptions;

import java.lang.ref.WeakReference;

public class ApplicationActivity extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Smartech smartech = Smartech.getInstance(new WeakReference<>(getApplicationContext()));
        smartech.initializeSdk(this);
        smartech.trackAppInstallUpdateBySmartech();
        smartech.setDebugLevel(SMTDebugLevel.Level.VERBOSE);

    }

}
