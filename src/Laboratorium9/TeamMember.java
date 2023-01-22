package Laboratorium9;

import java.io.Serializable;
import java.util.Objects;

public abstract class TeamMember implements Serializable, Comparable<TeamMember> {
    String name;
    String surname;
    String pesel;

    static class ValidationError {
        public static final String NAME = "Imię jest wymagane";
        public static final String SURNAME = "Nazwisko jest wymagane";
        public static final String PESEL = "Pesel jest wymagany";
    }

    TeamMember(String name, String surname, String pesel){
        this.name=name;
        this.surname=surname;
        this.pesel=pesel;
    }

    public TeamMember(TeamMember tm){
        setName(tm.getName());
        setSurname(tm.getSurname());
        setPesel(tm.getPesel());
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        RequiredStringValidator.getInstance().validate(name, ValidationError.NAME);
        this.name=name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        RequiredStringValidator.getInstance().validate(surname, ValidationError.SURNAME);
        this.surname=surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        RequiredStringValidator.getInstance().validate(pesel, ValidationError.PESEL);
        if (PeselValidator.getInstance().isCorrectPesel(pesel)){
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
