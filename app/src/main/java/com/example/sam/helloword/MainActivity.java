package com.example.sam.helloword;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

public class MainActivity extends BaseActivity {

    private final int SPLASH_DISPLAY_LENGHT=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                MainActivity.this.startActivity(intent);
                MainActivity.this.finish();
            }
        },SPLASH_DISPLAY_LENGHT);
    }
}
