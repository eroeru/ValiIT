package ee.E;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws Exception { // võib ka throws FileNotFoundException, IndexOutOfBoundsException try asemel... kui poleks "throw ne Exception", mis seda nõuab {


        String[] nimed = {"Henn", "Ants", "", "Peeter"};

        try { // try enda lõpus on close'tud nkn. try bloki lõpuks pannakse see minnu eest kinni

            PrintWriter pw = new PrintWriter(new File("uusfail.txt"));

            for(int i = 0; i < 1000; i++) {
                for (var nimi : nimed) {
                    if (nimi.length() == 0) throw new Exception("valenimi"); //kuna "Peeter" ette lisati array element "", tulebki
                    pw.println(nimi); //faili kirjutatakse mitte otse, vaid läbi puhvri. loogelised sulud - hea komme jätta.
                }
            }
            pw.close(); // kui poleks, prinditaks umb 1200 korda välja, kuna siis saab puhver täis ei viitsi edasi teha

        } catch (FileNotFoundException e) {


        }
    }
}