package com.example.sunmipos;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Basit bir TextView gösterelim
        TextView tv = new TextView(this);
        tv.setText("Merhaba, Sunmi POS!");
        tv.setTextSize(24);

        setContentView(tv);
    }
}
