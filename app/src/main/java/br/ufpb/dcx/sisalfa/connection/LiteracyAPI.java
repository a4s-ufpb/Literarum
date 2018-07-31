package br.ufpb.dcx.sisalfa.connection;



import java.util.List;

import br.ufpb.dcx.sisalfa.models.Challenge;
import br.ufpb.dcx.sisalfa.models.SisContext;
import br.ufpb.dcx.sisalfa.models.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LiteracyAPI {

    @GET("contexts/")
    Call<List<SisContext>> getAllContexts();

    @GET("challenges/{id}/context/")
    Call<List<Challenge>> getChallengeByContext(@Path("id") long id);

    @GET("getContext/ {id}")
    Call<SisContext> getContext(@Path("id") long id);

    @GET("challenges")
    Call<List<Challenge>> getAllChallenges();
}

