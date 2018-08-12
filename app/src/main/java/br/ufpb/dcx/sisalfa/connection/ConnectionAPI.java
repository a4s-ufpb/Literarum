package br.ufpb.dcx.sisalfa.connection;
import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import br.ufpb.dcx.sisalfa.database.SisalfaRepository;
import br.ufpb.dcx.sisalfa.models.Challenge;
import br.ufpb.dcx.sisalfa.models.SisContext;
import br.ufpb.dcx.sisalfa.models.User;
import br.ufpb.dcx.sisalfa.util.AndroidUtils;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Path;

public  class ConnectionAPI {

    private SisalfaRepository sisalfaRepository;

    public ConnectionAPI(Context ctx){
        this.sisalfaRepository =  new SisalfaRepository(ctx);
    }

    private Retrofit retrofitBuilder(String baseURL){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
       // HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        //loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS);

        //httpClient.addInterceptor(loggingInterceptor);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }

    public void startContexts() {
        Retrofit retrofit = retrofitBuilder(AndroidUtils.BASE_URL);
        LiteracyAPI literacyAPI = retrofit.create(LiteracyAPI.class);

        Call<List<SisContext>> call = literacyAPI.getAllContexts();

        try{
            List<SisContext> changesList = call.execute().body();
            for(SisContext sc: changesList){
                if(sisalfaRepository.getAllContexts().contains(sc)){
                    Log.i("TAG", "Object already exist.");
                }
                else{
                    System.out.println("CRIANDO CONTEXTO: " + sc.getName()+ "ID" + sc.getId());
                    try {
                        sc.setImageBytes(AndroidUtils.convertImageLinkToByteArray(sc.getImage()));
                        sisalfaRepository.createContext(sc);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }catch (IOException io){
            io.printStackTrace();
        }

        finally {
            sisalfaRepository.closeDB();
        }


    }

    public void getChallengesByContextIdFromService() {
        Retrofit retrofit = retrofitBuilder(AndroidUtils.BASE_URL);
        LiteracyAPI literacyAPI = retrofit.create(LiteracyAPI.class);

        Call<List<Challenge>> call = literacyAPI.getChallengeByContext(10);
        call.enqueue(new Callback<List<Challenge>>() {
            @Override
            public void onResponse(Call<List<Challenge>> call, Response<List<Challenge>> response) {
                if(response.isSuccessful()) {
                    List<Challenge> challenges = response.body();

                    for(Challenge c: challenges){
                        if(sisalfaRepository.getAllChallenges().contains(c)){
                            Log.i("TAG", "Object already exist.");
                        }
                        else{
                            System.out.println("CRIANDO DESAFIO. " + c.getWord() + "ID"+ c.getId());
                            try {
                                sisalfaRepository.createChallenge(c);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }else{
                    System.out.println("ERRO: " + response.errorBody());
                }

            }

            @Override
            public void onFailure(Call<List<Challenge>> call, Throwable t) {

            }
        });



    }


    public void startChallenges() {
        Retrofit retrofit = retrofitBuilder(AndroidUtils.BASE_URL);
        LiteracyAPI literacyAPI = retrofit.create(LiteracyAPI.class);

        Call<List<Challenge>> call = literacyAPI.getAllChallenges();
        try {
            List<Challenge> changesList = call.execute().body();
            for(Challenge c: changesList){
                if(sisalfaRepository.getAllChallenges().contains(c)){
                    Log.i("TAG", "Object already exist.");
                }
                else{
                    try {
                        c.setImageBytes(AndroidUtils.convertImageLinkToByteArray(c.getImage()));
                        sisalfaRepository.createChallenge(c);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("CRIANDO DESAFIO: "+c.getWord()+ "ID: "+c.getId());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sisalfaRepository.closeDB();
        }

    }
}
