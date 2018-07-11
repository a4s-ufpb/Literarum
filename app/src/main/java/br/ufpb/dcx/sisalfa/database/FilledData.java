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
        sc1.setImage("teste1");
        sc1.setUserId(1);
        aux.add(sc1);

        SisContext sc2 = new SisContext();
        sc2.setContextId(2);
        sc2.setName("animalsTheme");
        sc2.setImage("teste2");
        sc2.setUserId(1);
        aux.add(sc2);

        SisContext sc3 = new SisContext();
        sc3.setContextId(3);
        sc3.setName("colorsTheme");
        sc3.setImage("teste3");
        sc3.setUserId(1);
        aux.add(sc3);

        SisContext sc4 = new SisContext();
        sc4.setContextId(4);
        sc4.setName("professionsTheme");
        sc4.setImage("teste4");
        sc4.setUserId(1);
        aux.add(sc4);

        SisContext sc5 = new SisContext();
        sc5.setContextId(5);
        sc5.setName("fruitsTheme");
        sc5.setImage("teste5");
        sc5.setUserId(1);
        aux.add(sc5);

        SisContext sc6 = new SisContext();
        sc6.setContextId(6);
        sc6.setName("homeTheme");
        sc6.setImage("teste6");
        sc6.setUserId(1);
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
        c1.setChallengeId(1);
        c1.setContextId(3);
        c1.setWord("blue");
        c1.setImage("drawable/blue.png");
        c1.setUserId(1);
        aux.add(c1);

        Challenge c2 = new Challenge();
        c2.setChallengeId(2);
        c2.setContextId(3);
        c2.setWord("Preto");
        c2.setUserId(1);
        c2.setImage("drawable/black.png");
        aux.add(c2);


        Challenge c3 = new Challenge();
        c3.setChallengeId(3);
        c3.setContextId(3);
        c3.setWord("Amarelo");
        c3.setImage("drawable/yellow.png");
        c3.setUserId(1);
        aux.add(c3);

        Challenge c4 = new Challenge();
        c4.setChallengeId(4);
        c4.setContextId(3);
        c4.setWord("Verde");
        c4.setImage("drawable/green.png");
        c4.setUserId(1);
        aux.add(c4);


        Challenge c5 = new Challenge();
        c5.setChallengeId(5);
        c5.setContextId(3);
        c5.setWord("Vermelho");
        c5.setImage("drawable/red.png");
        c5.setUserId(1);
        aux.add(c5);

        Challenge c6 = new Challenge();
        c6.setChallengeId(6);
        c6.setContextId(3);
        c6.setWord("Cinza");
        c6.setImage("drawable/gray.png");
        c6.setUserId(1);
        aux.add(c6);


        Challenge c9 = new Challenge();
        c9.setChallengeId(7);
        c9.setContextId(3);
        c9.setWord("Marrom");
        c9.setImage("drawable/brown.png");
        c9.setUserId(1);
        aux.add(c9);


        Challenge c10 = new Challenge();
        c10.setChallengeId(8);
        c10.setContextId(3);
        c10.setWord("Roxo");
        c10.setImage("drawable/purple.png");
        c10.setUserId(1);
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

