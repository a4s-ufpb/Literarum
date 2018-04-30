package br.ufpb.dcx.sisalfa.models;

/**
 * Created by rynzler on 29/03/18.
 */

public class DataNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public DataNotFoundException() {
        super();
    }

    public DataNotFoundException(String msg) {
        super(msg);
    }

}