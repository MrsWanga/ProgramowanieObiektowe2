package Laboratorium9;

public class main {
    public static void main(String[] args) {
        Dates dates = new Dates(TeamRepository.getInstance());
        dates.exampleDates();

        System.out.println(Team.getInstance());
    }
}
