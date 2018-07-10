package br.ufpb.dcx.sisalfa.database;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.ufpb.dcx.sisalfa.models.Challenge;
import br.ufpb.dcx.sisalfa.models.SisContext;

public class FilledData {

    private SisalfaRepository sisalfaRepository;

    public FilledData(Context ctx){
        this.sisalfaRepository =  new SisalfaRepository(ctx);
        createLocalContext();
        createColorsChallenges();
    }

    private void createLocalContext(){
        ArrayList<SisContext> aux = new ArrayList<>();
        SisContext sc1 = new SisContext();
        sc1.setContextId(1);
        sc1.setName("bodyTheme");
        aux.add(sc1);

        SisContext sc2 = new SisContext();
        sc2.setContextId(2);
        sc2.setName("animalsTheme");
        aux.add(sc2);

        SisContext sc3 = new SisContext();
        sc3.setContextId(3);
        sc3.setName("colorsTheme");

        aux.add(sc3);

        SisContext sc4 = new SisContext();
        sc4.setContextId(4);
        sc4.setName("professionsTheme");
        aux.add(sc4);

        SisContext sc5 = new SisContext();
        sc5.setContextId(5);
        sc5.setName("fruitsTheme");
        aux.add(sc5);

        SisContext sc6 = new SisContext();
        sc6.setContextId(6);
        sc6.setName("homeTheme");
        aux.add(sc6);
        if(sisalfaRepository.getAllContexts() != null) {
            for (SisContext scs : aux) {
                if (!sisalfaRepository.getAllContexts().contains(scs))
                    sisalfaRepository.createContext(scs);
                else
                    Log.i("TAG", "SisContext already exists!");
            }
        }else{
            for (SisContext scs : aux) {
                if (!sisalfaRepository.getAllContexts().contains(scs))
                    sisalfaRepository.createContext(scs);
                else
                    Log.i("TAG", "SisContext already exists!");
            }
        }




    }

    private void createColorsChallenges(){
        List<Challenge> aux = new ArrayList<>();

        Challenge c1 = new Challenge();
        c1.setContextId(3);
        c1.setWord("blue");
        c1.setImage("drawable/blue.png");
        aux.add(c1);

        Challenge c2 = new Challenge();
        c2.setContextId(3);
        c2.setWord("Preto");
        aux.add(c2);
        c2.setImage("drawable/black.png");

        Challenge c3 = new Challenge();
        c3.setContextId(3);
        c3.setWord("Amarelo");
        c3.setImage("drawable/yellow.png");
        aux.add(c3);

        Challenge c4 = new Challenge();
        c4.setContextId(3);
        c4.setWord("Verde");
        c4.setImage("drawable/green.png");
        aux.add(c4);


        Challenge c5 = new Challenge();
        c5.setContextId(3);
        c5.setWord("Vermelho");
        c5.setImage("drawable/red.png");
        aux.add(c5);

        Challenge c6 = new Challenge();
        c6.setContextId(3);
        c6.setWord("Cinza");
        c6.setImage("drawable/gray.png");
        aux.add(c6);


        Challenge c9 = new Challenge();
        c9.setContextId(3);
        c9.setWord("Marrom");
        c9.setImage("drawable/brown.png");
        aux.add(c9);


        Challenge c10 = new Challenge();
        c10.setContextId(3);
        c10.setWord("Roxo");
        c10.setImage("drawable/purple.png");
        aux.add(c10);

        if(sisalfaRepository.getChallengesByContext(3) != null) {
            for (Challenge c : aux) {
                if (!sisalfaRepository.getChallengesByContext(3).contains(c))
                    sisalfaRepository.createChallenge(c);
                else
                    Log.i("TAG", "SisContext already exists!");
            }
        }else{
            for (Challenge c : aux) {
                if (!sisalfaRepository.getChallengesByContext(3).contains(c))
                    sisalfaRepository.createChallenge(c);
                else
                    Log.i("TAG", "SisContext already exists!");
            }
        }


    }



}

