package ee.E;
import ee.Ro.*;

public class Main {

    public static void main(String[] args) {
        int arv = Integer.parseInt(args[0]);
//
//        if (arv % 2 == 0) {
//            System.out.printf("Arv %s on paaris \n", arv);
//        }  else {
//            System.out.printf("Arv %s on paaritu\n", arv);
//        }
        System.out.printf("Arv %s on %sarv", arv, arv % 2 == 0 ? "paaris" : "paaritu");
    }
}


// ühe avaldisena: System.out.printf("Arv %s on %sarv", arv, arv % 2 == 0 ? "paaris":"paaritu")
