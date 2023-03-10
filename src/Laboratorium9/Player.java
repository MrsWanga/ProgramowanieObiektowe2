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
        setAge(age);
        setNumber(number);
        setPosition(position);
    }

    public Player(Player player){
        super(player);
        setNumber(player.getNumber());
        setAge(player.getAge());
        setPosition(player.getPosition());
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

    @Override
    public String toString() {
        return "Player{" +
                "number=" + number +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
