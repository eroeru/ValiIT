package ee.E;

public class Tester {



        public static int liida(int yks, int teine) {
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

        public static void main(String[]args) {


        }


}