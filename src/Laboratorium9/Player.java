package Laboratorium9;

public class Player extends TeamMember{
    private int number;
    private int age;
    private String position;

    Player(String name,
           String surname,
           String pesel,
           int number,
           int age,
           String position) {
        super(name, surname, pesel);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
