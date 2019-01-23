package ee.E;


public class Main {

    public static void main(String[] args) {
        // write your code here
        Person person = new Person("35503070211", "Henn");

        System.out.println(person);
        System.out.println(person.getBirthMonth());

        System.out.println(person.getGender());

        if(person.getGender() == Gender.MEES)
            System.out.println("sinu asi on tuua viinad");
else
            System.out.println("Küpseta midagi kaasa");



        Person other = new Person("51705080001", "Ants");


        System.out.println(other);

//for (var p : Person.listOfPeople) {
//    if(p.getGender() == Gender.MEES) poisid.add(p);
//    else tüdrukud
//}





    }
}



//public class Main {
//
//    public static void main(String[] args) {
//
//
//
////        Inimene inimene = new Inimene();
////        inimene.nimi = "Henn";
////        inimene.vanus = 63;
//
//        Inimene inimene = new Inimene("35503070211", "Kristjan");
//
//        System.out.println(inimene);
//
//        Inimene teine = new Inimene();
//        teine.nimi = "Ants";
//        teine.vanus = 28;
//
//        System.out.println(teine);
////
////        Inimene kolmas = teine;
////        kolmas.vanus = 40;
////
//
//        Inimene kolmas = new Inimene();
//        kolmas.vanus = 40;
//
//
//        System.out.println(kolmas);
//    }
//}
