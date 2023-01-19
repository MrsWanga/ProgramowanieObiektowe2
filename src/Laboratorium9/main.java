package Laboratorium9;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        //tworzenie danych
        Dates dates = new Dates(TeamRepository.getInstance());
        dates.exampleDates();
        //wyświetlanie listy (zwrócenie listy wszystkich członków zespołu,)
        System.out.println(Team.getInstance());
        //zwrócenie członka zespołu o podanym numerze pesel
        System.out.println(Team.getInstance().getMember("92091364815"));
        //usunięcie zawodnika o podanym numerze pesel
        System.out.println(Team.getInstance().removeMember("92091364815"));
        System.out.println(Team.getInstance());
        //Wyświetlenie tylko zawodników
        Predicate<TeamMember> isPlayer = o -> {return o.getClass() == Player.class;};
        List<TeamMember> filteredPlayers = Team.getInstance().teamMemberList.stream().filter(isPlayer).collect(Collectors.toList());
        filteredPlayers.forEach(System.out::println);
        //wyświetlenie tylko technicznych
        Predicate<TeamMember> isTechnical = o -> {return o.getClass() == TechnicalMember.class;};
        List<TeamMember> filteredTechnicals = Team.getInstance().teamMemberList.stream().filter(isTechnical).collect(Collectors.toList());
        filteredTechnicals.forEach(System.out::println);
    }
}
