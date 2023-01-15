package Laboratorium9;

import java.util.Objects;

public abstract class TeamMember {
    String name;
    String surname;
    String pesel;

    TeamMember (String name, String surname, String pesel){
        this.name=name;
        this.surname=surname;
        this.pesel=pesel;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
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
