package ee.E;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.*;

public class Main {

    public static boolean Paaris(int arv) {
        return arv % 2 == 0;
    }

    public static void main(String[] args) {
        // write your code here

        //Striimid

        //  var arvud = IntStream.range(0,10).toArray(); //arvud on int
        // System.out.println(IntStream.range(0,10).sum());
        var imelikudArvud = IntStream.range(0, 20);

        for (var x : imelikudArvud.
//            filter(x -> x % 2 == 0)
        filter(Main::Paaris)
                .toArray())
            System.out.println(x);
//        System.out.println(imelikudArvud.average()); - keskmisega ... ...

        String[] nimed =  {"Henn", "Ants", "Peeter"};

        for (var nimi : Stream.of(nimed)
                .filter(x -> x.length() == 4) // kui lisan // kõigele siin ette ja ka teisele .filterile ette, siis trükitakse ette kõik nimed //avaldis, mille väärtuseks funktsioon
                // kuna intidest koosnev striim, siis teab et intidest koosnev
                .collect(Collectors.toList()))

            System.out.println(nimi);

        Stream.of(nimed)
                .filter(x -> x.length() == 4)
                .forEach(System.out::println);

        Random r = new Random();
//        var pakk =
                IntStream
                        .iterate(0, x-> r.nextInt(52))
                        .distinct()
                        .limit(52)
        //.toArray(); // var puhul nõus - kaardipakk
        .forEach(System.out::println);

//                for(var kaart : pakk) System.out.printf("%s\t", kaart);

        IntStream.range(0,20) //pinksipallide jada
                .map(x -> x*x)
                .boxed() //vahepeal peab asju karbi sisse panema, muidu ei saa teisendada
                .map(x -> String.format("arv on %s\t", x))
                .forEach(System.out::println); //for each lõpetab ära, pole miskit countida
//                .count() //lõpetab toru ja ütleb mis toru otsas
        //.collect(Collectors.toList()) //ka üks terminaatoritest

        var toru =
                IntStream.range(0,20)
                .map(x -> x*x)
                .boxed()
                .map(x -> String.format("arv on %s\t, hasta la vista bb", x));

        System.out.println("toru andmed:");
        var list = toru.collect(Collectors.toList());
        System.out.println(list.size());
        for(var x : list) System.out.println(x);

        Integer[] arvudA = {1,2,3,4,5,6};
        var misasi = Stream
                .of(arvudA)
                .mapToInt(x -> x) // nüüd saab ka .sum-i. Integer to int
                .boxed() //int to Integer
                .collect(Collectors.toList()) //nüüd saab, list-iks saab Integere, aga mitte int-e. array-ks peaks saama mõlematpidi. objektide array kõige vastikum, pole miskit peale hakata

                ;


    }// funktsioon parameetri kohale - lambda funktsioon - lambda, sest kui keerata lambdat, saab noole

//Stream:of(List
    //edastajad - kas valikuliselt või kõik. nt filter, millel funktsiooniga igat palli võrdleb ja siis otsustab kas laseb edasi
    //edastavad nö pinksipallikesi yo
    // üks edastaja on .limit()
    //ss .skip(mingi osa jätab endale)

    /* teisendajad - antakse ette nt .map
    *
    *
     */

}
