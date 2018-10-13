package _3_zgadywanie_liczb;

import java.util.Scanner;

public class Zgaduj {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        zgaduj();
    }

    static void zgaduj() {
        System.out.println("Pomyśl liczbę z zakresu 1 do 1000, \n " +
                "a komputer ją zgadnie w minimum 10 ruchach.\n" +
                "Naciśnij dowolny przycisk, gdy wybierzesz liczbę:");
        scanner.nextLine();
        int min = 0;
        int max = 1001;
        int number;
        boolean flag = true;
        boolean flag1;
        while (flag) {
            int guess = (max - min) / 2 + min;
            System.out.println("Zgaduję: " + guess + "\n ");
            flag1=true;
            while(flag1) {
                System.out.println("Teraz wybierz opcję: " +
                        "\n 1 - Za dużo; " +
                        "\n 2- Za mało; " +
                        "\n 3- Zgadłeś!");
                while (!scanner.hasNextInt()) {
                    System.out.println("To nie była prawidłowa liczba, spróbuj jeszcze raz");
                    scanner.nextLine();
                }
                number = scanner.nextInt();
                scanner.nextLine();
                if (number < 1 || number > 3) {
                    System.out.println("Nie podałeś numeru 1-3.");
                }
                switch (number) {
                    case 1:
                        max = guess;
                        flag1 = false;
                        break;
                    case 2:
                        min = guess;
                        flag1 = false;
                        break;
                    case 3:
                        System.out.println("Wygrałem!");
                        flag = false;
                        flag1 = false;
                        break;

                }
            }

        }
        scanner.close();
    }
}
