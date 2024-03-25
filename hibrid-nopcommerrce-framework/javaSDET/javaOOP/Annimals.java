package javaOOP;

public abstract class  Annimals {
    private String annimalName;
    protected  int annimalAge=5;
    protected void setAnnimalName (String annimalName){
        this.annimalName =annimalName;
    }
    protected String getAnnimalName(){
        return annimalName;
    }

}
