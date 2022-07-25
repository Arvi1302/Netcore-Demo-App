package com.example.myintegrate;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.netcore.android.smartechpush.SmartPush;

import java.lang.ref.WeakReference;

public class FCMService extends FirebaseMessagingService {

        @Override
        public void onNewToken(@NonNull String token) {
                super.onNewToken(token);
                SmartPush.getInstance(new WeakReference<Context>(this)).setDevicePushToken(token);

                //<Your code>
        }

        @Override
        public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
                super.onMessageReceived(remoteMessage);
                boolean pushHandledBySmartech = SmartPush.getInstance(new WeakReference<>(getApplicationContext())).handlePushNotification(remoteMessage.getData().toString());
//                if (!pushHandledBySmartech){
//
//                // Handle notification from other sources.
//
//                }
        }
}

