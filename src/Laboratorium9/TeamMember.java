package Laboratorium9;

import java.util.Objects;

public abstract class TeamMember {
    String name;
    String surname;
    String pesel;

    TeamMember(String name, String surname, String pesel){
        this.name=name;
        this.surname=surname;
        this.pesel=pesel;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!Validator.getInstance().isNull(name)){
            if(Validator.getInstance().onlyLettersValidator(name)){
                this.name = name;
            }else {
                System.out.println("Imię może się składać tylko z małych i dużych liter oraz spacji");
            }
        }else{
            System.out.println("Imię nie może być puste");
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if(!Validator.getInstance().isNull(surname)){
            if(Validator.getInstance().onlyLettersValidator(surname)){
                this.surname = surname;
            }else {
                System.out.println("Nazwisko może się składać tylko z małych i dużych liter oraz spacji");
            }
        }else{
            System.out.println("Nazwisko nie może być puste");
        }

    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        if (Validator.getInstance().isCorrectPesel(pesel)){
            this.pesel = pesel;
        }else{
            System.out.println("Podano nbiepoprawny numer pesel");
        }
    }

    public int compareTo(TeamMember tm){
        return this.getPesel().compareTo(tm.getPesel());
    }

    public boolean equals(TeamMember tm){
       return this.getPesel().equals(tm.getPesel());
    }

    public int hashCode() {
        return Objects.hash(pesel);
    }

}
