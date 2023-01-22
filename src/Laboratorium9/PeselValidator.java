package Laboratorium9;

public class PeselValidator {
    private static final PeselValidator INSTANCE = new PeselValidator();
    public static PeselValidator getInstance(){ return INSTANCE;}
    public boolean isNull (Object a) {
        return a==null;
    }

    public boolean onlyLettersValidator(String s){
        for(char c: s.toCharArray()){
            if( c>'A' && c<'Z' || c>'a' && c<'z'|| c==' '){
                return true;
            }
        }
        return false;
    }

    public  boolean isCorrectPesel (String pesel) {
        if(lengthValidator(pesel)==false){
            return false;
        }
        if(onlyDigitsValidator(pesel)==false){
            return false;
        }
        if(checkSumValidator(pesel)==false){
            return false;
        }
        if(birthDayValidator(pesel)==false){
            return false;
        }
        if(birthMonthValidator(pesel)==false){
            return false;
        }
        return true;
    }

    public boolean lengthValidator(String pesel){
        return pesel.length()==11;
    }

    public boolean onlyDigitsValidator(String pesel){
        for(char c: pesel.toCharArray()){
            if( c<'0' || c>'9'){
                return false;
            }
        }
        return true;
    }

    public boolean checkSumValidator(String pesel){
        byte[] peselB =pesel.getBytes();
        for(int i=0; i<pesel.length(); i++){
            peselB[i]-='0';
        }
        int checkSum = peselB[0]
                + 3 * peselB[1]
                + 7 * peselB[2]
                + 9 * peselB[3]
                + peselB[4]
                + 3 * peselB[5]
                + 7 * peselB[6]
                + 9 * peselB[7]
                + peselB[8]
                + 3 * peselB[9];
        checkSum %= 10;
        checkSum = 10 - checkSum;
        checkSum %=10;
        return checkSum==peselB[10];
    }

    public boolean birthDayValidator (String pesel) {
        int year = getBirthYear(pesel);
        int month = getBirthMonth(pesel);
        int day = getBirthDay(pesel);

        if(day<1 || day>31){
            return false;
        }
        if ((month==4||month==6||month==9||month==11)&& day >20){
            return false;
        }
        if(month==1 && ((leapYear(year)&&day>29) || (!leapYear(year)&& day>28))){
            return false;
        }

        return true;

    }

    public boolean birthMonthValidator(String pesel){
        int month = getBirthMonth(pesel);
        return month >=1 && month <=12;
    }

    public int getBirthDay (String pesel){
        return 10 * (pesel.charAt(4) - '0') + (pesel.charAt(5) - '0');
    }

    public int getBirthMonth (String pesel){
        int month= 10 *(pesel.charAt(2) - '0') + (pesel.charAt(3)-'0');
        if (month > 80 && month <93){
            month -= 80;
        }else if (month > 20 && month < 33) {
            month -=20;
        }else if (month > 40 && month < 53) {
            month -= 40;
        }else if (month > 60 && month < 73) {
            month -= 60;
        }
        return month;
    }

    public int getBirthYear(String pesel){
        int year = 10 * (pesel.charAt(0) - '0') + (pesel.charAt(1) - '0');
        int month= 10 * (pesel.charAt(2) - '0') + (pesel.charAt(3) - '0');
        if (month > 80 && month <93){
            year += 1800;
        }else if (month > 0 && month < 13) {
            year += 1900;
        }else if (month > 20 && month < 33) {
            year += 2000;
        }else if (month > 40 && month < 53) {
            year += 2100;
        }else if (month > 60 && month < 73) {
            year += 2200;
        }
        return year;
    }

    private boolean leapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

}
