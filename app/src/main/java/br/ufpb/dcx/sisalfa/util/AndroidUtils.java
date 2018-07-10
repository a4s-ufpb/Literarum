package br.ufpb.dcx.sisalfa.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.speech.tts.TextToSpeech;
import android.util.Base64;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.net.URL;


public class AndroidUtils {

    public static final String USERS_BASE_URL = "https://app.sisalfa.dcx.ufpb.br/v1/api/users/";
    public static final String CONTEXTS_BASE_URL = "https://app.sisalfa.dcx.ufpb.br/v1/api/contexts/";
    public static final String CHALLENGES_BASE_URL = "https://app.sisalfa.dcx.ufpb.br/v1/api/challenges/";

    public static void speakOut(String text, int result, Context ctx, TextToSpeech tts){
        if (result == TextToSpeech.LANG_MISSING_DATA ||result == TextToSpeech.LANG_NOT_SUPPORTED)
            Toast.makeText(ctx, "Feature not supported " + "in your device.", Toast.LENGTH_SHORT).show();
        else
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);

    }

    public static byte[] extractBytes (String imagePath) throws IOException {
        byte[] array = Files.readAllBytes(new File(imagePath).toPath());
        return array;

    }

    public static String BitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        byte[] byteArray = stream.toByteArray();
        String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);
        return encoded;
    }

    // convert from byte array to bitmap
    public static Bitmap convertImageLinkToBitmap(String link) throws IOException {
        URL url = new URL(link);
        Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        return bmp;
    }

    public static String drawableToBase64(Resources r, int id){
        Bitmap bitmapOrg = BitmapFactory.decodeResource(r,  id);
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        bitmapOrg.compress(Bitmap.CompressFormat.JPEG, 100, bao);
        byte [] ba = bao.toByteArray();
        return Base64.encodeToString(ba,Base64.DEFAULT);
    }






}
