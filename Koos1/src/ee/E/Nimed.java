package ee.E;

import java.util.Scanner;

public class Nimed {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] nimed = {"Henn", "Ants", "Peeter", "Joosep"};

        System.out.print("anna üks nimi: ");
        String nimi = scan.nextLine();
        int ebakohased = 0;

        for (int i = 0; i < nimed.length; i++) {
            String nimekN = nimed[i];

            if (nimekN.equalsIgnoreCase(nimi)) {
                String nummer = Integer.toString(i + 1);
                System.out.println(nimi + " on nimekirjas " + nummer + ".");
                ebakohased = i;
            }
        }
        if (ebakohased == 0) {
            System.out.println("Seda nime pole listis.");
        }
    }
}

// paremklõpsuga refactor, rename - saab mugavalt muutujaid ümber nimetada