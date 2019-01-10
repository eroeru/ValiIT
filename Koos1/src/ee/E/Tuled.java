package ee.E;

public class Tuled {

    public static void main(String[] args) {

        if (args.length > 0) {

            String tuled = args[0];

            if (tuled.equalsIgnoreCase("green") || tuled.equalsIgnoreCase("roheline")) {
                System.out.println("V6id minna vms");
            } else if (tuled.equalsIgnoreCase("yellow") || tuled.equalsIgnoreCase("kollane")) {
                System.out.println("Mitte veel vms");
            } else if (tuled.equalsIgnoreCase("red") || tuled.equalsIgnoreCase("punane")) {
                System.out.println("2ra liigu");
            } else {
                System.out.println("vale sisend");
            }
        }
    }

}
