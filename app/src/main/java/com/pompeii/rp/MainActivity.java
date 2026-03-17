package com.pompeii.rp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.byreytiz.game.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        try {
            setContentView(R.layout.activity_main);
            Toast.makeText(this, "Активити загружена", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            String error = "Ошибка: " + e.getMessage();
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
