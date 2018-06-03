package br.ufpb.dcx.sisalfa.connection;



import java.util.List;

import br.ufpb.dcx.sisalfa.models.Challenge;
import br.ufpb.dcx.sisalfa.models.SisContext;
import br.ufpb.dcx.sisalfa.models.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LiteracyAPI {

    @GET("getAllContexts/")
    Call<List<SisContext>> getAllContexts();

    @GET("getContextFromUser/ {userId}")
    Call<SisContext> getContextFromUser(@Path("userId") long id);

    @GET("getContext/ {id}")
    Call<SisContext> getContext(@Path("id") long id);

    @GET("getAllUsers/")
    Call<List<User>> getAllUsers();

    @GET("getAllChallenges/")
    Call<List<Challenge>> getAllChallenges();
}

