package ee.E;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Array_List_Kodune {

    public static void main(String[] args) {


        List<Integer> pakk = new ArrayList<Integer>();
        //kuidas pakki täidan - on lihtsam - võta vahemik ja tee listiks
        for (int i = 0; i < 52; i++) pakk.add(i);

        for (int i = 0; i < 52; i++) {
            System.out.printf("%s\t", pakk.get(i));
            if (i % 13 == 12) System.out.println();
        }


        System.out.println();

        Random r = new Random();
        //for

        List<Integer> segatudPakk = new ArrayList<>();

        while (pakk.size() > 0) {
            int i = r.nextInt(pakk.size());
            segatudPakk.add(pakk.get(i));
            pakk.remove(i);
        }

        System.out.println("peale segamist:");
        //prindime uuesti välja
        for (int i = 0; i < 52; i++) {
            System.out.printf("%s %s", segatudPakk.get(i), (i % 13 == 12 ? "\n" : "\t"));

        }
    }
}



            // - alljärgnevad vanad paqid harjutuse lahendusread

//
//        int[] pakk = new int[52];
//        for (int i = 0; i < 52; i++) pakk[i] = i;
//
//        //prindime välja
//
//        for (int i = 0; i < 52 ; i++) {
//            System.out.printf("%s %s", pakk[i], (i%13==12 ? "\n" : "\t"));
//
//        }
//
//        //segame
//        // nö swapiga, aga ilma
//
//
//        Random r = new Random();
//        for (int i = 0; i < 1000; i++) {
//            int i1 = r.nextInt(52);
//            int i2 = r.nextInt(52);
//            int ajutine = pakk[i1];
//            pakk[i1] = pakk[i2];
//            pakk[i2] = ajutine;
//        }
//        System.out.println("peale segamist:");
//        // prindime uuesti välja
//        for (int i = 0; i < 52 ; i++) {
//            System.out.printf("%s %s", pakk[i], (i%13==12 ? "\n" : "\t")); // või kui jääk 0, siis lisada reavah, lihtsam? nagu:
//            // System.out.printf("%s\t", pakk[i];
//            // if (i % 13 == 12) System.out.println();
//        }
//    }
//
//
//
//}
