package br.ufpb.dcx.sisalfa.database;

import android.content.Context;

import android.util.Base64;


import com.example.rynzler.literarum.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufpb.dcx.sisalfa.models.Challenge;
import br.ufpb.dcx.sisalfa.models.SisContext;
import br.ufpb.dcx.sisalfa.util.AndroidUtils;

public class FilledData {

    private SisalfaRepository sisalfaRepository;
    private Context ctx;

    public FilledData(Context ctx) {
        this.sisalfaRepository = new SisalfaRepository(ctx);
        this.ctx = ctx;
    }

    public void execute() throws IOException {
        createLocalContext();
        createColorsChallenges();
        createAnimalsChallenges();
        createBodyChallenges();
        createProfessionsChallenges();
        createFruitsChallenges();
        createHomeChallenges();
    }
    private byte[] base64toByteArray(String str){
        byte[] decodedString = Base64.decode(str, Base64.DEFAULT);
        return decodedString;
        //Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }


    private void createLocalContext() throws IOException {

        if(sisalfaRepository.getAllContexts().size() == 0) {
            ArrayList<SisContext> aux = new ArrayList<>();
            SisContext sc1 = new SisContext();
            sc1.setId(111);
            sc1.setName("Corpo humano");
            sc1.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.body));
            aux.add(sc1);

            SisContext sc2 = new SisContext();
            sc2.setId(222);
            sc2.setName("Animais");
            sc2.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.animals));
            aux.add(sc2);

            SisContext sc3 = new SisContext();
            sc3.setId(333);
            sc3.setName("Cores");
            sc3.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.colors));
            aux.add(sc3);

            SisContext sc4 = new SisContext();
            sc4.setId(444);
            sc4.setName("Profissões");
            sc4.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.professions));
            aux.add(sc4);

            SisContext sc5 = new SisContext();
            sc5.setId(555);
            sc5.setName("Frutas");
            sc5.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.fruits));
            aux.add(sc5);

            SisContext sc6 = new SisContext();
            sc6.setId(666);
            sc6.setName("Casa");
            sc6.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.home));
            aux.add(sc6);
            for (SisContext scs : aux) {
                System.out.println("Criando ctx: "+ scs.getName());
                sisalfaRepository.createContext(scs);
            }
        }




    }



    private void createColorsChallenges() throws IOException {

        if(sisalfaRepository.getChallengesByContext(333).size() == 0) {
            List<Challenge> aux = new ArrayList<>();
            SisContext sisContext = new SisContext();
            sisContext.setId(333);

            Challenge c1 = new Challenge();
            c1.setId(1111);
            c1.setContext(sisContext);
            c1.setWord("Azul");
            c1.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.blue));
            aux.add(c1);

            Challenge c2 = new Challenge();
            c2.setId(2222);
            c2.setContext(sisContext);
            c2.setWord("Preto");
            c2.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.black));
            aux.add(c2);


            Challenge c3 = new Challenge();
            c3.setId(3333);
            c3.setContext(sisContext);
            c3.setWord("Amarelo");
            c3.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.yellow));
            aux.add(c3);

            Challenge c4 = new Challenge();
            c4.setId(4444);
            c4.setContext(sisContext);
            c4.setWord("Verde");
            c4.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.green));
            aux.add(c4);


            Challenge c5 = new Challenge();
            c5.setId(5555);
            c5.setContext(sisContext);
            c5.setWord("Vermelho");
            c5.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.red));
            aux.add(c5);

            Challenge c6 = new Challenge();
            c6.setId(6666);
            c6.setContext(sisContext);
            c6.setWord("Cinza");
            c6.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.gray));
            aux.add(c6);


            Challenge c9 = new Challenge();
            c9.setId(7777);
            c9.setContext(sisContext);
            c9.setWord("Marrom");
            c9.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.brown));
            aux.add(c9);


            Challenge c10 = new Challenge();
            c10.setId(8888);
            c10.setContext(sisContext);
            c10.setWord("Roxo");
            c10.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.purple));
            aux.add(c10);

            for (Challenge c : aux) {
                System.out.println("CRIANDO DESAFIO: "+ c.getWord());
                sisalfaRepository.createChallenge(c);

            }
        }


    }

    private void createBodyChallenges() throws IOException {

        if(sisalfaRepository.getChallengesByContext(111).size() == 0) {
            List<Challenge> aux = new ArrayList<>();
            SisContext sisContext = new SisContext();
            sisContext.setId(111);

            Challenge c1 = new Challenge();
            c1.setId(4324);
            c1.setContext(sisContext);
            c1.setWord("Nariz");
            c1.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.nose));
            aux.add(c1);

            Challenge c2 = new Challenge();
            c2.setId(764);
            c2.setContext(sisContext);
            c2.setWord("Orelha");
            c2.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.orelha));
            aux.add(c2);


            Challenge c3 = new Challenge();
            c3.setId(3443);
            c3.setContext(sisContext);
            c3.setWord("Boca");
            c3.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.boca));
            aux.add(c3);

            Challenge c4 = new Challenge();
            c4.setId(2322);
            c4.setContext(sisContext);
            c4.setWord("Pé");
            c4.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.pe));
            aux.add(c4);


            Challenge c5 = new Challenge();
            c5.setId(1555);
            c5.setContext(sisContext);
            c5.setWord("Cabeça");
            c5.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.cabeca));
            aux.add(c5);

            Challenge c6 = new Challenge();
            c6.setId(6166);
            c6.setContext(sisContext);
            c6.setWord("Braço");
            c6.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.braco));
            aux.add(c6);


            Challenge c9 = new Challenge();
            c9.setId(7717);
            c9.setContext(sisContext);
            c9.setWord("Joelho");
            c9.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.joelho));
            aux.add(c9);

            for (Challenge c : aux) {
                System.out.println("CRIANDO DESAFIO: "+ c.getWord());
                sisalfaRepository.createChallenge(c);

            }
        }


    }

    private void createAnimalsChallenges() throws IOException {

        if(sisalfaRepository.getChallengesByContext(222).size() == 0) {
            List<Challenge> aux = new ArrayList<>();
            SisContext sisContext = new SisContext();
            sisContext.setId(222);

            Challenge c1 = new Challenge();
            c1.setId(11111);
            c1.setContext(sisContext);
            c1.setWord("Leão");
            c1.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.leao));
            aux.add(c1);

            Challenge c2 = new Challenge();
            c2.setId(22222);
            c2.setContext(sisContext);
            c2.setWord("Girafa");
            c2.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.girafa));
            aux.add(c2);


            Challenge c3 = new Challenge();
            c3.setId(33333);
            c3.setContext(sisContext);
            c3.setWord("Jacaré");
            c3.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.jacare));
            aux.add(c3);

            Challenge c4 = new Challenge();
            c4.setId(44444);
            c4.setContext(sisContext);
            c4.setWord("Elefante");
            c4.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.elefante));
            aux.add(c4);


            Challenge c5 = new Challenge();
            c5.setId(55555);
            c5.setContext(sisContext);
            c5.setWord("Pinguim");
            c5.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.pinguim));
            aux.add(c5);

            Challenge c6 = new Challenge();
            c6.setId(66666);
            c6.setContext(sisContext);
            c6.setWord("Hipopotamo");
            c6.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.hipopotamo));
            aux.add(c6);


            Challenge c9 = new Challenge();
            c9.setId(77777);
            c9.setContext(sisContext);
            c9.setWord("Macaco");
            c9.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.macaco));
            aux.add(c9);


            Challenge c10 = new Challenge();
            c10.setId(8888);
            c10.setContext(sisContext);
            c10.setWord("Lêmure");
            c10.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.lemure));
            aux.add(c10);

            Challenge c11 = new Challenge();
            c11.setId(8888);
            c11.setContext(sisContext);
            c11.setWord("Rinoceronte");
            c11.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.rino));
            aux.add(c11);

            Challenge c12 = new Challenge();
            c12.setId(8888);
            c12.setContext(sisContext);
            c12.setWord("Tigre");
            c12.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.tigre));
            aux.add(c12);

            for (Challenge c : aux) {
                System.out.println("CRIANDO DESAFIO: "+ c.getWord());
                sisalfaRepository.createChallenge(c);

            }
        }


    }

    private void createProfessionsChallenges() throws IOException {


        if(sisalfaRepository.getChallengesByContext(444).size() == 0) {
            List<Challenge> aux = new ArrayList<>();
            SisContext sisContext = new SisContext();
            sisContext.setId(444);

            Challenge c1 = new Challenge();
            c1.setId(4321);
            c1.setContext(sisContext);
            c1.setWord("Médico");
            c1.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.medico));
            aux.add(c1);

            Challenge c2 = new Challenge();
            c2.setId(264);
            c2.setContext(sisContext);
            c2.setWord("Policial");
            c2.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.policial));
            aux.add(c2);


            Challenge c3 = new Challenge();
            c3.setId(3473);
            c3.setContext(sisContext);
            c3.setWord("Enfermeira");
            c3.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.enfermeira));
            aux.add(c3);

            Challenge c4 = new Challenge();
            c4.setId(2372);
            c4.setContext(sisContext);
            c4.setWord("General");
            c4.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.general));
            aux.add(c4);


            Challenge c5 = new Challenge();
            c5.setId(1525);
            c5.setContext(sisContext);
            c5.setWord("Aeromoça");
            c5.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.aeromoca));
            aux.add(c5);

            Challenge c6 = new Challenge();
            c6.setId(6266);
            c6.setContext(sisContext);
            c6.setWord("Bombeiro");
            c6.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.bombeiro));
            aux.add(c6);


            Challenge c9 = new Challenge();
            c9.setId(7727);
            c9.setContext(sisContext);
            c9.setWord("Joelho");
            c9.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.professor));
            aux.add(c9);
            for (Challenge c : aux) {
                System.out.println("CRIANDO DESAFIO: "+ c.getWord());
                sisalfaRepository.createChallenge(c);

            }
        }


    }

    private void createFruitsChallenges() throws IOException {


        if(sisalfaRepository.getChallengesByContext(555).size() == 0) {
            List<Challenge> aux = new ArrayList<>();
            SisContext sisContext = new SisContext();
            sisContext.setId(555);

            Challenge c1 = new Challenge();
            c1.setId(2111);
            c1.setContext(sisContext);
            c1.setWord("Goiaba");
            c1.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.goiaba));
            aux.add(c1);

            Challenge c2 = new Challenge();
            c2.setId(1222);
            c2.setContext(sisContext);
            c2.setWord("Abacaxi");
            c2.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.abacaxi));
            aux.add(c2);


            Challenge c3 = new Challenge();
            c3.setId(1333);
            c3.setContext(sisContext);
            c3.setWord("Coco");
            c3.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.coco));
            aux.add(c3);

            Challenge c4 = new Challenge();
            c4.setId(7444);
            c4.setContext(sisContext);
            c4.setWord("Kiwi");
            c4.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.kiwi));
            aux.add(c4);


            Challenge c5 = new Challenge();
            c5.setId(9555);
            c5.setContext(sisContext);
            c5.setWord("Laranja");
            c5.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.laranja));
            aux.add(c5);

            Challenge c6 = new Challenge();
            c6.setId(7666);
            c6.setContext(sisContext);
            c6.setWord("Morango");
            c6.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.morango));
            aux.add(c6);


            Challenge c9 = new Challenge();
            c9.setId(9777);
            c9.setContext(sisContext);
            c9.setWord("Maçã");
            c9.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.maca));
            aux.add(c9);


            Challenge c10 = new Challenge();
            c10.setId(1888);
            c10.setContext(sisContext);
            c10.setWord("Pêra");
            c10.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.pera));
            aux.add(c10);

            Challenge c11 = new Challenge();
            c11.setId(1858);
            c11.setContext(sisContext);
            c11.setWord("Uva");
            c11.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.uva));
            aux.add(c11);

            Challenge c12 = new Challenge();
            c12.setId(1858);
            c12.setContext(sisContext);
            c12.setWord("Melancia");
            c12.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.melancia));
            aux.add(c12);
            for (Challenge c : aux) {
                System.out.println("CRIANDO DESAFIO: "+ c.getWord());
                sisalfaRepository.createChallenge(c);

            }
        }


    }

    private void createHomeChallenges() throws IOException {


        if(sisalfaRepository.getChallengesByContext(666).size() == 0) {
            List<Challenge> aux = new ArrayList<>();
            SisContext sisContext = new SisContext();
            sisContext.setId(666);

            Challenge c1 = new Challenge();
            c1.setId(1161);
            c1.setContext(sisContext);
            c1.setWord("Geladeira");
            c1.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.geladeira));
            aux.add(c1);

            Challenge c2 = new Challenge();
            c2.setId(2226);
            c2.setContext(sisContext);
            c2.setWord("Banheiro");
            c2.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.banheiro));
            aux.add(c2);


            Challenge c3 = new Challenge();
            c3.setId(3636);
            c3.setContext(sisContext);
            c3.setWord("Panela");
            c3.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.panela));
            aux.add(c3);

            Challenge c4 = new Challenge();
            c4.setId(4646);
            c4.setContext(sisContext);
            c4.setWord("Cama");
            c4.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.cama));
            aux.add(c4);

        /*
        Challenge c5 = new Challenge();
        c5.setId(6565);
        c5.setContext(sisContext);
        c5.setWord("Vermelho");
        c5.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.red));
        aux.add(c5);

        Challenge c6 = new Challenge();
        c6.setId(6767);
        c6.setContext(sisContext);
        c6.setWord("Cinza");
        c6.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.gray));
        aux.add(c6);


        Challenge c9 = new Challenge();
        c9.setId(1717);
        c9.setContext(sisContext);
        c9.setWord("Marrom");
        c9.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.brown));
        aux.add(c9);


        Challenge c10 = new Challenge();
        c10.setId(1887);
        c10.setContext(sisContext);
        c10.setWord("Roxo");
        c10.setImageBytes(AndroidUtils.drawableToByteArray(this.ctx, R.drawable.purple));
        aux.add(c10);*/
            for (Challenge c : aux) {
                System.out.println("CRIANDO DESAFIO: "+ c.getWord());
                sisalfaRepository.createChallenge(c);

            }
        }


    }




}
