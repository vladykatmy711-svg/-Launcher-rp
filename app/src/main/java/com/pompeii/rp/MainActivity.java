package com.pompeii.rp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = findViewById(R.id.start_button);
        Button settingsButton = findViewById(R.id.settings_button);

        if (startButton != null) {
            startButton.setOnClickListener(v -> 
                Toast.makeText(this, "Pompeii RP запускается...", Toast.LENGTH_SHORT).show()
            );
        }

        if (settingsButton != null) {
            settingsButton.setOnClickListener(v -> 
                Toast.makeText(this, "Настройки пока в разработке", Toast.LENGTH_SHORT).show()
            );
        }
    }
}
