package Laboratorium9;
import Laboratorium8.Validator;
import java.util.LinkedList;
import java.util.function.Predicate;

public class TeamRepository implements RepositoryInterface{
    private static final TeamRepository INSTANCE = new Team();
    public static TeamRepository getInstance(){ return INSTANCE;}
    @Override
    public boolean add(Object object) {
        TeamMember tm = (TeamMember)object;
        if (Team.getInstance().teamMemberList.contains(tm.getPesel())){
            System.out.println("W zespole jest już osoba o takim numerze pesel.");
        }
        return Team.getInstance().teamMemberList.add(tm);
    }

    @Override
    public boolean update(Object oldValue, Object newValue) {
        TeamMember tm=null;
        if(Team.getInstance().teamMemberList.contains(oldValue)){
            try{
                tm = (TeamMember) newValue;
            }catch(Exception e){
                System.out.println("Blad: nowy obiekt nie jest klasy TeamMember" +e);
                return false;
            }

            try{
                int index=Team.getInstance().teamMemberList.indexOf(oldValue);
                Team.getInstance().teamMemberList.remove(index);
                Team.getInstance().teamMemberList.add(index,tm);
                System.out.println(Team.getInstance());
                return true;
            }catch(Exception e) {
                System.out.println("Blad: Nie można zaktualizować obiektu." +e);
                return false;
            }
        }else{
            System.out.print("Nie ma takiego obiektu");
            return false;
        }
    }

    @Override
    public LinkedList<TeamMember> getAll() {
        return Team.getInstance().teamMemberList;
    }

    public TeamMember get(String  pesel) {
        TeamMember tm=null;
        for ( int i=0; i<Team.getInstance().teamMemberList.size(); i++){
            if (Team.getInstance().teamMemberList.get(i).pesel.equals(pesel) ) {
                tm=Team.getInstance().teamMemberList.get(i);
            }
        }
        if(Validator.getInstance().isNull(tm)){
            System.out.print("Nie ma członka zespołu o takim numerze pesel");
            return null;
        }else{
            return tm;
        }
    }

    @Override
    public LinkedList<TeamMember> filter(Predicate predicate) {
        LinkedList<TeamMember> newList = Team.getInstance().teamMemberList;
        for ( int i=0; i<Team.getInstance().teamMemberList.size(); i++){
            if (predicate.test(Team.getInstance().teamMemberList.get(i))) {
                newList.add(Team.getInstance().teamMemberList.get(i));
            }
        }
        return newList;
    }

    @Override
    public boolean remove(Object object) {
        TeamMember tm = (TeamMember) object;
        System.out.println(tm);
        if(Team.getInstance().teamMemberList.contains(tm)){
            Team.getInstance().teamMemberList.remove(Team.getInstance().teamMemberList.indexOf(object));
            return true;
        }else{
            System.out.print("Nie ma takiego obiektu");
            return false;
        }
    }
}
