package br.ufpb.dcx.sisalfa.util;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;



public class AndroidUtils {

    public static final String LITERACY_API_ENDPOINT = "endpoit";
    public static final String BASE_URL = "base_url";

    public static void speakOut(String text, int result, Context ctx, TextToSpeech tts){
        if (result == TextToSpeech.LANG_MISSING_DATA ||result == TextToSpeech.LANG_NOT_SUPPORTED)
            Toast.makeText(ctx, "Feature not supported " + "in your device.", Toast.LENGTH_SHORT).show();
        else
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);

    }



}
