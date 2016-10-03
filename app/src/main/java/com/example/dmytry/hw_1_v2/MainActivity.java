package com.example.dmytry.hw_1_v2;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(R.string.HelloWorld);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView textView = (TextView) findViewById(R.id.textView);
        if (data == null) return;
        String s = data.getStringExtra("str");
        textView.setText(s);
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void goToSecond(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivityForResult(intent, 1);
    }

    public void createNotification(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

        Notification notif = new Notification.Builder(this)
                .setContentText("Notification")
                .setSmallIcon(R.drawable.rocket)
                .setContentIntent(pIntent)
                .build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notif.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(3, notif);
        finish();
    }
}
