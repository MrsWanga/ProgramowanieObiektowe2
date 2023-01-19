package Laboratorium9;

import Laboratorium8.List;

import java.util.LinkedList;

public class Sort {
    int listSize;
    LinkedList<TeamMember> list;
    private static final Sort INSTANCE = new Sort();
    public static Sort getInstance(){ return INSTANCE;}

    public Sort() {
        this.list = Team.getInstance().teamMemberList;
        listSize =list.size() ;
    }

    public LinkedList<TeamMember> sortAscending(List<TeamMember> list) {
        long value;
        int  j;
        for (int i = 1; i < listSize; i++) {
            j = i;
            TeamMember tm = list.get(i);
            String val =  list.get(i).pesel;
            value = Long.parseLong(val);
            while (j > 0 && Long.parseLong(list.get(i-1).pesel)> value) {
                System.out.println(list.get(j));
                System.out.println(list.get(j-1));
                TeamRepository.getInstance().update(list.get(j), list.get(j-1));
                j--;
            }
            TeamRepository.getInstance().update(list.get(j), tm);
        }
        return TeamRepository.getInstance().getAll();
    }

    public LinkedList<TeamMember> sortTabAscending() {
        LinkedList<TeamMember> l = Team.getInstance().teamMemberList;
        TeamMember temp;
        int change = 1;
        while (change > 0) {
            change = 0;
            for (int i = 0; i < l.size() - 1; i++) {
                if (Long.parseLong(l.get(i).pesel) > Long.parseLong(l.get(i + 1).pesel)) {
                    temp = l.get(i+1);
                    TeamRepository.getInstance().update(l.get(i+1),l.get(i));
                    TeamRepository.getInstance().update(l.get(i),temp);
                    change++;
                }
            }
        }
        return l;
    }

//    private void quicksortUp(int low, int high) {
//        int i = low, j = high;
//        // Ustawienie pivota na środku
//        int pivot = list.get(low + (high - low) / 2);
//
//        while (i <= j) {
//            // Jeżeli wartość na lewo jest mniejsza od pivota, idź dalej
//            while (tab[i] < pivot) {
//                i++;
//            }
//            // Jeżeli wartość na prawo jest większa od pivota, idź dalej
//            while (tab[j] > pivot) {
//                j--;
//            }
//            //Jeżeli wartość na prawo jest mniejsza od pivota, lub wartość na lewo jest większa od pivota, to zamień
//            if (i <= j) {
//                exchange(i, j);
//                i++;
//                j--;
//            }
//        }
//        // Recursion
//        if (low < j)
//            quicksortUp(low, j);
//        if (i < high)
//            quicksortUp(i, high);
//    }
//
//    private void quicksortDown(int low, int high) {
//        int i = low, j = high;
//        // Ustawienie pivota na środku
//        int pivot = tab[low + (high - low) / 2];
//
//        while (i <= j) {
//            // Jeżeli wartość na lewo jest większa od pivota, idź dalej
//            while (tab[i] > pivot) {
//                i++;
//            }
//            // Jeżeli wartość na prawo jest mniejsza od pivota, idź dalej
//            while (tab[j] < pivot) {
//                j--;
//            }
//            //Jeżeli wartość na prawo jest większa od pivota, lub wartość na lewo jest mniejsza od pivota, to zamień
//            if (i <= j) {
//                exchange(i, j);
//                i++;
//                j--;
//            }
//        }
//        // Recursion
//        if (low < j)
//            quicksortDown(low, j);
//        if (i < high)
//            quicksortDown(i, high);
//    }
//
//    private void exchange(int i, int j) {
//        int temp = tab[i];
//        tab[i] = tab[j];
//        tab[j] = temp;
//    }
//    public String getTitle (){
//        return"Sortowanie szybkie:";
//    }
//    public String getTime (){
//        return"Czas wykonania algorytmu sortowania szybkiego:";
//    }
//
//    public String toString() {
//        String toString = "";
//        for (int i = 0; i < listSize; i++) {
//            toString += tab[i] + " ";
//        }
//        return toString;
//    }
}
