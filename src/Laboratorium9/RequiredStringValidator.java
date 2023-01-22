package Laboratorium9;

public class RequiredStringValidator {
    private static final RequiredStringValidator INSTANCE= new RequiredStringValidator();
    private static final String VALIDATE_REQUIRED_MESSAGE = "STRING NIE MOŻE BYĆ RÓWNY NULL I MUSI MIEĆ CO NAJMNIEJ DŁUGOŚĆ 1 ZNAKÓW";
    public static RequiredStringValidator getInstance(){
        return INSTANCE;
    }
    public void validate(String value){
        validate(value, RequiredStringValidator.VALIDATE_REQUIRED_MESSAGE);
    }
    public void validate(String value, String message){
        if(value==null || value.length()==0){
            throw new IllegalArgumentException(message);
        }
    }
}
