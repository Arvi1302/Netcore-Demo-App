package com.example.myintegrate;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.netcore.android.SMTBundleKeys;

import io.hansel.actions.configs.HanselConfigs;

public class DeeplinkReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundleExtra = intent.getExtras();
        if (bundleExtra != null) {

            if (bundleExtra.containsKey(SMTBundleKeys.SMT_BUNDLE_KEY_CLICK_DEEPLINK)) {
                String deepLinkvalue = bundleExtra.getString(SMTBundleKeys.SMT_BUNDLE_KEY_CLICK_DEEPLINK);
                if (deepLinkvalue != null && !deepLinkvalue.isEmpty()) {
                    String red = "Redirec";
                    //Use the deep config you created on the dashboard
                    String featureName = HanselConfigs.getString("Testing","Link");
                    if(red.equals(featureName)) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(deepLinkvalue));
                        browserIntent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                        //browserIntent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(browserIntent);
                    }
                }
            } else {
                Log.v("Activity", "does not have deeplink path.");
            }

            if (bundleExtra.containsKey(SMTBundleKeys.SMT_BUNDLE_KEY_CLICK_CUSTOM_PAYLOAD)) {
                String customPayloadvalue = bundleExtra.getString(SMTBundleKeys.SMT_BUNDLE_KEY_CLICK_CUSTOM_PAYLOAD);
            } else {
                Log.v("Activity", "does not have custom payload.");
            }

        }
    }
}
