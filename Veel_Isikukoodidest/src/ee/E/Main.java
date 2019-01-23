package ee.E;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {


        //uuem harj swap meetodiga:
//
//        public void swapPerson(Person yks, Person teine) {
//            Person ajutine = yks;
//            yks = teine;
//            teine = ajutine;
//        }
//
//        public void swapFile(File yks, File teine) {
//            File ajutine = yks;
//            yks = teine;
//            teine = ajutine;
//        }


        File peopleData = new File("inimesed.txt");
        //nyyd vajadus puudub ja people asendatud hiljem Person.listOfPeople või Person.getInimesteArv vms
        // : List<Person> people = new ArrayList<>(); //list võib koosneda igasugustest asjadest - ka failidest, nokksulgude vahel andmetüüp/klass - kõik objektid Person klassist
//klasse võib pakendada üheskimbus .jar (java resource) faili


//        try (Scanner scan = new Scanner(inimesed)) {
        Scanner scan = new Scanner(peopleData);
        while (scan.hasNext()) {

            System.out.println(scan.nextLine());

//            String rida = scan.nextLine();
//            System.out.println(rida);

            String[] data = scan.nextLine().split(",");
            Person.listOfPeople.add(new Person(data[0], data[1]));

        }

//        System.out.printf("Meil on %s inimest %n", Person.getInimesteArv());
//
//        for (var p : Person.listOfPeople) System.out.println(p); // people on list, mis koosneb personitest, niiet kõik siin vari all personid
//
//        Person noorim = Person.listOfPeople.get(0);
//        for (int i = 1; i < Person.listOfPeople.size(); i++) {
//            if (Person.listOfPeople.get(i).getBirthDate().getTime() > noorim.getBirthDate().getTime())
//                noorim = Person.listOfPeople.get(i);
//        }
//        System.out.printf("noorim on %s%n", noorim.getName());

        System.out.printf("Meil on %s inimest %n", Person.getInimesteArv());

        for(var p : Person.listOfPeople) System.out.println(p);

        // see oleks üks (1) variant, kuidas leida noorim
        Person noorim = Person.listOfPeople.get(0);
        for (int i = 1; i < Person.getInimesteArv(); i++) {
            if (Person.listOfPeople.get(i).getBirthDate().getTime() > noorim.getBirthDate().getTime())
                noorim = Person.listOfPeople.get(i);
        }
        System.out.printf("noorim on %s%n", noorim.getName());

    }

}


//parem: gitlab.com/Hennsarv