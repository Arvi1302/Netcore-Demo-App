package com.example.myintegrate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;

import com.netcore.android.Smartech;
import com.netcore.android.smartechpush.SmartPush;
import com.netcore.android.smartechpush.notification.channel.SMTNotificationChannel;
import com.netcore.android.smartechpush.pnpermission.SMTNotificationPermissionCallback;
import com.netcore.android.smartechpush.pnpermission.SMTPNPermissionConstants;

import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.HashMap;

import io.hansel.actions.configs.HanselConfigs;
import io.hansel.hanselsdk.Hansel;
import io.hansel.ujmtracker.HanselTracker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Hansel.pairTestDevice(getIntent().getDataString());
        //Use the deep config you created on the dashboard
        String featureName = HanselConfigs.getString("Text","hi");
        if(featureName.equals("Text")){
            setContentView(R.layout.activity_main1);
        }
        //Object[] arrayn = new Object[6];
//        arrayn[0]=1;
//        arrayn[1]=21;
//        arrayn[2]=31;

//        HashMap<String, Object> payloads1 = new HashMap<>();
//        payloads1.put("Product name", "Beans");
//        payloads1.put("prid", "Ivw2zF6kh2WcSUJIK3nbP");
//        payloads1.put("sku", "Ivw2zF6kh2WcSUJIK3nbP");
//        payloads1.put("category","PRODUCTS");
//        payloads1.put("price", 79);
//        payloads1.put("prqt", 11);

//        "payload":{"amount":174.9,"delivery timeslot":"2023-06-13 00:00:00","product array":[{"prqt":1,"Product name":"Beans Chopped","price":79,"prid":"Ivw2zF6kh2WcSUJIK3nbP","sku":"Ivw2zF6kh2WcSUJIK3nbP","category":"PRODUCTS"},{"prqt":1,"Product name":"Beetroot Chopped","price":79,"prid":"0l4fC2_0IjsXyGO8OFM7u","sku":"0l4fC2_0IjsXyGO8OFM7u","category":"PRODUCTS"}],
//            "items nos":2,"grand total":158,"discount":0,"tax":7.9,"delivery partner fee":9},
//        arrayn = payloads1.entrySet().toArray();
//
//        HashMap<String, Object> payloads = new HashMap<>();
//        payloads.put("Amount", 174.9);
//        payloads.put("delivery timeslot", "2023-06-13 00:00:00");
//        payloads.put("items nos", 2);
//        payloads.put("grand total", 79);
//        payloads.put("discount",0);
//        payloads.put("tax",7.9);
//        payloads.put("delivery partner fee",9);
//        payloads.put("product array", arrayn.);
//        Smartech.getInstance(new WeakReference<>(getApplicationContext())).trackEvent("Add To Cart | AI Test", payloads);

        //Smartech.getInstance(new WeakReference<>(getApplicationContext())).trackEvent("Add To Cart | CSM Test", payloads);
        //Smartech.getInstance(new WeakReference<>(getApplicationContext())).trackEvent("cook", payloads);
//        Smartech.getInstance(new WeakReference<>(getApplicationContext())).trackEvent("Add To Cart | Management Test", payloads);
//        Smartech.getInstance(new WeakReference<>(getApplicationContext())).trackEvent("Add To Cart | Sales Test", payloads);

        HashMap<String, Object> payload = new HashMap<>();
        payload.put("TAPNAME", "TAP_Android");
//        payload.put("LAST_NAME", "Native");
//        payload.put("EMAIL_ID", "android-native@gmail.com");
//        payload.put("MOBILE","9999999999");
        Smartech.getInstance(new WeakReference<>(getApplicationContext())).updateUserProfile(payload);
//        new DeeplinkReceiver().onReceive(this, getIntent());


//        SmartPush.getInstance(new WeakReference<>(getApplicationContext())).createNotificationChannelGroup("1234","Integrate");
//        SMTNotificationChannel.Builder smtBuilder = new SMTNotificationChannel.Builder("4321","Myinte", NotificationManager.IMPORTANCE_MAX);
//        smtBuilder.setChannelDescription("CEE Integration is done");
//        smtBuilder.setChannelGroupId("1234");
//        SMTNotificationChannel smtNotificationChannel = smtBuilder.build();
//        SmartPush.getInstance(new WeakReference<>(getApplicationContext())).createNotificationChannel(smtNotificationChannel);

        //SmartPush.getInstance(new WeakReference<>(getApplicationContext())).updateNotificationPermission(SMTPNPermissionConstants.SMT_PN_PERMISSION_GRANTED);
//        SMTNotificationPermissionCallback callback = null;
//        SmartPush.getInstance(new WeakReference<>(getApplicationContext())).requestNotificationPermission(callback);
//
//        callback = new SMTNotificationPermissionCallback() {
//            @Override
//            public void notificationPermissionStatus(int status) {
//                if (status == SMTPNPermissionConstants.SMT_PN_PERMISSION_GRANTED) {
//                    SmartPush.getInstance(new WeakReference<>(getApplicationContext())).updateNotificationPermission(SMTPNPermissionConstants.SMT_PN_PERMISSION_GRANTED);
//                } else {
//                    SmartPush.getInstance(new WeakReference<>(getApplicationContext())).updateNotificationPermission(SMTPNPermissionConstants.SMT_PN_PERMISSION_DENIED);
//
//                }
//            }
//        };

    }
}