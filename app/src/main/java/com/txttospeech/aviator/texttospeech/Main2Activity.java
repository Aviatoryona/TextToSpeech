package com.txttospeech.aviator.texttospeech;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class Main2Activity extends AppCompatActivity {

    protected TextToSpeech textToSpeech;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
SpeakTe();
            }
        });

        editText= (EditText) findViewById(R.id.editText);
        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                    if(status !=TextToSpeech.ERROR){
        textToSpeech.setLanguage(Locale.getDefault());
                    }
            }
        });


    }


    @Override
    protected void onPause() {

        if(textToSpeech!=null){

            textToSpeech.stop();
            textToSpeech.shutdown();

        }

        super.onPause();

    }


   public void SpeakTe(){
       String tex=editText.getText().toString();
       Toast.makeText(getApplicationContext(),tex,Toast.LENGTH_LONG).show();
       textToSpeech.speak(tex,TextToSpeech.QUEUE_FLUSH,null);


   }


}
