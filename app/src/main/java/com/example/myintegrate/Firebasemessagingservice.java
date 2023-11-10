package com.example.myintegrate;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.netcore.android.smartechpush.SmartPush;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;

public class Firebasemessagingservice extends FirebaseMessagingService {

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        SmartPush.getInstance(new WeakReference<>(this)).setDevicePushToken(token);
    }


    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        boolean pushFromSmartPush = false;
        try {
            pushFromSmartPush = SmartPush.getInstance(new WeakReference<>(getApplicationContext())).isNotificationFromSmartech(new JSONObject(remoteMessage.getData().toString()));
        } catch (JSONException e) {
            Log.e("App", "Is Notification from Smartech failed.");
        }
        if(pushFromSmartPush){
            SmartPush.getInstance(new WeakReference<>(getApplicationContext())).handlePushNotification(remoteMessage.getData().toString());
        } else {
            // Notification received from other sources
        }
    }
}
