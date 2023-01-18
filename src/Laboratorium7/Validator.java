package Laboratorium7;

public class Validator {
    private static final Validator INSTANCE = new Validator();
    public static Validator getInstance(){ return INSTANCE;}
    public void validateDouble (double a)throws LessThanZero{
        if (a<0){
            throw new LessThanZero(a);
        }
    }
}
