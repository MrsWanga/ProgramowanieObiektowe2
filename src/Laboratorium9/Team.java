package Laboratorium9;


import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Predicate;

import static java.lang.Long.parseLong;

public class Team extends TeamRepository {
    LinkedList<TeamMember> teamMemberList;
    private static final Team INSTANCE = new Team();
    public static Team getInstance(){ return INSTANCE;}

    public Team() {
        this.teamMemberList=new LinkedList<TeamMember>();
    }

    public LinkedList<TeamMember> getPlayers(){
        Predicate<TeamMember> isPlayer = o -> o instanceof Player;
        return TeamRepository.getInstance().filter(isPlayer);
    }

    public LinkedList<TeamMember> getTechnicals(){
        Predicate<TeamMember> isTechnical = o -> o instanceof TechnicalMember;
        return TeamRepository.getInstance().filter(isTechnical);
    }
    public TeamMember getMember(String pesel){
        Predicate<TeamMember> isSearchedMember = o -> o.pesel.equals(pesel);
        return TeamRepository.getInstance().get(pesel);
    }

    public boolean removeMember(String pesel){
        if(TeamRepository.getInstance().remove(getMember(pesel))){
            System.out.printf("Poprawnie usunięto członka zespołu o numerze pesel "+ pesel);
            return true;
        }else {
            System.out.println("Nie mozna usunąć członka zespołu o numerze pesel "+pesel);
            return false;
        }
    }

    public boolean updateMember(String pesel, TeamMember tm){
        if(TeamRepository.getInstance().update(getMember(pesel), tm)){
            System.out.printf("Poprawnie zaktualizowano członka zespołu o numerze pesel "+ pesel);
            return true;
        }else {
            System.out.println("Nie mozna zaktualizować członka zespołu o numerze pesel "+pesel);
            return false;
        }
    }

//    public void sort(){
//        Collections.sort(TeamRepository.getInstance().getAll(),new PeselComparator() );
//        for (TeamMember tm:TeamRepository.getInstance().getAll()) {
//            System.out.println(" " +tm);
//        }
//    }

    class PeselComparator implements Comparator<TeamMember> {

        @Override
        public int compare(TeamMember a, TeamMember b) {
            long peselA = parseLong(a.getPesel());
            long peselB = parseLong(b.getPesel());
            return peselA < peselB ? -1 : peselA == peselB ? 0 : 1;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<this.teamMemberList.size(); i++){
            sb.append(this.teamMemberList.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}
