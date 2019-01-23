public class Tsyklid_Jutt {




    /*
    for( ; ; ){} -> tavaline for; kolm elementi: init-expr (alust); check-expr(/terminaator, millal lõpetada); iter-expr (korrata). kõigepealt täidetakse init-expr avaldis jne.
    1. init-expr; 2. if (check-expr) jah (täidetakse body); iter-expr; tagasi. kui false, siis lõpet. 3. lõpp
    i = 0; if i < .length, i++
    saavad kõik tühjad olla - siis teeb lõputult. teine lõputu tsükkel on while(true). Ja siis for(;;). Identsed.


    for ( : ) {} -> for each -> for (var x : kollektsioon) {}
    translaator vaatab:
    for (var ite = kollektsioon.getIterrator(); ite.hasNext();) {
    tsüklibody
    var x = ite.next();
    }
    -> kollektsioon võib olla HashSet, siis juhuslik järjek, TreeSet tähestikuline, List selles järjes kuidas pandi. Stack ja Que on ka minqid. Stack tuleb vist vastupidises. Que - ühest otsast paned, teisest võtad.


    while( b-expr ) {}
    kui boolean true, täidetakse body.
    võib kirjutada nii ka:
    for ( ; b-expr; ) {}
    identsed.


    do {} while (b-expr);
kontrollib pärast. while lõpus.
teisisõnu:
for (boolean b = true; b; b = b-expr) {} -> b-expr on boolean expression



    class Õ {
    int i =;
    public void v() {
    int i = -> muidu ei lubataks, aga klassi sees siiski lubatakse. esimene(ülemine) on lihtsalt this.i
    this.var on klassi tasemel ja lilla, muu meetodi tasemel (saab olla) ja tavaline vms.

*/

}
