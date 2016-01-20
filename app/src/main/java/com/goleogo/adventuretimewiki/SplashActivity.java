package com.goleogo.adventuretimewiki;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

/**
 * Created by leosss on 20/01/16.
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3));
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
