package br.ufpb.dcx.sisalfa.database;

import android.content.Context;

public class FilledData {

    private SisalfaRepository sisalfaRepository;

    public FilledData(Context ctx){
        this.sisalfaRepository =  new SisalfaRepository(ctx);
    }


}

