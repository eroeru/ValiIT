package ee.E;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Isikukood_2 {


    //nyyd et annaks sünniaja võib Date asemel kasutada Calendar

    public static int synniAasta(String isikukood) {
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


    public static void main(String[] args) {
        String hennuIk = "35503070211";
        System.out.println(synniAasta(hennuIk));

        System.out.printf("see inimene on sündinud aastal %s %s kuu %s päeval %n",
                synniAasta(hennuIk),
                hennuIk.substring(3,5),
                hennuIk.substring()
                );



    }

    public static Date synniAeg(String isikukood) {
        Date sa = new Date();
        Calendar cal = new GregorianCalendar(
                synniAasta(isikukood),
                Integer.parseInt(isikukood.substring(3,5)) -1,
                Integer.parseInt(isikukood.substring(5,7))
        );

        sa = cal.getTime()
        return sa;
    }




}
