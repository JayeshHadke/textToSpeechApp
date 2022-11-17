package com.example.texttovoiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textToSpeech = new TextToSpeech(getApplicationContext(), status -> {
            if (status != TextToSpeech.ERROR) {
                textToSpeech.setLanguage(Locale.ENGLISH);
            }
        });
        findViewById(R.id.button).setOnClickListener(view -> {
            textToSpeech.speak("Current Time " +
                    new SimpleDateFormat("hh:mm:ss aa").
                            format(new Date()), TextToSpeech.QUEUE_FLUSH, null);
        });
    }
}