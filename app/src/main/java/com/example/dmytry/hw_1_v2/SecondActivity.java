package com.example.dmytry.hw_1_v2;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void backToFirst(View view) {

        this.finish();
    }

    public void backTextToFirst(View view) {
        EditText editText = (EditText) findViewById(R.id.editTextUser);
        Intent intent = new Intent();
        intent.putExtra("str", editText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
