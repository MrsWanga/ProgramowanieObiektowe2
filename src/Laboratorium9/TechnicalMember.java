package Laboratorium9;

public class TechnicalMember extends TeamMember{
    private String role;
    TechnicalMember(String name, String surname, String pesel) {
        super(name, surname, pesel);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
