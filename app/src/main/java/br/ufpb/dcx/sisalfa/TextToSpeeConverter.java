package br.ufpb.dcx.sisalfa;

import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;
import java.util.Locale;

/**
 * Created by rynzler on 30/03/18.
 */

public class TextToSpeeConverter extends Activity{

    private TextToSpeech textToSpeech;
    private int result;

    public TextToSpeeConverter(){
        this.textToSpeech = new TextToSpeech(TextToSpeeConverter.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS)
                    result = textToSpeech.setLanguage(Locale.US);
                else{
                    Toast.makeText(getApplicationContext(), "Feature not supported " + "in your device.", Toast.LENGTH_SHORT).show();

                }
            }

        });
        this.result = 0;
    }


    public void speakOut(String text){
        if (result == TextToSpeech.LANG_MISSING_DATA ||result == TextToSpeech.LANG_NOT_SUPPORTED)
            Toast.makeText(getApplicationContext(), "Feature not supported " + "in your device.", Toast.LENGTH_SHORT).show();
        else
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);


    }



}
