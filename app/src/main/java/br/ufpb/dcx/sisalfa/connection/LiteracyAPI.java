package br.ufpb.dcx.sisalfa.connection;



import java.util.List;

import br.ufpb.dcx.sisalfa.sisalfaservice.SisalfaMockService;
import br.ufpb.dcx.sisalfa.util.AndroidUtils;
import retrofit2.Call;
import retrofit2.http.GET;

public interface LiteracyAPI {

    @GET(AndroidUtils.LITERACY_API_ENDPOINT)
    Call<List<SisalfaMockService>> getChallenges();
}
