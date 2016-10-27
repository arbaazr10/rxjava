package com.example.awtech.dualsim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
    TextView textView;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.textView);
        textView2=(TextView)findViewById(R.id.textView2);

        SubscriptionManager manager = SubscriptionManager.from(this);
        SubscriptionInfo subscriptionInfo0 = manager.getActiveSubscriptionInfoForSimSlotIndex(0);
        SubscriptionInfo subscriptionInfo1 = manager.getActiveSubscriptionInfoForSimSlotIndex(1);

        String IccId0=subscriptionInfo0.getIccId();

        if (subscriptionInfo1!=null) {
            String IccId1 = subscriptionInfo1.getIccId();
            textView2.setText(IccId1+"");
        }
        else{
            Toast.makeText(MainActivity.this, "No Sim 2", Toast.LENGTH_SHORT).show();
            textView2.setText("No Sim 2");
        }

        textView.setText(IccId0+"");

    }
}
