package Laboratorium8;

public class Validator {
    private static final Validator INSTANCE = new Validator();
    public static Validator getInstance(){ return INSTANCE;}
    public boolean isNull (Object a) {
        return a==null;
    }
}
