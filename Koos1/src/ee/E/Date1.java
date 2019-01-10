package ee.E;

import java.text.SimpleDateFormat;
import java.util.Date;


//Date lihtsalt läks nimena konflikti
public class Date1 {

        public static void main(String[] args) throws Exception {

            Date dt = new Date();
            SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
            dt = f.parse("07-03-1955");

            System.out.printf("%s %tB %<te, %<tY \n", "Henn", dt);
            Date täna = new Date();
            System.out.printf("%s %tB %<te, %<tY \n", "Täna", täna);

            System.out.println(
                    (täna.getTime() - dt.getTime()) / (1000 * 60 * 60 * 24)
            );
        }

}
