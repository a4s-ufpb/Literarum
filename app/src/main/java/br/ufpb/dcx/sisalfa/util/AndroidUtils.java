package br.ufpb.dcx.sisalfa.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.util.Base64;
import android.util.Size;
import android.widget.Toast;

import com.example.rynzler.literarum.BuildConfig;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class AndroidUtils {

    public static final String BASE_URL = "https://app.sisalfa.dcx.ufpb.br/v1/api/";


    public static byte[] drawableToByteArray(Context ctx, int id){
        Bitmap bitmap = BitmapFactory.decodeResource(ctx.getResources(), id);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 70, stream);
        byte[] bitMapData = stream.toByteArray();
        return bitMapData;

    }







    // convert from byte array to bitmap
    public static byte[] convertImageLinkToByteArray(String link) throws IOException {
        URL url = new URL(link);
        Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        bmp.recycle();
        stream.close();
        return byteArray;
    }



    public static Bitmap ByteArrayToBitmap(byte[] byteArray)
    {
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(byteArray);
        Bitmap bitmap = BitmapFactory.decodeStream(arrayInputStream);

        bitmap = Bitmap.createScaledBitmap(bitmap, 200, 200, false);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 70, outStream);
        return bitmap;
    }



}
