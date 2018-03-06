package com.auribises.activitylifecycle;

import android.content.Intent;
import android.net.Uri;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class VoiceDemoActivity extends AppCompatActivity implements View.OnClickListener, RecognitionListener{

    TextView txtVoice;
    Button btnSpeak;

    SpeechRecognizer speechRecognizer;

    void initViews(){
        txtVoice = findViewById(R.id.textViewVoice);
        btnSpeak = findViewById(R.id.buttonVoice);

        btnSpeak.setOnClickListener(this);

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_demo);
        initViews();
    }

    @Override
    public void onClick(View view) {
        speechRecognizer.setRecognitionListener(this);
        speechRecognizer.startListening(RecognizerIntent.getVoiceDetailsIntent(this));
    }

    @Override
    public void onReadyForSpeech(Bundle bundle) {

    }

    @Override
    public void onBeginningOfSpeech() {

    }

    @Override
    public void onRmsChanged(float v) {

    }

    @Override
    public void onBufferReceived(byte[] bytes) {

    }

    @Override
    public void onEndOfSpeech() {

    }

    @Override
    public void onError(int i) {

    }

    @Override
    public void onResults(Bundle bundle) {

        ArrayList<String> list = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        if(list!=null && list.size()>0){
            String sentence = list.get(0);
            txtVoice.setText(sentence);

            if(sentence.contains("call") && sentence.contains("mom")){
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+919915571177"));
                startActivity(intent);
            }
        }

    }

    @Override
    public void onPartialResults(Bundle bundle) {

    }

    @Override
    public void onEvent(int i, Bundle bundle) {

    }
}
