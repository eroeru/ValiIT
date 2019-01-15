package ee.E;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class kuupHarj {

        public static void main(String[] args) throws Exception {


            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

            Calendar t2na = new GregorianCalendar();

            t2na.setTime(new Date());


            Date[] dates = {
                    formatter.parse("07-03-1955"),
                    formatter.parse("06-08-1982"),
                    formatter.parse("07-01-1960")
            };

            Date test = new Date();
            System.out.println(test.getTime());
            test.setTime(1_547_192_911_000L);
            System.out.println(test);

            Date varaseim = dates[0];
            Date hiliseim = dates[0];

            //i ei pea nullist hakkama, pole ju elementi endaga vaja võrrelda
            for (int i = 1; i < dates.length; i++) {
                //kaks eri versiooni: getTime ja compareTo
                if (dates[i].getTime() < varaseim.getTime()) varaseim = dates[i];
                if (dates[i].getTime() > hiliseim.getTime()) hiliseim = dates[i];
                //compareTo: if (dates[i].compareTo(hiliseim) > 0) hiliseim = dates[i];
                //compareTo annab vastuseks 0, kui asi1 == asi2
                //annab vastuseks <0, kui asi < asi2
                //annab vastuseks >0, kui asi1 > asi2
            }

            System.out.printf("Varaseim on %s %n", varaseim);
            System.out.printf("Hiliseim on %s %n", hiliseim);


            //                if (dates[i].compareTo(varaseim) < 0) ;
                //esimene ver juhul kui tahta teisendada numbriteks: if (dates[i].getTime() < varaseim.getTime());

            }

        }

