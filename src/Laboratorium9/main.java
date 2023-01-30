package Laboratorium9;

import java.sql.SQLOutput;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        Team team = null;
        try {
            team = new Team(new TeamRepository("db1.dat"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } catch (TeamRepository.IORepositoryException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(team.getAll());
        try {
            boolean result;
            result = team.add(new Player("Mateusz", "Kowalski", "95030788437", 1,
                    Calendar.getInstance().get(Calendar.YEAR) -
                            PeselValidator.getInstance().getBirthYear("95030788437"), "goalkeeper"));

            if (result == false) {
                System.out.println("Nie udało się zapisać użytkownika");
            }
            result = team.add(new Player("Patryk", "Zawadzki", "00300332612", 2,
                    Calendar.getInstance().get(Calendar.YEAR) -
                            PeselValidator.getInstance().getBirthYear("00300332612"), "defender"));
            if (result == false) {
                System.out.println("Nie udało się zapisać użytkownika");
            }

            result = team.add(new Player("Ireneusz", "Świderski", "92091847251", 3,
                    Calendar.getInstance().get(Calendar.YEAR) -
                            PeselValidator.getInstance().getBirthYear("92091847251"), "midfielder"));
            if (result == false) {
                System.out.println("Nie udało się zapisać użytkownika");
            }
            result = team.add(new TechnicalMember("Tomasz", "Rosik", "97072636378", "judge"));
            if (result == false) {
                System.out.println("Nie udało się zapisać użytkownika");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Wszyscy: ");
        team.getAll().forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Techniczni:");
        team.getTechnicals().forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Gracze:");
        team.getPlayers().forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Posortowane wg numeru pesel:");
        team.getSortedByPesel().forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------");

        //90071877858 - false
        //95030788437 - true
        String pesel = "95030788437";
        TeamMember tm = team.getMember(pesel);
        System.out.println(tm);
        if(tm!=null){
            tm.setName("Antoni");
        }

        System.out.println("Wszyscy: ");
        team.getAll().forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------");
        team.update(pesel,tm);
        team.remove(pesel);
        System.out.println("Wszyscy: ");
        team.getAll().forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------");

    }
}
