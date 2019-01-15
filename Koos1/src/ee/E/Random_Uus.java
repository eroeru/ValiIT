package ee.E;

import java.util.Date;
import java.util.Random;

public class Random_Uus {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            double juhus = Math.random();
            int juhuslik = (int)(Math.random() * 70);
            System.out.println((juhus));
        }

        Random r = new Random(5138100);
        for (int i = 0; i < 10; i++)
            System.out.printf("%s ", r.nextInt(10));

        /*
        math.random() - annab juhusliku double
        (int)(math.random() * 100) -> annab juhusliku int arvu 0...100

        Random r = new Random();
        r.nectInt() - annab juhusliku täisarvu - sellise objekti (muutujaga) saab sellist lahedat stuffi teha
        r.nextInt(100) - annab juhusliku täisarvu sajani
        kui Random r = new Random(mingivalitudsupooltarv - ehk siis alguspunkt, kust juh arve hakkab võtma);

        siis see r annab "juhuslikult" alati samad arvud
        */

        //kuidas leida juhuslik kuup

        // Leiame mitu päeva on tänaseni - alates 1970ndast

        Date dt = new Date();
        int t2naseni = (int)(dt.getTime() / (100*24*60*60));
        System.out.println((t2naseni));

        dt.setTime(0);

        int uusInt = r.nextInt(t2naseni);
        System.out.println(uusInt);
        long uus = (long)uusInt * (100*24*60*60);
        System.out.println(uus);
        dt.setTime(uus);


        long uusVeel = r.nextInt(t2naseni) * (100*24*60*60);
        System.out.println(uusVeel);
        dt.setTime(uusVeel);
        System.out.println(dt);

        dt.setTime(r.nextLong() % (new Date().getTime()));
        System.out.printf("juhuslik kuup mis t2nasest kindlalt v2iksem: %s %n", dt);
    // loogika - jääk on alati väiksem kui 7, kui 7ga jagada. jääk alati väiksem praegusest, kui praegusega jagada. hmmmm...
    }


}
