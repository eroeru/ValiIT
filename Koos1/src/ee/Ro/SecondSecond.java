package ee.Ro;
import java.util.Scanner;

public class SecondSecond {

    public static void main(String[] args) {

        //system inputist hakka lugema
        Scanner scan = new Scanner(System.in);
        String rida = "*"; //pole seda tärni ja võrdusmärki vaja, aga while-iga oleks probleem, peab ühe korra vähemalt lugema
        int summa = 0;

        //uus asi - while tsükkel
        //niikaua loe, kuni sisestatud rida suurem kui tühirida
        //while(rida.length() > 0) { - võib do asemel olla??

        do {

            System.out.print("anna üks arv: ");
            rida = scan.nextLine();
            if (rida.length() > 0) {
                int arv = Integer.parseInt(rida);
                System.out.printf("ütlesid: %s\n", arv);
                summa += arv;




            }

// while tsükkel on for tsükli lihtne variant, koosneb vaid boolean avaldisest
// do tsükkel on ka - ta teeb 1.) body; 2.) kas jätkab, aga while-tsüklis täidetakse 0 kuni mitu korda body't, do's 1 kuni mitu

/* while

while (boolean-expression)  {
//body
}

for (;boolean-expression;) { ... }

for (bool b = true; b; b = boolean-expression) { ... }


//do tsükkel

do
{
//body
} while (boolean-expression);

do-tsükkel kindlasti täidab vähemalt korra, while kontrollib kohe kas true??

 */

        } while (rida.length() > 0);
            System.out.printf("summa on %s\n", summa);
    }
}