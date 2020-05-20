package com.example.a71intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnSinc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSinc = findViewById(R.id.btnSinc);
        final int hourOfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        btnSinc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SYNC);
                if (6 <= hourOfDay && hourOfDay <= 14) {
                    //Toast.makeText(this, "Утро", Toast.LENGTH_SHORT).show();
                    intent.setData(Uri.parse("http://morning"));
                } else if (14<=hourOfDay && hourOfDay<=15) {
                    //Toast.makeText(this, "День", Toast.LENGTH_SHORT).show();
                    intent.setData(Uri.parse("http://afternoon"));
                } else if(15<=hourOfDay && hourOfDay<=18) {
                    //Toast.makeText(this, "Вечер", Toast.LENGTH_SHORT).show();
                    intent.setData(Uri.parse("http://evening"));
                    startActivity(intent);
                }
            }
        });

    }
}
