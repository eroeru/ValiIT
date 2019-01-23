package ee.E;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {


        //kui seda järgnevat või failistLugemine("proov.txt" ja lihtsalt public static void failistLugemine(String failinimi throws exception { Scanner scan = new Scanner(new File(failinimi));
        //jne teha ilma try-ta, siis ei saa teha, try-ga saab


//        try {
//            Scanner scan = new Scanner(new File("proov.txt"));
//            while (scan.hasNext()) {
//                System.out.println(scan.nextLine());
//            }
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//            }}}


        Scanner scan = new Scanner(System.in); //praegu ei õiendanud, aga kui teha Scanner scan = new Scanner(new File("proov")); - siis jama
        //reegel selline, et kõik asjad, mille kasutamisel teada, et võib juhtuda mingi asi, peab olema valmis et selline asi juhtub



        while (true) {
            // lõpmatu tsükkel, täpselt samamoodi nagu for (;;) -  selleks et jääks küsima

            try {
            System.out.println("Anna üks arv: ");

            int i = scan.nextInt();


            System.out.println("Anna teine arv: ");

            int j = scan.nextInt();


            // try; catch; final. tryga tavapäraseida toimetusi; catchi tavaolukorras ei täideta, aint kui miskit läks valesti; finali unustame hetkel
            // kõik asjad mis võivad valesti minna võiks try bloki sisse minna (scõupi venitada - algselt oli try siin:), k.a. kõik siin while(true) blokis olev. muidu annaks näiteks sõnade peale punast, aga try all ei anna
            // siis tuleks ilmselt break; catch lõppu panna



                System.out.printf("Jagatis on %s %n", i / j);

            } catch(ArithmeticException e) {
                System.out.println("nii jagada ei saa");
                System.out.println(e.getMessage());
            }


            catch(InputMismatchException e) {
                System.out.println("ära lollita");
                System.out.printf("Sa sisestasid: %s%n", scan.nextLine());
            }

//eespool peab olema more specific exception type, muidu sinna teisele ei jõuagi, spetsiifilisem muutub mõttetuks

            catch (Exception e) {   // e on muutuja. exception tüüpi. Exception asemel võib olla ArithmeticException, sel juhul muu punase (nt sõnad) viskab punaseks.
                // võib olla InputMismatchException e - s.o. et ei ole arv tüüpi se in j
                // kui tahta lisainfot, siis println(e.getMessage()); println(e.getClass().getName()
                // InputException e võib järgi küsida "ära lollida ln ja printf "Sa sisestasid: %s%n", scan.nextLine() - tuleb "ära lollita - Sa sisestasid: loll
                System.out.println("midagi juhtus");
                System.out.println(e.getMessage());
                System.out.println(e.getClass().getName());
                break;
            } finally {
                //see osa täidetakse igal juhul, ka siis kui midagi juhtus
                System.out.println("tehtud");
            }


        }

//    seda järgnevat ega eelmise copyt main2-na pole nõus käima panema
//    public static void teineasi() {
//
//
//    }


    }
}

