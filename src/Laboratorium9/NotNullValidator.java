package Laboratorium9;

public class NotNullValidator {
    private static final NotNullValidator INSTANCE= new NotNullValidator();
    private static final String VALIDATE_NOT_NULL_MESSAGE = "Nie podano argumetu";
    public static NotNullValidator getInstance(){
        return NotNullValidator.INSTANCE;
    }
    public void validate(Object value){
        validate(value, NotNullValidator.VALIDATE_NOT_NULL_MESSAGE);
    }
    public void validate(Object value, String message){
        if(value==null){
            throw new IllegalArgumentException(message);
        }
    }
}
