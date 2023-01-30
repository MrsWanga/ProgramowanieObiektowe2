package Laboratorium9;
import Laboratorium8.Validator;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class TeamRepository implements RepositoryInterface<TeamMember>{

    protected LinkedHashSet<TeamMember> data;
    protected String fileName;

    public static class IORepositoryException extends RuntimeException{
        public IORepositoryException(String message){
            super(message);
        }
    }
    static class ValidationError{
        public static final String FILE_NAME ="Nie podano nazwy pliku dla repozytorium";
        public static final String IN_EXCEPTION ="Błąd odczytu danych z pliku";
        public static final String OUT_EXCEPTION ="Błąd zapisu danych do pliku";
        public static final String CLASS_NOT_FOUND_EXCEPTION ="Błędny format";
    }

    public TeamRepository(String fileName) throws IllegalArgumentException{
        RequiredStringValidator.getInstance().validate(fileName,ValidationError.FILE_NAME);
        this.fileName=fileName;
        try{
             read();
        }catch (IORepositoryException e){
            System.out.println(e.getMessage());
        }
    }
    protected void read() throws IORepositoryException{
        data = new LinkedHashSet<>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName));
            data = (LinkedHashSet<TeamMember>)input.readObject();
            input.close();
        }catch (IOException e){
            throw new IORepositoryException(ValidationError.IN_EXCEPTION);
        }catch (ClassNotFoundException e){
            throw new IORepositoryException(ValidationError.CLASS_NOT_FOUND_EXCEPTION);
        }
    }

    public void save() throws IORepositoryException{
        try{
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));
            output.writeObject(data);
            output.close();
        }catch (IOException e){
            throw new IORepositoryException(ValidationError.OUT_EXCEPTION);
        }
    }
    @Override
    public boolean add(TeamMember object) {
        boolean result = data.add(object);
        if(result==true){
            try{
                save();
            }catch (IORepositoryException e){
                return false;
            }
        }
        return result;
    }

    @Override
    public boolean update(TeamMember oldValue, TeamMember newValue) {
        for(TeamMember tm:data){
            if(tm.equals(oldValue)){
                try{
                    save();
                }catch (IORepositoryException e){
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public List<TeamMember> getAll() {
         return List.copyOf(data);
    }

    @Override
    public List<TeamMember> filter(Predicate <TeamMember> predicate) {
        List<TeamMember> result = new ArrayList<>();
        for ( TeamMember tm : data){
            if (predicate.test(tm)) {
                result.add(tm);
            }
        }
        return result;
    }

    @Override
    public boolean remove(TeamMember object) {
        boolean result = data.removeIf( teamMember -> teamMember.equals(object));
        if(result==true){
            try {
                save();
            }catch (IORepositoryException e){
                return false;
            }
        }
        return result;
    }


}
