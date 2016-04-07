package com.example.abrain.ttstrial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.SensorManager;

import android.speech.tts.TextToSpeech;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;



public class HomeActivity extends AppCompatActivity {

    TextToSpeech t1;
    Button b1;
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        b1 = (Button) findViewById(R.id.button);
        et1 = (EditText) findViewById(R.id.textField);

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR){
                    t1.setLanguage(Locale.UK);
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String toSpeak = et1.getText().toString();
                t1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null,null);
            }
        });
    }
}
