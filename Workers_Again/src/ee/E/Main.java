package ee.E;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;

public class Main {

    List<Wrkrs> workers = new ArrayList<>();

    public static void main(String[] args) {




        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        List<Wrkrs> workers = new ArrayList<>();


        try {
            Scanner scan = new Scanner(new File("tyyandmed.txt"));
            while (scan.hasNext()) {
                String rida = scan.nextLine();

                String[] osad = (rida + ", , , ,").split(",");

                String nimi = osad[0].trim();
                double palk = Double.parseDouble(osad[1].trim());
                Date tuliTyyle = formatter.parse(osad[2].trim());




                Date lahkusTyylt = osad[3].length() > 1
                        ? formatter.parse(osad[3]) : null;
                workers.add(new Wrkrs(nimi, palk, tuliTyyle, lahkusTyylt));


            }


        } catch (Exception e) {
            System.out.println(e.getMessage());


        }

        System.out.println("kõik töötajad");

        for (Wrkrs w : workers) System.out.println(w);



        System.out.println("trükime kõik lahkunud");
        for (Wrkrs w : workers)
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

                ;

        System.out.println(keskmine.orElse(0));


        summa = 0;
        mitu = 0;

        try {
            var date = formatter.parse("01-07-2018");

            for (var w : workers) { // käib läbi kõik töötajad
                if (!w.started.after(date) && (w.left == null || !w.left.before(date))) {

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


    }


}

/*
c. arvutad välja
mingil kuupäeval tööl olevate keskmise palga (meetod tee selleks)

teed meetodi, mis vastu võtab parameetrina Date
ja vastu annab Double'ina keskmise

public static Double keskminePalk(Date dt) {

}

1. Mõtled läbi, mis sa pead teistmoodi tegema
2. Mõtled läbi, kuidas see mis me tegime vormistada funktsiooniks
3. Mõtled läbi, kuidas sa selle funktsiooni ära saaks proovida

static kutusutakse välja klassi küljest
mittestatic kutsutakse

kui funkts lõpetab returniga, siis avaldis
kui void lõpetab returniga, siis return()





package ee.Henn;

        import java.io.File;
        import java.io.FileNotFoundException;

        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.*;

public class Main {
    static List<Worker> workers = new ArrayList<>();  // see pn 2.
    // selle muutuja tõstsime meetodist main klassi muutujaks
    // siis on ta kasutatav igas selle klassi meetodis
    // ägge!

    public static void main(String[] args) throws ParseException {
        // mis meil vaja oleks?
        // 1. kuidas andmed failist lugeda
        // 2. kuhu need andmed failist lugeda (ntx List)
        // 3. seejärel need andmed siis lugeda


        // kuupäevade teisendamiseks oli meil vaja mida?
        // SimpleDateFormatterit
        // ja siis seda kasutada

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");


        try
        { // see on 1.
            Scanner scan = new Scanner(new File("PalgaAndmed.txt"));
            while (scan.hasNext()) {
                String rida = scan.nextLine();
                // kui mul on vaja splittida koma järgi
                // ridu, milles võib olla muutuv osa tükke
                // siis üks kaval trikk, et ei peaks kontrollima, mitu tükki tuli
                // ja kas nad on tühjad, enne splittimist lisada sappa mõned komad
                // siis on vaja kontrollida AINULT kas on tükk.length > 0
                String[] osad = (rida + ", , , ,").split(",");
                // nüüd on meil loetud rida tükeldatud osadeks
                // 0. osa nimi
                // 1. osa palk
                // 2. osa tööletulemise kuupäev
                // 3. osa lahkumise kuupäev (kui on lahkunud)
                String nimi = osad[0].trim();
                double palk = Double.parseDouble(osad[1].trim());
                Date tuliTööle = formatter.parse(osad[2].trim());
                // kuidas me teame, et töötaja ei ole lahkunud
                // osad[3].length == 0

//                Date lahkusTöölt = null;
//                if (osad[3].length() > 0) {
//                lahkusTöölt = formatter.parse(osad[3]);
//                }

                // eelneva (väljakommenteeritud) osaga samaväärne
                // aga kirjutatud ÜHE avaldisena
                Date lahkusTöölt = osad[3].length() > 1
                        ? formatter.parse(osad[3].trim()) : null;

                workers.add(new Worker(nimi, palk, tuliTööle, lahkusTöölt));

            }


        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("kõik töötajad");

        // see rida trükib kõik töötajad välja
        //  workers.stream().forEach(System.out::println); // see teeb sedasama striimiga
        for (Worker w : workers) System.out.println(w); // see teeb seda tsükliga

        // kes on lahkunud
        System.out.println("trükime kõik lahkunud");
        for (Worker w : workers)
            if (w.ended != null)
                System.out.println(w);
        workers.stream()
                .filter(x -> x.ended != null)
                .forEach(System.out::println); // see teeb sedasama striimiga

        double summa = 0;
        int mitu = 0;
        for (var w : workers) {
            summa += w.salary;
            mitu++;
        }
        System.out.println(
                mitu == 0 ? 0 : (summa / mitu)

        );


        // kuidas leida töötajate keskmine palk (ärme praegu tingimusi lisa)
        System.out.print("Keskmine palk: ");
        var keskmine =
                workers.stream()
                        .mapToDouble(x -> x.salary)
                        .average()
                //.orElse(0)
                ;
        System.out.println(keskmine.orElse(0));

        // leiame 1.7.2018 tööl olnute keskmise palga
        // kes olid tööl 1. juulil ??

        summa = 0;
        mitu = 0;




        System.out.println(averageOnDate(formatter.parse("01-07-2018")));
        System.out.println(averageOnDate(formatter.parse("01-01-2018")));
        System.out.println(averageOnDate(formatter.parse("01-12-2018")));

//          Selle lõigu tõstsime meetodi sisse ja korjasime siit ära
//        for (var w : workers) { // käib läbi kõik töötajad
//            if (!w.started.after(date) && (w.ended == null || !w.ended.before(date))) {
//
//                // kas töötaja on tulnud tööle enne 1. juulit
//                // kas töötja ei ole lahkunud või on lahkunud pelae 1. juulit
//
//                // "beforeOrEqual(date)" see on see sama asi, mis "! after(date)"
//
//                summa += w.salary;
//                mitu++;
//                System.out.println(w.salary);
//            }
//        }
//        if (mitu == 0) System.out.println("1. juulil meil töötajaid ei olnud");
//        else System.out.printf("1. juulil oli keskmine palk %s", summa / mitu);


//

    }

    public static Double averageOnDate(Date date) {
        //var date = formatter.parse("01-07-2018");
        double summa = 0;
        int mitu = 0;
        for (var w : workers) { // käib läbi kõik töötajad
            if (!w.started.after(date) && (w.ended == null || !w.ended.before(date))) {

                // kas töötaja on tulnud tööle enne 1. juulit
                // kas töötja ei ole lahkunud või on lahkunud pelae 1. juulit

                // "beforeOrEqual(date)" see on see sama asi, mis "! after(date)"

                summa += w.salary;
                mitu++;
                //System.out.println(w.salary);
            }
        }
        return mitu == 0 ? 0 : summa / mitu;
    }
}

 */