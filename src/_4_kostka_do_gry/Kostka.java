package _4_kostka_do_gry;

import java.util.Random;

public class Kostka {

    public static void main(String[] args) {
        kostka("3D6+2");
        kostka("D20");
        kostka("10D12-100");
        kostka("100D100-200");
    }

    static void kostka(String jakieRzuty) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (int i = jakieRzuty.indexOf('D') + 1; i < jakieRzuty.length(); i++) {
            if (!Character.isDigit(jakieRzuty.charAt(i))) {
                break;
            } else {
                sb.append(jakieRzuty.charAt(i));
                counter = i;
            }
        }
        int rodzajKostki = Integer.parseInt(sb.toString());
        sb.setLength(0);
        for (int i = 0; i < jakieRzuty.length() - 1; i++) {
            if (czyCharJestCyfra(jakieRzuty, sb, i)) break;
        }
        int iloscRzutow = 0;
        if (sb.length() != 0) {
            iloscRzutow = Integer.parseInt(sb.toString());
        } else {
            iloscRzutow = 1;
        }
        sb.setLength(0);
        int modyfikatorRzutu = 0;
        boolean plus = false;
        if (jakieRzuty.length() > counter+1) {
            if (jakieRzuty.charAt(counter + 1) == '+') {
                counter++;
                plus = true;
                for (int i = counter + 1; i < jakieRzuty.length(); i++) {
                    if (czyCharJestCyfra(jakieRzuty, sb, i)) break;
                }
            } else if (jakieRzuty.charAt(counter + 1) == '-') {
                counter++;
                for (int i = counter + 1; i < jakieRzuty.length(); i++) {
                    if (czyCharJestCyfra(jakieRzuty, sb, i)) break;
                }
            }
        }
        if (sb.length() != 0) {
            modyfikatorRzutu = Integer.parseInt(sb.toString());
        }
        Random random = new Random();
        int iloscOczek = random.nextInt(rodzajKostki) + 1;
        if (plus) {
            System.out.println("Wynik rzutu to: " + (iloscOczek * iloscRzutow + modyfikatorRzutu));
        }else{
            int wynik = iloscOczek*iloscRzutow-modyfikatorRzutu;
            if(wynik<0){
                wynik=0;
            }
            System.out.println("Wynik rzutu to: "+wynik);
        }

    }

    private static boolean czyCharJestCyfra(String jakieRzuty, StringBuilder sb, int i) {
        if (!Character.isDigit(jakieRzuty.charAt(i))) {
            return true;
        } else {
            sb.append(jakieRzuty.charAt(i));
        }
        return false;
    }
}
