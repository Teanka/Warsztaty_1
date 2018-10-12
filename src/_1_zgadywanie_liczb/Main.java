package _1_zgadywanie_liczb;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        guess();
    }

    private static void guess() {
        Random random = new Random();
        int intToGuess = random.nextInt(100) + 1;
        int counter = 1;
        while(true) {
            System.out.println("Zgadnij liczbę: ");
            while (!scanner.hasNextInt()) {
                System.out.println("To nie była prawidłowa liczba, spróbuj jeszcze raz");
                scanner.nextLine();
            }
            int temp = scanner.nextInt();
            scanner.nextLine();
            if(temp>100||temp<1){
                System.out.println("Powinieneś podać liczbę z zakresu 1-100");
            } else if(temp>intToGuess){
                System.out.println("Za dużo!");
                counter++;
            } else if(temp<intToGuess){
                System.out.println("Za mało!");
                counter++;
            } else if(temp==intToGuess){
                System.out.println("Brawo, zgadłeś w " + counter + " ruchach.");
                break;
            }
        }
    }
}

