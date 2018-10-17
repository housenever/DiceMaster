package model;

public class Context {

    private static int difficulty = 20;

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty){
        Context.difficulty = difficulty;
    }

}
