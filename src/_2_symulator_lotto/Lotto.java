package _2_symulator_lotto;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        symulatorLotto();
    }

    static void symulatorLotto() {
        int counter = 0;
        int[] arr = new int[6];
        while (counter < 6) {
            System.out.println("Zgadnij liczbę: ");
            while (!scanner.hasNextInt()) {
                System.out.println("To nie była prawidłowa liczba, spróbuj jeszcze raz");
                scanner.nextLine();
            }
            int temp = scanner.nextInt();
            scanner.nextLine();
            if (temp > 49 || temp < 1) {
                System.out.println("Powinieneś podać liczbę z zakresu 1-100");
            } else {
                boolean flag = true;

                for (int j = 0; j < arr.length; j++) {
                    if (temp == arr[j]) {
                        System.out.println("Ta liczba już była, podaj nową liczbę.");
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    arr[counter] = temp;
                    counter++;
                }
            }
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Random random = new Random();
        int arr1[] = new int[6];
        int temp;
        for (int i = 0; i < arr1.length; i++) {
            temp = random.nextInt(48);
            temp=temp+1;
            for (int j = 0; j < i; j++) {
                if (temp == arr1[j]) {
                    break;
                }else{
                    arr1[i] = temp;
                }
            }
        }
        Arrays.sort(arr1);
        System.out.println("Wylosowane numery to: " + Arrays.toString(arr1));
        counter =0;
        for(int i =0; i<arr.length; i++){
            for(int j =0; j<arr1.length; j++){
                if(arr[i]==arr1[j]){
                    counter++;
                }
            }
        }
        if(counter>=3){
            System.out.println("Gratulacje! Trafiłeś " + counter + "liczb!");
        } else {
            System.out.println("Niestety, tym razem nie udało Ci się wygrać. Spróbuj jeszcze raz.");
        }

    }
}
//Arrays.shuffle