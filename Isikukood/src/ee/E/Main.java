package ee.E;

public class Main {



// fieldid , konstruktorid, getterid/setterid, static enne kui instance, override'id lõppu ja järjest; grupi piires kas tähestikulist või sisulist loogikat


    public static int synniAasta (String isikukood) {
//        1. leia saj
//                2. leia sünnia tagumine pool
//                3. need kokku smurgeldada
//                4. tulemus returnida
        int tulemus = 0;

        //TODO - siia vahele n 4 asja
        int sajand = Integer.parseInt(isikukood.substring(0,1));
        int aasta = Integer.parseInt(isikukood.substring(1,3));

        switch (sajand) {
            case 1:
            case 2: tulemus = 1800 + aasta; break;
            case 3:
            case 4: tulemus = 1900 + aasta; break;
            case 5:
            case 6: tulemus = 2000 + aasta; break;
        }

        // esimene nummer: kui 1 v 2 siis 1800 jne. kui teha sellega lihtne tehe, saab alates 1800ndast tulemuse:

        tulemus = ((sajand - 1)/2 + 18)*100 + aasta;



        return tulemus;

    }



    public static void main(String[] args) {
        String hennuIk = "35503070211";
        System.out.println(synniAasta(hennuIk));

    }


}
