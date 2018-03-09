package com.example.chap03_07_smsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.util.Date;

public class MyReceiver extends BroadcastReceiver {
    public static final  String TAG = "@@@@smsReceiver@@@";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG,"onReceive() Call" );

        Bundle bundle = intent.getExtras();
        SmsMessage[] msg = parseSmsMessage(bundle);

//        String sender = intent.getStringExtra("sender");
//        String contents = intent.getStringExtra("contents");
//        String receivedDate = intent.getStringExtra("receivedDate");

        if (msg != null && msg.length >0){

            String sender = msg[0].getOriginatingAddress();
            String contents = msg[0].getMessageBody().toString();
            Date receivedDate = new Date( msg[0].getTimestampMillis());

            sendToActivity(context, sender, contents, receivedDate);
        }


    }

    private void sendToActivity(Context context, String sender, String contents, Date receivedDate) {

        Intent intent = new Intent(context, MainActivity.class);

        intent.addFlags((Intent.FLAG_ACTIVITY_NEW_TASK|
        intent.FLAG_ACTIVITY_SINGLE_TOP|intent.FLAG_ACTIVITY_CLEAR_TOP));

        intent.putExtra("sender", sender);
        intent.putExtra("contents", contents);
        intent.putExtra("receivedDate", receivedDate);

        context.startActivity(intent);
    }

    private SmsMessage[] parseSmsMessage(Bundle bundle) {
        Object[] objs = (Object[])bundle.get("pdus");
        SmsMessage[] msg = new SmsMessage[objs.length];

        int smsCnt = objs.length;

        for (int i = 0 ; i < smsCnt; i ++){

            if (Build.VERSION.SDK_INT >= 23){
                String format = bundle.getString("format");
                msg[i] = SmsMessage.createFromPdu((byte[])objs[i], format);
            }else {
                msg[i] = SmsMessage.createFromPdu((byte[])objs[i]);
            }
        }

        return  msg;

    }
}
