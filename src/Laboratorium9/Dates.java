package Laboratorium9;

import java.util.Date;

public class Dates {
    TeamRepository teamRepository;
    Date today = new Date();

    public Dates(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void exampleDates() {

        Player a = new Player("Mateusz", "Kowalski", "95030788437", 1, today.getYear()-Validator.getInstance().getBirthYear("95030788437"), "goalkeeper");
        Player b = new Player("Patryk", "Zawadzki", "00300332612", 2, today.getYear()-Validator.getInstance().getBirthYear("00300332612"), "defender");
        Player c = new Player("Ireneusz", "Świderski", "92091847251", 3, today.getYear()-Validator.getInstance().getBirthYear("92091847251"), "midfielder");
        Player d = new Player("Konrad", "Nowak", "01253046416", 4, today.getYear()-Validator.getInstance().getBirthYear("01253046416"), "forward");
        Player e = new Player("Sebastian", "Matusiak", "04221739897", 5, today.getYear()-Validator.getInstance().getBirthYear("04221739897"), "midfielder");
        Player f = new Player("Klaudiusz", "Maciak", "03261516778", 6, today.getYear()-Validator.getInstance().getBirthYear("03261516778"), "defender");
        Player g = new Player("Marcin", "Kwaśniewski", "97011866437", 7, today.getYear()-Validator.getInstance().getBirthYear("97011866437"), "midfielder");
        Player h = new Player("Gabriel", "Stasiak", "92090573737", 8, today.getYear()-Validator.getInstance().getBirthYear("92090573737"), "defender");
        Player i = new Player("Igor", "Kolasiński", "92091364815", 9, today.getYear()-Validator.getInstance().getBirthYear("92091364815"), "defender");
        Player j = new Player("Jan", "Domagała", "90071877858", 10, today.getYear()-Validator.getInstance().getBirthYear("90071877858"), "midfielder");
        Player k = new Player("Franciszek", "Garcarek", "96010882815", 11, today.getYear()-Validator.getInstance().getBirthYear("96010882815"), "forwards");
        TechnicalMember l = new TechnicalMember("Tomasz", "Rosik", "97072636378", "judge");
        TechnicalMember m = new TechnicalMember("Zofia", "Rosik", "92090167181", "sponsor");
        this.teamRepository.add(a);
        this.teamRepository.add(b);
        this.teamRepository.add(c);
        this.teamRepository.add(d);
        this.teamRepository.add(e);
        this.teamRepository.add(f);
        this.teamRepository.add(g);
        this.teamRepository.add(h);
        this.teamRepository.add(i);
        this.teamRepository.add(j);
        this.teamRepository.add(k);
        this.teamRepository.add(l);
        this.teamRepository.add(m);
    }

}
