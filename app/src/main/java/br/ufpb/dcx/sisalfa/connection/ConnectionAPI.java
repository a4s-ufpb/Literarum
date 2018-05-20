package br.ufpb.dcx.sisalfa.connection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import br.ufpb.dcx.sisalfa.sisalfaservice.SisalfaMockService;
import br.ufpb.dcx.sisalfa.util.AndroidUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectionAPI implements Callback<List<SisalfaMockService>> {

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AndroidUtils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        LiteracyAPI literacyAPI = retrofit.create(LiteracyAPI.class);
        //ver viabilidade de usar isso para importar temas usando querys especificas
        Call<List<SisalfaMockService>> call = literacyAPI.getChallenges();
        call.enqueue(this);

    }


    @Override
    public void onResponse(Call<List<SisalfaMockService>> call, Response<List<SisalfaMockService>> response) {
        if(response.isSuccessful()) {
            List<SisalfaMockService> changesList = response.body();
            System.out.println(changesList.size());
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<SisalfaMockService>> call, Throwable t) {
        t.printStackTrace();
    }
}
