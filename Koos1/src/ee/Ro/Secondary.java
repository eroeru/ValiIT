package ee.Ro;

public class Secondary {
    public static void main(String[] args) {
    //string args on ka massiiv
        //tsüklid

        int[] arvud = {1, 2, 3, 4, 5, 6, 7};

        for (int i = 0; i < arvud.length; i++) {
            System.out.printf("arv number %s on %s\n", i, arvud[i]);



        }
        //array of arrays (massiividest koosnev massiiv):

        int[][] misseeon = {{1,2,3}, {2,3,4}, {1,2,3,4,5}};
        for (int i = 0; i < misseeon.length; i++)//siia ei tule ;, vb võiks olla {, sest muidu järgmises for-tsüklis pole i
            // võid teha et oleks tabel eraldi ridades:
            //{
            //System.out.println();
            for (int j = 0; j < misseeon[i].length; j++) {
                System.out.println(misseeon[i][j]);
                //VÕI reavahetuseks lõpus System.out.printf("%s%s ", j==0?"/n":"",misseeon[i][j]);
        }
    }
}
//int[] m; - defin
//m = new int[10] - loob
//int[] m2 = new int[10] defineerib ja loob (vt slaide)
//int[] m3 = {1, 4, 5, 2, 6, 1};

//int[] arvud = new int[10]; (massiivi deklareerimine, on siuke in kogum, alguses on nulle täis)
//arvud[4] = 77; (siin on hoopis viies int, kuna 0-st lugemine)
/* int[] teine = arvud;
System.out.println(teine[4]); (nüüd trükitakse välja 77, kaks muutujat viitavad samale massiivile)
Suht sarnane Pythoni list-ile. */

