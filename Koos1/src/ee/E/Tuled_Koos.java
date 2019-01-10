package ee.E;

public class Tuled_Koos {

    public static void main(String[] args) {
        System.out.println("Mis see on?");


        if (args.length > 0) {

            switch (args[0].toLowerCase()) {

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
        }
    }
}
