package com.pompeii.rp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.byreytiz.game.CrashHandler;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        Thread.setDefaultUncaughtExceptionHandler(new CrashHandler());
        
        setContentView(R.layout.activity_main);
    }
}
