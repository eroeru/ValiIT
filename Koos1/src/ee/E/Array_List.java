package ee.E;

import java.util.*;

public class Array_List {

    public static void main(String[] args) {

        //nokksulgude vahel klassinimed. genericute juures nokksulud yo.
        List<String> nimed = new ArrayList<>();
        List<Integer> arvud = new ArrayList<Integer>();

        nimed.add("Henn");
        nimed.add("Ants");
        nimed.add("Peeter");

//        nimed.indexOf("Ants");
// trüki välja, mitmendal kohal on Ants:
        System.out.println(nimed.indexOf("Ants"));

        //remove:
        nimed.remove("Peeter"); //kui olematu nimi vms, siis trükib -1 ehk ei leia.
        nimed.remove(1);

        //.length enam pole, aint arrayl, aga on .size

        for (int i = 0; i < nimed.size(); i++) {
            System.out.println(nimed.get(i)); //siin .get meetod

        }

        for (String nimi : nimed) {
            System.out.println(nimi);
        }
        //for tsüklit saab kasut kõigega mil iteraator. Iteraator? :
        for(var ite = nimed.iterator(); ite.hasNext(); ) {
            var nimi = ite.next(); // var on Javas uus asi. defineerida muutuja ilma et ytled mis tüüpi on, mis sellest hoolimata on kindlat tüüpi
            // keskkond ise defineerib. nimed on ju list, ei saa muud sisaldada kui stringe. Vaatab avaldist. Kui on nt 7, on int, kui 7L, siis long.
            System.out.println(nimi);
        }

        System.out.println("mis on HashSet");

        //mis asi see on?
        Set<String> teisedNimed = new HashSet<>();
        teisedNimed.add("Jaak");
        teisedNimed.add("Prints");
        teisedNimed.add("Jaakson");
        teisedNimed.add("Tõerüüt");
        teisedNimed.add("Jõepool");

        for (var nimi: teisedNimed) {
            System.out.println(nimi);
        }

        System.out.println("Mis on treeset:");
        Set<String> kolmandadNimed = new TreeSet<>();
        for (var nimi: teisedNimed) {
            kolmandadNimed.add(nimi);
        }

        for(var nimi: kolmandadNimed) System.out.println(nimi);

        //Set ei lase duubeldada. List selles järjekorras nagu paned, Set unikaalne ja kuidas "jumal juhatab".
        Set<Integer> arvudMillised = new TreeSet<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++){
            arvudMillised.add(r.nextInt(100));
        }

        for(var i : arvudMillised) System.out.println(i);

        //põmst dictionary:
        System.out.println("mis on dictionary");

        Map<String,Integer> inimesed = new HashMap<>();

        inimesed.put("Henn", 63); //võti on vasakpoolne
        inimesed.put("Ants", 28); //kui sama võtit lisada, kirjutab üle, teistmoodi kui HashSet st

        System.out.println(inimesed.get("Ants"));

        for(var ehee: inimesed.values()){ //keySet on võtmete hulk, values väärtuste hulk
            System.out.println(ehee);
        }


        Date algus = new Date();

            for(String ehee: inimesed.keySet())
                System.out.printf("%s on %s aastane%n", ehee, inimesed.get(ehee));

            Date l6pp = new Date();

            System.out.printf("Meil kulus %s millisekundit%n", l6pp.getTime() - algus.getTime()); //get.Time annab millisekid

//        --miskipärast "Inimene" ilma def?
//        Map<String, Inimene> raffas = new HashMap<>();
//        Inimene inim = new Inimene();
//        inim.nimi = "Henn";
//        inim.lasteArv = 4;
//        inim.vanus = 63;
//        raffas.put("Henn", inim);


    }

}

