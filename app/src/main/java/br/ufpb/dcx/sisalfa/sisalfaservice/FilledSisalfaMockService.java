package br.ufpb.dcx.sisalfa.sisalfaservice;


import android.app.Activity;

import java.util.ArrayList;
import java.util.List;


import br.ufpb.dcx.sisalfa.models.Challenge;
import br.ufpb.dcx.sisalfa.models.SisContext;

public class FilledSisalfaMockService extends SisalfaMockService{


    public FilledSisalfaMockService(){
        this.sisContexts = createContexts();
        this.challenges = createChallenges();
        this.users = new ArrayList<>();

    }

    private List<SisContext> createContexts(){
        ArrayList<SisContext> aux = new ArrayList<>();
        SisContext sc1 = new SisContext();
        sc1.setContextId(1);
        sc1.setName("bodyTheme");
        aux.add(sc1);

        SisContext sc2 = new SisContext();
        sc1.setContextId(2);
        sc1.setName("animalsTheme");
        aux.add(sc2);

        SisContext sc3 = new SisContext();
        sc1.setContextId(3);
        sc1.setName("colorsTheme");
        aux.add(sc3);

        SisContext sc4 = new SisContext();
        sc1.setContextId(4);
        sc1.setName("professionsTheme");
        aux.add(sc4);

        SisContext sc5 = new SisContext();
        sc1.setContextId(5);
        sc1.setName("fruitsTheme");
        aux.add(sc5);

        SisContext sc6 = new SisContext();
        sc1.setContextId(6);
        sc1.setName("homeTheme");
        aux.add(sc6);
        return aux;

    }

    private List<Challenge> createChallenges(){
        List<Challenge> aux = new ArrayList<>();

        aux.addAll(createBodyChallenges());
        aux.addAll(createAnimalsChallenges());
       // aux.addAll(createColorsChallenges());
        aux.addAll(createHomeChallenges());
        aux.addAll(createFruitsChallenges());
        aux.addAll(createProfessionsChallenges());

        return aux;
    }


    private List<Challenge> createBodyChallenges(){
        List<Challenge> aux = new ArrayList<>();

        Challenge c1 = new Challenge();
        c1.setContextId(1);
        c1.setWord("Cabeça");
        aux.add(c1);

        Challenge c2 = new Challenge();
        c1.setContextId(1);
        c1.setWord("Braço");
        aux.add(c2);

        Challenge c3 = new Challenge();
        c1.setContextId(1);
        c1.setWord("Antebraço");
        aux.add(c3);

        Challenge c4 = new Challenge();
        c1.setContextId(1);
        c1.setWord("Ombros");
        aux.add(c4);

        Challenge c5 = new Challenge();
        c1.setContextId(1);
        c1.setWord("Dorso");
        aux.add(c5);

        Challenge c6 = new Challenge();
        c1.setContextId(1);
        c1.setWord("Costas");
        aux.add(c6);

        Challenge c7 = new Challenge();
        c1.setContextId(1);
        c1.setWord("Mãos");
        aux.add(c7);

        Challenge c8 = new Challenge();
        c1.setContextId(1);
        c1.setWord("Pés");
        aux.add(c8);

        Challenge c9 = new Challenge();
        c1.setContextId(1);
        c1.setWord("Pernas");
        aux.add(c9);

        Challenge c10 = new Challenge();
        c1.setContextId(1);
        c1.setWord("Quadril");
        aux.add(c10);

        return aux;
    }

    public List<Challenge> createAnimalsChallenges(){
        List<Challenge> aux = new ArrayList<>();

        Challenge c1 = new Challenge();
        c1.setContextId(2);
        c1.setWord("Cobra");
        aux.add(c1);

        Challenge c2 = new Challenge();
        c1.setContextId(2);
        c1.setWord("Leão");
        aux.add(c2);

        Challenge c3 = new Challenge();
        c1.setContextId(2);
        c1.setWord("Camelo");
        aux.add(c3);

        Challenge c4 = new Challenge();
        c1.setContextId(2);
        c1.setWord("Girafa");
        aux.add(c4);

        Challenge c5 = new Challenge();
        c1.setContextId(2);
        c1.setWord("Elefante");
        aux.add(c5);

        Challenge c6 = new Challenge();
        c1.setContextId(2);
        c1.setWord("Hipopotamo");
        aux.add(c6);

        Challenge c7 = new Challenge();
        c1.setContextId(2);
        c1.setWord("Macaco");
        aux.add(c7);

        Challenge c8 = new Challenge();
        c1.setContextId(2);
        c1.setWord("Ovelha");
        aux.add(c8);

        Challenge c9 = new Challenge();
        c1.setContextId(2);
        c1.setWord("Cachorro");
        aux.add(c9);

        Challenge c10 = new Challenge();
        c1.setContextId(2);
        c1.setWord("Gato");
        aux.add(c10);

        return aux;
    }

    /*public List<Challenge> createColorsChallenges(){
        List<Challenge> aux = new ArrayList<>();

        Challenge c1 = new Challenge();
        c1.setContextId(3);
        c1.setWord("Azul");
        c1.setImage(2131099735);
        aux.add(c1);

        Challenge c2 = new Challenge();
        c2.setContextId(3);
        c2.setWord("Preto");
        aux.add(c2);
        c2.setImage(2131099734);

        Challenge c3 = new Challenge();
        c3.setContextId(3);
        c3.setWord("Amarelo");
        c3.setImage(2131099767);
        aux.add(c3);

        Challenge c4 = new Challenge();
        c4.setContextId(3);
        c4.setWord("Verde");
        c4.setImage(2131099742);
        aux.add(c4);


        Challenge c5 = new Challenge();
        c5.setContextId(3);
        c5.setWord("Vermelho");
        c5.setImage(2131099764);
        aux.add(c5);

        Challenge c6 = new Challenge();
        c6.setContextId(3);
        c6.setWord("Cinza");
        c6.setImage(2131099741);
        aux.add(c6);

        Challenge c7 = new Challenge();
        c7.setContextId(3);
        c7.setWord("Branco");
        aux.add(c7);

        Challenge c8 = new Challenge();
        c8.setContextId(3);
        c8.setWord("Laranja");
        aux.add(c8);

        Challenge c9 = new Challenge();
        c9.setContextId(3);
        c9.setWord("Marrom");
        c9.setImage(2131099737);
        aux.add(c9);


        Challenge c10 = new Challenge();
        c10.setContextId(3);
        c10.setWord("Roxo");
        c10.setImage(2131099763);
        aux.add(c10);

        return aux;
    }*/

    public List<Challenge> createProfessionsChallenges(){
        List<Challenge> aux = new ArrayList<>();

        Challenge c1 = new Challenge();
        c1.setContextId(4);
        c1.setWord("Médico");
        aux.add(c1);

        Challenge c2 = new Challenge();
        c1.setContextId(4);
        c1.setWord("Advogado");
        aux.add(c2);

        Challenge c3 = new Challenge();
        c1.setContextId(4);
        c1.setWord("Programador");
        aux.add(c3);

        Challenge c4 = new Challenge();
        c1.setContextId(4);
        c1.setWord("Psicólogo");
        aux.add(c4);

        Challenge c5 = new Challenge();
        c1.setContextId(4);
        c1.setWord("Motorista");
        aux.add(c5);

        Challenge c6 = new Challenge();
        c1.setContextId(4);
        c1.setWord("Cabeleireiro");
        aux.add(c6);

        Challenge c7 = new Challenge();
        c1.setContextId(4);
        c1.setWord("Soldado");
        aux.add(c7);

        Challenge c8 = new Challenge();
        c1.setContextId(4);
        c1.setWord("Policial");
        aux.add(c8);

        Challenge c9 = new Challenge();
        c1.setContextId(4);
        c1.setWord("Vendedor");
        aux.add(c9);

        Challenge c10 = new Challenge();
        c1.setContextId(4);
        c1.setWord("Consultor");
        aux.add(c10);

        return aux;
    }

    public List<Challenge> createFruitsChallenges(){
        List<Challenge> aux = new ArrayList<>();

        Challenge c1 = new Challenge();
        c1.setContextId(5);
        c1.setWord("Maçã");
        aux.add(c1);

        Challenge c2 = new Challenge();
        c1.setContextId(5);
        c1.setWord("Laranja");
        aux.add(c2);

        Challenge c3 = new Challenge();
        c1.setContextId(5);
        c1.setWord("Abacaxi");
        aux.add(c3);

        Challenge c4 = new Challenge();
        c1.setContextId(5);
        c1.setWord("Melancia");
        aux.add(c4);

        Challenge c5 = new Challenge();
        c1.setContextId(5);
        c1.setWord("Goiaba");
        aux.add(c5);

        Challenge c6 = new Challenge();
        c1.setContextId(5);
        c1.setWord("Acerola");
        aux.add(c6);

        Challenge c7 = new Challenge();
        c1.setContextId(5);
        c1.setWord("Banana");
        aux.add(c7);

        Challenge c8 = new Challenge();
        c1.setContextId(5);
        c1.setWord("Morango");
        aux.add(c8);

        Challenge c9 = new Challenge();
        c1.setContextId(5);
        c1.setWord("Manga");
        aux.add(c9);

        Challenge c10 = new Challenge();
        c1.setContextId(5);
        c1.setWord("Coco");
        aux.add(c10);

        return aux;
    }

    public List<Challenge> createHomeChallenges(){
        List<Challenge> aux = new ArrayList<>();

        Challenge c1 = new Challenge();
        c1.setContextId(6);
        c1.setWord("Janela");
        aux.add(c1);

        Challenge c2 = new Challenge();
        c1.setContextId(6);
        c1.setWord("Cama");
        aux.add(c2);

        Challenge c3 = new Challenge();
        c1.setContextId(6);
        c1.setWord("Quintal");
        aux.add(c3);

        Challenge c4 = new Challenge();
        c1.setContextId(6);
        c1.setWord("Banheiro");
        aux.add(c4);

        Challenge c5 = new Challenge();
        c1.setContextId(6);
        c1.setWord("Computador");
        aux.add(c5);

        Challenge c6 = new Challenge();
        c1.setContextId(6);
        c1.setWord("Varanda");
        aux.add(c6);

        Challenge c7 = new Challenge();
        c1.setContextId(6);
        c1.setWord("Cozinha");
        aux.add(c7);

        Challenge c8 = new Challenge();
        c1.setContextId(6);
        c1.setWord("Sofá");
        aux.add(c8);

        Challenge c9 = new Challenge();
        c1.setContextId(6);
        c1.setWord("Cama");
        aux.add(c9);

        Challenge c10 = new Challenge();
        c1.setContextId(6);
        c1.setWord("Quarto");
        aux.add(c10);

        return aux;
    }




}
