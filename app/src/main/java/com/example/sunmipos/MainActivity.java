[17:15, 10.09.2025] Fuat: <?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.sunmipos">

    <application
        android:allowBackup="true"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/Theme.AppCompat.Light.NoActionBar">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>
                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
        </activity>
    </application>
</manifest>
[17:16, 10.09.2025] Fuat: package com.example.sunmipos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etPlate, etProduct, etPump, etNozzle, etLiters, etUnitPrice, etVatRate, etPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPlate     = findViewById(R.id.etPlate);
        etProduct   = findViewById(R.id.etProduct);
        etPump      = findViewById(R.id.etPump);
        etNozzle    = findViewById(R.id.etNozzle);
        etLiters    = findViewById(R.id.etLiters);
        etUnitPrice = findViewById(R.id.etUnitPrice);
        etVatRate   = findViewById(R.id.etVatRate);
        etPayment   = findViewById(R.id.etPayment);
        Button btnPrint = findViewById(R.id.btnPrint);

        btnPrint.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                String plate = etPlate.getText().toString().trim();
                if (plate.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Plaka giriniz", Toast.LENGTH_SHORT).show();
                    return;
                }
                // basit toplam
                try {
                    double liters = Double.parseDouble(etLiters.getText().toString());
                    double unit   = Double.parseDouble(etUnitPrice.getText().toString());
                    double vatR   = Double.parseDouble(etVatRate.getText().toString());
                    double subtotal = liters * unit;
                    double vat      = subtotal * vatR;
                    double total    = subtotal + vat;

                    String msg = "Plaka: " + plate +
                            "\nÜrün: " + etProduct.getText().toString() +
                            "\nPompa/Tabanca: " + etPump.getText().toString() + "/" + etNozzle.getText().toString() +
                            "\nLitre: " + liters +
                            "\nBirim: " + unit +
                            "\nKDV: " + vat +
                            "\nToplam: " + total +
                            "\nÖdeme: " + etPayment.getText().toString();

                    Toast.makeText(MainActivity.this, "Fiş hazır (demo)\n" + msg, Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Sayısal alanları kontrol edin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
