package Laboratorium9;


import java.util.*;
import java.util.function.Predicate;

import static java.lang.Long.parseLong;

public class Team{
    protected final RepositoryInterface<TeamMember> repository;
//    LinkedList<TeamMember> teamMemberList;
//    private static final Team INSTANCE = new Team(repository);
//    public static Team getInstance(){ return INSTANCE;}
    public static class ValidationError {
        public final static String REPOSITORY_MESSAGE = "Należy wskazać repozytorium";
        public final static String PESEL_MESSAGE = "Należy wskazać repozytorium";
}
    public Team(RepositoryInterface<TeamMember> repository) {
        NotNullValidator.getInstance().validate(repository, ValidationError.REPOSITORY_MESSAGE);
        this.repository = repository;

    }

    public boolean add(TeamMember tm) throws Exception {
        if (repository.getAll().contains(tm.pesel)){
            throw new Exception(ValidationError.PESEL_MESSAGE);
        }
        return repository.add(tm);
    }

    public List<TeamMember> getAll(){
        return repository.getAll();
    }

    public List<TeamMember> getSortedByPesel (){
        TreeSet<TeamMember> sortedResult = new TreeSet<>(
                Comparator.naturalOrder()
        );
        sortedResult.addAll(repository.getAll());
        return List.copyOf(sortedResult);
    }

    public List<TeamMember> getPlayers(){
        Predicate<TeamMember> isPlayer = o -> o instanceof Player;
        return repository.filter(isPlayer);
    }

    public List<TeamMember> getTechnicals(){
        Predicate<TeamMember> isTechnical = o -> o instanceof TechnicalMember;
        return repository.filter(isTechnical);
    }
    public TeamMember getMember(String pesel){
        Predicate<TeamMember> isSearchedMember = o -> o.pesel.equals(pesel);

        for(TeamMember tm: repository.getAll()){
            if (isSearchedMember.test(tm)){
                return tm;
            }
        }
        return null;
    }

    public boolean update(String pesel, TeamMember newValue){
        TeamMember tm = getMember(pesel);
        if (tm == null){
            return false;
        }
        return repository.update(tm, newValue);
    }

    public boolean remove(String pesel){
        TeamMember tm = getMember(pesel);
        if (tm == null){
            return false;
        }
        return repository.remove(tm);
    }


//    class PeselComparator implements Comparator<TeamMember> {
//
//        @Override
//        public int compare(TeamMember a, TeamMember b) {
//            long peselA = parseLong(a.getPesel());
//            long peselB = parseLong(b.getPesel());
//            return peselA < peselB ? -1 : peselA == peselB ? 0 : 1;
//        }
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        for (int i=0; i<this.teamMemberList.size(); i++){
//            sb.append(this.teamMemberList.get(i));
//            sb.append("\n");
//        }
//        return sb.toString();
//    }
}
