package com.example.myintegrate;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.fonts.FontFamily;
import android.os.Build;
import android.util.Log;
import android.view.View;

import androidx.core.content.res.ResourcesCompat;

import com.netcore.android.Smartech;
import com.netcore.android.logger.SMTDebugLevel;
import com.netcore.android.smartechpush.SmartPush;
import com.netcore.android.smartechpush.notification.SMTNotificationOptions;
import com.netcore.android.smartechpush.pnpermission.SMTNotificationPermissionCallback;
import com.netcore.android.smartechpush.pnpermission.SMTPNPermissionConstants;
import com.netcore.android.smartechpush.xiaomi.SmartPushXiaomi;
import com.xiaomi.channel.commonutils.android.Region;
import com.xiaomi.mipush.sdk.MiPushClient;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import io.hansel.actions.configs.HanselConfigs;
import io.hansel.core.logger.HSLLogLevel;
import io.hansel.hanselsdk.Hansel;
import io.hansel.ujmtracker.HanselInternalEventsListener;
import io.hansel.ujmtracker.HanselTracker;

public class ApplicationActivity extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Smartech smartech = Smartech.getInstance(new WeakReference<>(getApplicationContext()));
        //smartech.setDebugLevel(9);
        smartech.initializeSdk(this);
        smartech.trackAppInstallUpdateBySmartech();
        smartech.login("android-native@gmail.com");
        //Smartech.getInstance(new WeakReference<>(getApplicationContext())).setDebugLevel(9);

//        HashMap<String, Object> payload = new HashMap<>();
//        payload.put("NAME", "Android");
//        payload.put("LAST_NAME", "Native");
//        //payload.put("EMAIL_ID", "android-native@gmail.com");
//        payload.put("MOBILE","9999999999");
//        payload.put("prod",arrayn);
//        Smartech.getInstance(new WeakReference<>(this)).trackEvent("cook",payload);
//        Smartech.getInstance(new WeakReference<>(getApplicationContext())).updateUserProfile(payload);
        //SmartPushXiaomi.getInstance(new WeakReference<>(this)).register("5822194170927", "2882303761521941927",Region.India);
        SmartPushXiaomi.getInstance(new WeakReference<>(this)).register("2882303761521941927", "5822194170927", Region.India);
        //MiPushClient.getRegId(this);
//        Log.d("MiPush",MiPushClient.getRegId(this));
        //SmartPushXiaomi.getInstance(new WeakReference<>(this)).getXiaomiPushToken();
        //Log.d("MiPush", SmartPushXiaomi.getInstance(new WeakReference<>(this)).getXiaomiPushToken());
        //smartech.getInAppCustomHTMLListener();
        //smartech.setUserIdentity("android-native@gmail.com");
        Hansel.getUser().setUserId("android-native@gmail.com");

//        Hansel.enableDebugLogs();
        smartech.setDebugLevel(9);
        HSLLogLevel.all.setEnabled(true);
        HSLLogLevel.mid.setEnabled(true);
        HSLLogLevel.debug.setEnabled(true);
        //Hansel.setAppFont(String.valueOf(R.font.almendra_sc));
        Typeface typeface = ResourcesCompat.getFont(getApplicationContext(),R.font.plusjakartasansz_medium);
        Hansel.setTypeface(typeface);
        //Hansel.enableDebugLogs();

//        //Use the deep config you created on the dashboard
//        String featureName = HanselConfigs.getString("config_name_here","Default string");


        try {
            SmartPush smartPush = SmartPush.getInstance(new WeakReference<>(getApplicationContext()));
            smartPush.fetchAlreadyGeneratedTokenFromFCM();
        } catch (Exception e) {
            Log.e("App", "Fetching FCM token failed.");
        }

        DeeplinkReceiver deeplinkReceiver = new DeeplinkReceiver();
        IntentFilter filter = new IntentFilter("com.smartech.EVENT_PN_INBOX_CLICK");
        getApplicationContext().registerReceiver(deeplinkReceiver, filter);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            this.registerReceiver(deeplinkReceiver, filter, this.RECEIVER_EXPORTED);
//        }

        HIEL hiel = new HIEL();
        HanselTracker.registerListener(hiel);

//        HanselTracker.registerListener(hiel.hanselInternalEventsListener);

//        HanselInternalEventsListener hanselInternalEventsListener = new HIEL();
//        HanselTracker.registerListener(hanselInternalEventsListener);

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
