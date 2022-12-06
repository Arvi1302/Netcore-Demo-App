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

import io.hansel.core.logger.HSLLogLevel;
import io.hansel.hanselsdk.Hansel;

public class ApplicationActivity extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Smartech smartech = Smartech.getInstance(new WeakReference<>(getApplicationContext()));
        //smartech.setDebugLevel(9);
        smartech.initializeSdk(this);
        //smartech.trackAppInstallUpdateBySmartech();

//        Hansel.enableDebugLogs();
        smartech.setDebugLevel(SMTDebugLevel.Level.VERBOSE);
        HSLLogLevel.all.setEnabled(true);
        HSLLogLevel.mid.setEnabled(true);
        HSLLogLevel.debug.setEnabled(true);

        try {
            SmartPush smartPush = SmartPush.getInstance(new WeakReference<>(getApplicationContext()));
            smartPush.fetchAlreadyGeneratedTokenFromFCM();
        } catch (Exception e) {
            Log.e("App", "Fetching FCM token failed.");
        }

        DeeplinkReceiver deeplinkReceiver = new DeeplinkReceiver();
        IntentFilter filter = new IntentFilter("com.smartech.EVENT_PN_INBOX_CLICK");
        getApplicationContext().registerReceiver(deeplinkReceiver, filter);



//        SMTNotificationOptions options = new SMTNotificationOptions(getApplicationContext());
//        options.setBrandLogo("logo"); //e.g.logo is sample name for brand logo
//        options.setLargeIcon("icon_nofification");//e.g.ic_notification is sample name for large icon
//        options.setSmallIcon("ic_action_play"); //e.g.ic_action_play is sample name for icon
//        options.setSmallIconTransparent("ic_action_play"); //e.g.ic_action_play is sample name for transparent small icon
//        options.setTransparentIconBgColor("#FF0000");
//        options.setPlaceHolderIcon("ic_notification");//e.g.ic_notification is sample name for placeholder icon
//        SmartPush.getInstance(new WeakReference(getApplicationContext())).setNotificationOptions(options);



    }

}
