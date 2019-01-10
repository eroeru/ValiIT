package ee.Ro;

public class Uus_K {

    public static void main(String[] args) {
        String[] nimed = {"Henn", "Ants", "Peeter", "Joosep"};

        //for each tsükkel: Javas for; tsükli pea veits teistsugune: ":"
        for(String nimi : nimed) {
            System.out.println(nimi);
        }

        // tavaline for:
//        for(int i = 0; i < nimed.length; i++) {
//            String nimi = nimed[i];
//            System.out.println(nimi);
//        }
//        for(int i = nimed.length; i > 0;) {
//            System.out.println(nimed[--i]);
//
//            //normaalne õpetaks nii: for(int i = nimed.length - 1; i >= 0;i--) : System.out on sama, v.a. --i asemel i--
//            //võib lisada System.out.printf("%s. %s\n", i+1, nimi); - siis saab nimekirja
//            // võib ka String nimi = nimed[--i]; System.out.println(nimi);
//        }



    }

}
