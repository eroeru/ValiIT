package ee.E;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Person {

    private String personalId = "00000000000";
    private String name = "unknownName"; //väljaspool klassi enam muuta ei saa, tegime private'iks


    public static List<Person> listOfPeople = new ArrayList<>();

    public static int inimesteArv = 0;
    public static int getInimesteArv() {
        return inimesteArv;
    }

    //static kõigile ühine, mittestaatik on instantsi või objektiväli, igal objektil oma. oma isikuk, nimi, aga kõigil int inimeste arv. mittestatic on kui pole kirjas.



    public String getName() {
        return name;
    } //lugemiseks getter

    public void setName(String name) { //kirjutamiseks setter - mõlemad nad moodused et... klassist välja lugeda? ka teises .java-s?
//        this.name =
//                name.length() < 1 ? "unknown" :
////        this.name =
//                        name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase(); //saab, aga allub rangele kontrollile //ainult 1 substring, siis alates sellest. ignob kui vähem tähti.
        String[] osad = name.split(" ");
        for(int i = 0; i < osad.length; i++) {
            osad[i] = osad[i].substring(0,1).toUpperCase() + osad[i].substring(1).toLowerCase();
        }
        this.name = osad.toString();
   }

    // see siin on konstruktor
    public Person(String personalId, String name) {
        inimesteArv++;
        listOfPeople.add(this); //iga kord kui tehakse, mitte ainult üks otsa, vaid inimene pannakse add-iga ka listi kirja!
        this.name = name;
        this.personalId = personalId;
    }

    // selline on vaikimisi (default) konstruktor
    // kui on omatehtud, siis sellist süsteem ise ei tee
    // kui mul on mitu konstruktorit - overloadimine
    Person() {
        this("00000", "tundmatu"); //this peab esimene olema siin sulgudes
//        inimesteArv++; - seda pole enam vaja, kuna this kutsub esile eelmise konstruktori
    }


    public Person(String personalId) {
        this(personalId, "tundmatu"); //this.personalId pöörduks eelmise personalId välja poole, this() pöördub eelmise Person konstruktori poole.

//      enne oli:  this.personalId = personalId;
    }

    // siin lõppesid konstruktorid

    // siit algavad meetodid

    public int getBirthYear() {
        return (((Integer.parseInt(personalId.substring(0, 1)) - 1) / 2) * 100
                + 1800 + Integer.parseInt(personalId.substring(1, 3)));
    }

    public Date getBirthDate() {
        return (new GregorianCalendar(
                getBirthYear(),
                Integer.parseInt(personalId.substring(3, 5)) - 1,
                Integer.parseInt(personalId.substring(5, 7))
        )).getTime();
    }

    public String getBirthMonth() {
        // vaja leida isikukoodi järgi sünnikuu 'Märts'
        return String.format("%tB", getBirthDate());


    }


    // siit algavad overridetud meetodid - mis iganes need on
    public String toString() {
        return String.format("inimene %s syndinud %td.%<tB.%<tY",
                name, getBirthDate());
    }



}


