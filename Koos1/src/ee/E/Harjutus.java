package ee.E;

import java.util.Random;
import java.util.Scanner;

public class Harjutus {

    public static void main(String[] args) {


        final int KYMME = 10;


        int[][] arvud = new int[KYMME][KYMME];

        //täida juhuslike arvudega (0...100 excl)
        Random r = new Random();
//        r.nextInt(100);
//
//        int juhuslik = 0;

        for (int i = 0; i < KYMME; i++)
            for (int j = 0; j < KYMME; j++) {
                arvud[i][j] = r.nextInt(100);
            }

        for (int i = 0; i < KYMME; i++) {
            for (int j = 0; j < KYMME; j++) {
                System.out.printf("%s\t", arvud[i][j]);
            }
            System.out.println();
        }
            Scanner input = new Scanner(System.in);

            System.out.print("anna üks arv: ");
            int otsitav = input.nextInt();
//            System.out.println(otsitav);

        // NB!!! booleaniga kas pole ühtki numrit
        boolean leitud = false;
            for (int i = 0; i < KYMME; i++) {
                for (int j = 0; j < KYMME; j++) {
                    if (arvud[i][j] == otsitav) {
                        leitud = true;
                        System.out.printf("leidsin %s reast %s ja veerust %s%n", otsitav, i, j);
                    }


//        for (int i = 0; i < 100; i++) {
//            for (int j = 0; j < arvud[i].length; j++) {
//                System.out.printf("%s");
//                arvud[i][j] = r.nextInt(100);
            }

        }
        if(leitud == false) System.out.println("ei leidnud");
//            see tegelt paremgi: if(!leitud) System.out.println("ei leidnud");

//        for (int i = 0; i < KYMME; i++);


//            double juhus = Math.random();
//            int juhuslik = (int) (Math.random() * 100);
//            System.out.println((juhus));
//        }
//
//
//        if (args.length > 0) {
//

    }
}


