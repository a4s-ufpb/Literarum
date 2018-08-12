package br.ufpb.dcx.sisalfa.models;

public class SelectedContexModel {

    private int id;
    private int count;
    private int firstSelectedContextId;
    private int secondSelectedContextId;
    private int thirdSelectedContextId;
    private int fourthSelectedContextId;
    private int fifthSelectedContextId;
    private int sisxthSelectedContextId;

    public SelectedContexModel(){}

    public SelectedContexModel(int id, int count, int firstSelectedContextId, int secondSelectedContextId, int thirdSelectedContextId, int fourthSelectedContextId, int fifthSelectedContextId, int sisxthSelectedContextId) {
        this.id = id;
        this.count = count;
        this.firstSelectedContextId = firstSelectedContextId;
        this.secondSelectedContextId = secondSelectedContextId;
        this.thirdSelectedContextId = thirdSelectedContextId;
        this.fourthSelectedContextId = fourthSelectedContextId;
        this.fifthSelectedContextId = fifthSelectedContextId;
        this.sisxthSelectedContextId = sisxthSelectedContextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getFirstSelectedContextId() {
        return firstSelectedContextId;
    }

    public void setFirstSelectedContextId(int firstSelectedContextId) {
        this.firstSelectedContextId = firstSelectedContextId;
    }

    public int getSecondSelectedContextId() {
        return secondSelectedContextId;
    }

    public void setSecondSelectedContextId(int secondSelectedContextId) {
        this.secondSelectedContextId = secondSelectedContextId;
    }

    public int getThirdSelectedContextId() {
        return thirdSelectedContextId;
    }

    public void setThirdSelectedContextId(int thirdSelectedContextId) {
        this.thirdSelectedContextId = thirdSelectedContextId;
    }

    public int getFourthSelectedContextId() {
        return fourthSelectedContextId;
    }

    public void setFourthSelectedContextId(int fourthSelectedContextId) {
        this.fourthSelectedContextId = fourthSelectedContextId;
    }

    public int getFifthSelectedContextId() {
        return fifthSelectedContextId;
    }

    public void setFifthSelectedContextId(int fifthSelectedContextId) {
        this.fifthSelectedContextId = fifthSelectedContextId;
    }

    public int getSisxthSelectedContextId() {
        return sisxthSelectedContextId;
    }

    public void setSisxthSelectedContextId(int sisxthSelectedContextId) {
        this.sisxthSelectedContextId = sisxthSelectedContextId;
    }
}
