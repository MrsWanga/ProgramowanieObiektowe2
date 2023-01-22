package Laboratorium9;

public class TechnicalMember extends TeamMember{
    private String role;
    TechnicalMember(String name, String surname, String pesel, String role) {
        super(name, surname, pesel);
        setRole(role);
    }

    public TechnicalMember(TechnicalMember tm){
        super(tm);
        setRole(tm.getRole());
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "TechnicalMember{" +
                "role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
