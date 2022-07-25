package com.example.myintegrate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.netcore.android.SMTBundleKeys;

public class DeeplinkReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundleExtra = intent.getExtras();
        if (bundleExtra != null) {

            if (bundleExtra.containsKey(SMTBundleKeys.SMT_BUNDLE_KEY_CLICK_DEEPLINK)) {
                String deepLinkvalue = bundleExtra.getString(SMTBundleKeys.SMT_BUNDLE_KEY_CLICK_DEEPLINK);
                Log.v("Smartech_broadcast","deeplink:"+deepLinkvalue);
//                if (deepLinkvalue.contains("https://www.google.com")){
//                    openProfile(context);
//                }
            } else {
                Log.v("Smartech_broadcast", "does not have deeplink path.");
            }

            if (bundleExtra.containsKey(SMTBundleKeys.SMT_BUNDLE_KEY_CLICK_CUSTOM_PAYLOAD)) {
                String customPayloadvalue = bundleExtra.getString(SMTBundleKeys.SMT_BUNDLE_KEY_CLICK_CUSTOM_PAYLOAD);
                Log.v("Smartech_broadcast","custompayload:"+customPayloadvalue);
            } else {
                Log.v("Smartech_broadcast", "does not have custom payload.");
            }
        }
    }

//    private void openProfile(Context context){
//        Intent intent = new Intent(context,MainActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent);
//    }
}
