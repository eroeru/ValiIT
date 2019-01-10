public class Massiiv {

    public static void main(String[] args) {

        int[] arvud = {
                77,
                35,
                64,
                267,
                36,
                65,
                14,
                24,
                124,
                124,
                53,
                14,
                55,
                14,
        };

        int v2ikseim = arvud[0];
        int mitmes = 0;
        int mitu = 1;

        for (int i = 0; i < arvud.length; i++) {
            if (arvud[i] < v2ikseim) {
                v2ikseim = arvud[i];
                mitmes = i;
                mitu = 1;
            } else if (arvud[i] == v2ikseim) mitu++;

        }

        System.out.printf("V2ikseim arv on %s.%n", v2ikseim);
        System.out.printf("Seda arvu on: %s tykki.%n", mitu);
        System.out.printf("See arv asub %s. kohal.%n", mitmes);

        for (int i = mitmes + 1; i < arvud.length; i++) {
            if (arvud[i] == v2ikseim)
                System.out.printf("Teda on veel kohal nr %s.%n", i + 1);
        }

//kogend progeja:
        // ArrayList<Integer> kohad = new Arraylist jnejne


    }

}
