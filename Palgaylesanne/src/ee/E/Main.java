package ee.E;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    List<T66taja> workers = new ArrayList<>(); //static: selles klassis ainuke eksemplar, ja teistele staatilistele meetoditele kättesaadav

    public static void main(String[] args) {


//            try {                                                                     //try VAJALIK KUNA MUIDU VÕIKS OLLA FILENOTFOUND, ja ta tegelt ei võimalda jooksutada seda
//                    Scanner scan = new Scanner(new File("tyyandmed.txt"));
        //                    scan.close();                                             //close on siin vajalik! kuna muidu jääkski jooksma, mälu jookseks kokku
//            } catch (Exception e) {}

        //AGA! met teeme ilma close'ta, niiet auto-puhastaks:


//        if (args.length == 0) {
//            System.out.println("anna parameetrina faili nimi");
//            return;
//        }
//        try (Scanner scan = new Scanner(new File(args[0]))) {
//
//        } catch (Exception e) {                                                         //kokkuleppeline e
//            System.out.println(e.getMessage());
//        }

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        List<T66taja> workers = new ArrayList<>();


        //kuupäevade teisendamiseks oli meil vaja mida?
        //


        try {
            Scanner scan = new Scanner(new File("tyyandmed.txt"));            // NÜÜD CLOSE ÜLEARUNE! SEETÕTTU NÜÜDNE PAREM!
            while (scan.hasNext()) {
                String rida = scan.nextLine();

                /*
                kui mul vaja splittida koma järgi ridu, milles võib olla muutuv osa tükke
                siis üks kaval trikk, et ei peaks kontrollima mitu tükki tuli
                ja kas nad on tühjad, enne splittimist lisada sappa mõned komad
                siis on vaja kontrollida AINULT kas on tükk.length > 0
                 */

                String[] osad = (rida + ", , , ,").split(",");

                String nimi = osad[0].trim();
                double palk = Double.parseDouble(osad[1].trim());
                Date tuliTyyle = formatter.parse(osad[2].trim());


//                Date lahkusTyylt = null;
//                if (osad[3].length() > 0) {
//
//                    lahkusTyylt = formatter.parse(osad[3]);
//                }
//
//              workers.add(new T66taja(nimi, palk, tuliTyyle, lahkusTyylt));


                Date lahkusTyylt = osad[3].length() > 1
                        ? formatter.parse(osad[3]) : null;                  //parem!!!!!!! kui eelmine. elegents
                workers.add(new T66taja(nimi, palk, tuliTyyle, lahkusTyylt));


            }


        } catch (Exception e) {                                                         //kokkuleppeline e
            System.out.println(e.getMessage());


        }

        System.out.println("kõik töötajad");

        for (T66taja w : workers) System.out.println(w);


        //kes on lahkunud
        System.out.println("trükime kõik lahkunud");
        for (T66taja w : workers)
            if (w.left != null)
                System.out.println(w);
        workers.stream()
                .filter(x -> x.left != null)
                .forEach(System.out::println);


        System.out.print("Töötajate keskmine palk on: ");
        double summa = 0;

        int mitu = 0;
        for (var w : workers) {
            summa += w.salary;
            mitu++;
        }
        System.out.println(mitu == 0 ? 0 : (summa / mitu));
        var keskmine =
                workers.stream()
                        .mapToDouble(x -> x.salary)
                        .average()
                //.orElse(0.0));
                ;

        System.out.println(keskmine.orElse(0));

//        if (keskmine.isPresent()) System.out.println(keskmine.getAsDouble());
//        else System.out.println("Keskmist pole");


        // palgakokkuvõte
        //  leiame 1.7.2018 tööl olnute keskmise palga
        // kes olid tööl 1. juulil

        summa = 0;
        mitu = 0;

        try {
            var date = formatter.parse("01-07-2018");

            for (var w : workers) { // käib läbi kõik töötajad
                if (!w.started.after(date) && (w.left == null || !w.left.before(date))) {
                    // kas töötaja on tulnud tööle enne 1.7.2018, kas töötaja ei ole üldse või on lahkunud peale 1.7.2018

                    // "beforeOrEqual(date)" === (on sama mis) "! after(date)"

                    summa += w.salary;
                    mitu++;
                }
            }
            if (mitu == 0) System.out.println("Selliseid töötajaid ei ole");
            else System.out.printf("1. Juulil oli keskmine palk %s%n", summa / mitu);
        } catch (Exception e) {                                                         //kokkuleppeline e
            System.out.println(e.getMessage());
        }

        workers.stream().forEach(System.out::println);


        // kuidas leida töötajate keskmine palk (ilma tingimusteta hetkel)

        //OptionalDouble keskmine =
//        System.out.println(workers.stream()

    }


}


// siit algab kristjani ver:

/*
package ee.kriso;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // throws FileNotFoundException {  - võin kasutada seda (tean, et vigane)
        // praegu paning throw Exception, sest lõpus kuupäeval kontrollimine vaja teha

        // mis meil vaja oleks?
        // 1. kuidas andmed failist lugeda?
        // 2. kuhu need andmed failist lugeda (ntx list)
        // 3. seejärel need andmed siis lugeda
        List<Worker> workers = new ArrayList<>();

        // kuupäevade teisendamiseks oli meil vaja mida
        // SimpleDateFormatterit ja siis seda kasutada

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");


        try (Scanner scan = new Scanner(new File("PalgaAndmed.txt"))) {
            while (scan.hasNext()) {
                String rida = scan.nextLine(); // kasulik panna rida muutujasse, et next Line ei jätaks ridu vahele
                // kui mul vaja splittida koma järgi
                // ridu, milles võib olla muutuv osa tükke
                // siis üks kaval trikk, et ei peaks kontrommila, mitu tükki tuli
                // ja kas nad on tühjad, enne splittimist lisada sappa mõned komad
                // siis on vaja kontrollida AINULT kas tükk.length > 0
                String[] osad = (rida + ", , , ,").split(",");
                // nüüd on meil loetud rida tükeldatud osadeks
                // 0. osa nimi, 1. osa palk, 2. osa algus, 3. osa lahkumine (kui on lahkunud)
                String nimi = osad[0].trim();
                double palk = Double.parseDouble(osad[1].trim());
                Date tuliT88le = formatter.parse(osad[2].trim());
                // kuidas teame, et töötaja ei ole lahkunud
                // osad[3].length == 0

//                Date lahkusT88lt = null;
////                if (osad[3].length() > 0) {
////                lahkusT88lt = formatter.parse(osad[3]);
////                }

                Date lahkusT88lt = osad[3].length() > 1
                        ? formatter.parse(osad[3]) : null;

                workers.add(new Worker(nimi, palk, tuliT88le, lahkusT88lt));


            }

            // {
            // Scanner scan = new Scanner(new File("PalgaAndmed.txt"));
            // scan.close(); // et scanner pandaks kinni (kui scan on ploki muutuja, siis close ülearune
        } catch (Exception e) { // võib olla kasulik üld exception, sest igasugu vigu võib ju olla
            System.out.println(e.getMessage());
        }

        System.out.println("Kõik töötajad");

        // see rida trükib kõik töötaja välja

        // teeb sedasama, mis järgmine rida teeks!
        //        workers.stream().forEach(System.out::println);
        for (Worker w : workers) System.out.println(w);

        // kes on lahkunud

        System.out.println("Trükime kõik lahkunud");
        for (Worker w : workers)
            if (w.ended != null)
                System.out.println(w);
        workers.stream()
                .filter(x -> x.ended != null)
                .forEach(System.out::println); // see teeb sedasama striimiga

        double summa = 0;
        int mitu = 0;
        for (var w:workers) {summa+= w.salary; mitu++;}
        System.out.println(mitu == 0 ? 0 : (summa / mitu));

        // kuidas leida töötajate keskmine palk (ilma tingimusteta hetkel)
        System.out.print("Töötajate keskmine palk on: ");
        //OptionalDouble keskmine =
//        System.out.println(workers.stream()
        var keskmine =
                workers.stream()
                        .mapToDouble(x -> x.salary)
                        .average()
                //.orElse(0.0));
                ;

        System.out.println(keskmine.orElse(0));


//        if (keskmine.isPresent()) System.out.println(keskmine.getAsDouble());
//        else System.out.println("Keskmist pole");


        // palgakokkuvõte
        //  leiame 1.7.2018 tööl olnute keskmise palga
        // kes olid tööl 1. juulil

        summa = 0;
        mitu = 0;

        var date = formatter.parse("01-07-2018");

        for (var w : workers) { // käib läbi kõik töötajad
            if (w.started.after(date) && (w.ended == null || !w.ended.before(date))) {
                // kas töötaja on tulnud tööle enne 1.7.2018, kas töötaja ei ole üldse või on lahkunud peale 1.7.2018

                // "beforeOrEqual(date)" === (on sama mis) "! after(date)"

                summa += w.salary;
                mitu++;
            }
        }
        if (mitu == 0) System.out.println("Selliseid töötajaid ei ole");
        else System.out.printf("1. Juulil oli keskmine palk %s", summa / mitu);

    }
}

 */


//            // write your code here
//            T66taja person = new T66taja("35503070211", "Henn");
//
//            File peopleData = new File("inimesed.txt");
//            //nyyd vajadus puudub ja people asendatud hiljem Person.listOfPeople või Person.getInimesteArv vms
//            // : List<Person> people = new ArrayList<>(); //list võib koosneda igasugustest asjadest - ka failidest, nokksulgude vahel andmetüüp/klass - kõik objektid Person klassist
////klasse võib pakendada üheskimbus .jar (java resource) faili
//
//
////        try (Scanner scan = new Scanner(inimesed)) {
//            Scanner scan = new Scanner(peopleData);
//            while (scan.hasNext()) {
//
////            System.out.println(scan.nextLine());
//
////            String rida = scan.nextLine();
////            System.out.println(rida);
//
//                String[] data = scan.nextLine().split(",");
//                T66taja.listOfPeople.add(new T66taja(data[0], data[1]));
//
//            }
//
//
//            System.out.println(person);
//            System.out.println(person.getBirthMonth());
//
//
//
//            T66taja other = new T66taja("51705080001", "Ants");
//
//
//            System.out.println(other);
//    }

