package ee.E;
import java.util.Scanner;

public class Tuled_do {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //hea komme, kui muutuja defineerid, kirjutada algväärtuse sisse, võib olla "hetkel ei ole värvi", while annaks vea
        String rida = "";

        //siit algaks tsükkel
        do        {

                System.out.print("mis värv seal on: ");
                rida = scan.nextLine();

            switch (rida.toLowerCase()) {
                case "roheline":
                case "green":
                    System.out.println("sõida edasi");
                    break;

                case "kollane:":
                case "yellow:":
                    System.out.println("oota pisut");
                    break;

                case "punane":
                case "red":
                    System.out.println("jää seisma");
                    break;

                default:
                    System.out.println("kas oled värvipime?");
                    break;
            }
            } while(!
            (rida.equalsIgnoreCase("roheline")
            || rida.equalsIgnoreCase("green")
            ));
    }
    }

