package Laboratorium9;

public class Player extends TeamMember{
    int number;
    int age;
    String position;

    Player(String name,
           String surname,
           String pesel,
           int number,
           int age,
           String position) {
        super(name, surname, pesel);
    }
}
