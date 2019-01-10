package ee.E;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Synnad {
    public static void main(String[] args) throws Exception {

        //selleks et datet pareseda, et teksti sees kasutada samamoodi
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");

        //   Calendar cal = new GregorianCalendar();
        // cal.setTime(dt); // teisendus dt-st cal-iks
        //teistpidi: dt = cal.getTime(); - teisendab Calendari Dateks
        // cal.set(Calendar.YEAR, 2019); - muudab kuup ühe osa

        Calendar t2na = new GregorianCalendar();
        //annan tänase väärtuse:
        t2na.setTime(new Date());

        //kui dt oli enne 7. märts 1955
        //siis cal on 7. märts 2019
        //Date -> Calendar, sest calendaril oli aasta muutmine lihtsaks tehtud Javas

        String[] nimed = {"Henn", "Ants", "Peeter"};
        Date[] synnikuupaevad = {
                f.parse("07-03-1955"),
                f.parse("06-08-1982"),
                f.parse("07-01-1960")
        };
        Calendar[] synnad = new Calendar[synnikuupaevad.length];
        for (int i = 0; i < synnikuupaevad.length; i++) {
            //tee tühja massiivi kalender, ja anna neile väärtusi:
            synnad[i] = new GregorianCalendar();
            //date kalendriks ja need synnade sisse
            synnad[i].setTime(synnikuupaevad[i]);
            //muudab 2019-ks kõik väärtused
            synnad[i].set(Calendar.YEAR, 2019); //todo: hiljem tuleks siia kirjutada õige praeguse aastanr viis.. vist fixed?
            //pane järgmine aasta:
            if (synnad[i].getTime().getTime() < t2na.getTime().getTime())
                synnad[i].set(Calendar.YEAR, 2020);

                //teine võimalus .getTime asemele: compareTo((t2na) < 1)
            // synnad[i].set(Calendar.YEAR, 2020);
        }

        for (int i = 0; i < nimed.length; i++) {
            System.out.printf("%s on syndinud %tB %<te, %<tY ja ta synnipaev on %tB %<te, %<tY %n", nimed[i], synnikuupaevad[i], synnad[i]);
        }
        //võrdlema peab .compareTo-ga, aint arve saab < ja > võrrelda

        int indeksKandidaat1 = 0;
        int indeksKandidaat2 = 0;

        for (int i = 1; i < nimed.length; i++) {
            if (synnikuupaevad[indeksKandidaat1].compareTo(synnikuupaevad[i]) < 0) indeksKandidaat1 = i;
            if (synnad[indeksKandidaat2].compareTo(synnad[i]) > 0) indeksKandidaat2 = i;
        }

        System.out.println("Koige noorem on " + nimed[indeksKandidaat1]);
        System.out.println("Jargmisena peab synnat " + nimed[indeksKandidaat2]);
    }
}