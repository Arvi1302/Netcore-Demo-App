package com.example.myintegrate;

import android.content.Context;

import com.netcore.android.Smartech;

import java.lang.ref.WeakReference;
import java.util.HashMap;

import io.hansel.ujmtracker.HanselInternalEventsListener;
import io.hansel.ujmtracker.HanselTracker;

public class HIEL implements HanselInternalEventsListener {

//    HanselInternalEventsListener hanselInternalEventsListener = new HanselInternalEventsListener() {
//        @Override
//        public void onEvent(String s, HashMap hashMap) {
//            //HanselTracker.logEvent(s, "CSM", hashMap);
//            Smartech.getInstance(new WeakReference<>(null)).trackEvent(s,hashMap);
//        }
//    };
    @Override
    public void onEvent(String s, HashMap hashMap) {
        //HanselTracker.logEvent(s,"CMS",hashMap);
        Smartech.getInstance(new WeakReference<>(null)).trackEvent(s,hashMap);
    }
}
