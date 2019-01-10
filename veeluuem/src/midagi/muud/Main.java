package midagi.muud;

public class Main {

    public static void main(String[] args) {
        // main on meetod - vähemalt ühes klassis peaks olema
        //meetodi taga siis 2x sõna, k.a. args mk
        System.out.println("Tere õpüilased!");

        double beer = 20;

        System.out.printf("kolmele jagub %f pudelit \n", beer / 3);
        //miks ei saa muud kui main-i run-ida?


        int a=5,i;

        i=++a + ++a + a++;
        i=a++ + ++a + ++a;
        a=++a + ++a + a++;

        System.out.println(a);
        System.out.println(i);

        String eesNimi = "Henn";
        String pereNimi = "Sarv";
        String t2isNimi = eesNimi + " " +  pereNimi;
        System.out.println(t2isNimi);

        System.out.println(
        t2isNimi == "Henn Sarv" ? "v6rdsed" : "polev6rdsed"
        );

        System.out.println(
                t2isNimi.equals("Henn Sarv") ? "v6rdsed" : "polev6rdsed"
        );

        if (t2isNimi.equals("Henn Sarv")) {
            System.out.println("nimed on samad");
        }   else {
            System.out.println("nimed pole samad");
        }

        Integer arv = 77;
        String arvStringina = arv.toString();

        arvStringina = String.valueOf(arv * 2);

        arvStringina = "1732";
        arv = Integer.parseInt(arvStringina);

        //kaks eri viisi kuidas arvude ja stringide vahel toimetada, int ei tööta, Integer töötab
        // double d = arv; - saab; arv = (Integer)d - ei saa. arv = (int)d; - saab.

        //erinevus pythonist - tüübikindel on Java. muutuja tüüp jääb paika.
        // aga... a=3, b=4, c=5, a+b+c tuleb 39 ja c+b+a tuleb 12. liidab stringe kokku naljakalt yo
        // %s jms on kohatäide
        //.split(regex: " ")[0] - siin on null nr 1 - trükib välja "Henn"
        // .split ja scanner on sarnased. split tükeldab, tulemuseks stringide massiiv, scanner on tekstile lugeja,
        //tsükliliselt üle käia
        //StringBuilder classil on .append funktsioon, mis ei jäta erinevalt Stringist kõike iga operatsiooni järel mällu
        //StringBuffer'iga ei lähe puhverdades omavahel sassi. kui on "lõimed". midaiganes see ei tähendaks.
        //kokkulepe - konstandid kirj üleni suurtähtedes
        //muutujad või final'id: tähed-numbrid; _; Peab algama tähega (final kõiksuur)
        //Javas kokku lepitud, et klassinimed ainsad mille nimi suuralgustähega
        //3 tüüpi üldlauseid:
        //deklaratsioonid millega muutujad dekl (def), omistamised (muutujatega opereerimine), meetodite väljakutsed
        /* blokk on loogsulgude vahel. siin blokikommentaar btw.
        blokil on tvlslt päis. alustav loogeline sulg ja lõpetav oma rea peal
        iga lause, mitte bloki lõpus semikoolon
        TODO asi
        kommid dokumentatsiooni jaoks (tools: generate JavaDoc): /**
         */

        /**
         * dsad
         * ffg
         * h
         * palju dokki
         */

        int beerAsi = 21;
        if (beerAsi % 3 == 0) {
            System.out.println("täna õlut üle ei jää");
        } else {
            System.out.println("täna jääb pisut üle");
        }
        //st kas jagub kolmega
        //saab ka ühe lausega:

        int uusBeerAsi = beerAsi -1;
        if (uusBeerAsi % 3 == 0) System.out.println("täna õlut üle ei jää");
        else System.out.println("täna jääb pisut üle");
        //args-i lähevad parameetrid: int beer = Integer.parseInt(args[0]);; int mitu = Integer.parseInt(args[1]);
        //if (beer % mitu == 0) System.out.println("täna õlut üle ei jää"); - args[0] on esimene parameeter,
        // run - conf alt või jooksutades
    }
}


