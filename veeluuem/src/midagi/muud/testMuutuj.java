package midagi.muud;

public class testMuutuj {

    public static void main(String[] args) {

        int beer = Integer.parseInt(args[0]);
        int inim = Integer.parseInt(args[1]);

        if (beer > inim) System.out.println("oleme +");
        else System.out.println("oleme -");

    }
}


