package ee.E;

import java.util.List;

public class Main {




    //meetod nimi(parameetrid - muutujad nime ja andmetüübiga; body ehk {programmiblokk}
    // nimi (parameetrid) {body}
    //juurdepääs static nimi (parameetrid) {body}

    // signatuur := nimi(parameetrid)
    //NB! parameetrite kui muutujate nimed ei kuulu signatuuri hulka

    // siis ka meetod vs funktsioon

    // meetod on tagastustüübiga void ja ei anna midagi tagasi
    //funktsioon on kindla tagastustüübiga ja lõpeb return lausega
    // on nt .add - boolean tüüpi, vaadata list method summary - dokudes meetoditel ja funkts ei tehta vahet, nimet meetoditeks



// kui on üks parameeter, valib järgnevatest esimese, kahega samuti, kolmega teise, rohkematega kolmanda
    // nimet parameetriarray'ks


    public static int liida(int yks, int teine) {        //funktsioon? - annab vastuse mingit tüüpi vs meetod, mis lihtsalt teeb, ei returni miskit
        return yks + teine;
    }

    public static int liida(int yks, int teine, int kolmas) {
        return yks + teine + kolmas;
    }

    public static int liida(Integer... mida) {
        int summa = 0;
        for (var x : mida) {
            summa += x;
            return summa;
        }
    }


        //siin viga, kuna pole sama tüüpi
        // public static long liida(int yks, long teine) {
        //    return yks+teine;
        // }




        //nüüd kui main-ison funktsioon, kahe väärtusega, siis ei tea kumba longiks, kumba intiks
        // nt int vastus = liida(yks: 4, teine: 7);
        // ta ei ole nõus isegi int-i longiks tegema

        //public, private, protected on ka - private'it saab vaid enda klassi sees välja kutsuda

        public static void tryki (String nimi, Object value) {        //puhtmeetod (ei saa kasutada avaldise sees, väljakutse eraldi lause
            // - mote funktsioonidel ja trykil: kui vaja mitmes kohas, seeasemel et mitmes kohas sama jupp, yks funktsioon ja mitmes kohas kasutada

            System.out.printf("%s väärtus on %s%n", nimi, value);

        }

        public static void tryki (List < Integer > mida) {
            for (int i = 0; i < mida.size(); i++)
                System.out.printf("%s %s", mida.get(i), (i % 13 == 12 ? "\n" : "\t"));
        }

        public static void tryki (List < Integer > mida,int kaupa){
            for (int i = 0; i < mida.size(); i++) {
                System.out.printf("%s %s", mida.get(i), (i % kaupa == (kaupa - 1) ? "\n" : "\t"));
            }

        }


        public static void main (String[]args){
            // write your code here
//         tryki(pakk);
//        tryki(segatudPakk);... nt
        }

    }
}
