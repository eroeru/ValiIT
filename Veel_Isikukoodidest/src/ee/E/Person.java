package ee.E;

import java.util.*;

public class Person {

    private String personalId = "00000000000";
    private String name = "unknownName"; //väljaspool klassi enam muuta ei saa, tegime private'iks

    public static List<Person> listOfPeople = new ArrayList<>();

    public static Map<String, Person> mapOfPeople = new HashMap<>();
    public static Map<String, List<Person>> mapOfPeopleNames = new TreeMap();
// List: igale nimele vastu mitu tk - et siis listi elementi mitu

    //järgm näd uus:
    public static int inimesteArv = 0;

    public static int getInimesteArv() {
        return inimesteArv;
    }

    // new'ga kutsutakse esile konstruktor


    public String getName() {
        return name;
    } //lugemiseks getter

    public void setName(String name) throws Exception { //kirjutamiseks setter - mõlemad nad moodused et... klassist välja lugeda? ka teises .java-s?


        //äsjaloodu või varemloodu inim?
        if(this.name.length() > 0)

      mapOfPeopleNames.get(this.name).remove(this);


//        this.name =
        if(name.length() < 1) this.name = "unknown";
        else {

            String[] osad = name.split(" ");
            for (int i = 0; i < osad.length; i++) {
                osad[i] = osad[i].substring(0, 1).toUpperCase() + osad[i].substring(1).toLowerCase();
            }
            this.name = String.join(" ", osad);
            }
        //lisame uude kohta - miks tho....
        if (!mapOfPeopleNames.keySet().contains(name)) {
            mapOfPeopleNames.put(name, new ArrayList<>());
        }
        mapOfPeopleNames.get(name).add(this);        }

//        this.name =
//                        name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase(); //saab, aga allub rangele kontrollile //ainult 1 substring, siis alates sellest. ignob kui vähem tähti.


    // see siin on konstruktor
    public Person(String personalId, String name) throws Exception {
        inimesteArv++;
        listOfPeople.add(this); //iga kord kui tehakse, mitte ainult üks otsa, vaid inimene pannakse add-iga ka listi kirja!

        setName(name);  //vanast listist - aga kuidas nüüd aru saame, et inim uuest listist vms?
//        this.name = name; - vana ver.
        this.personalId = personalId;


        if (! mapOfPeopleNames.keySet().contains(name)) { //kas selline nimi on
            mapOfPeopleNames.put(name, new ArrayList<>()); //kui ei ole, uus array list ja lisame uue tegelase järgnevalt
        }
        mapOfPeopleNames.get(name).add(this); //this on konstruktori Person


        //esimene etapp: kui tahad inimest dictionary'sse lisada, kontrollida kas ta juba on seal:
        // kui on, lisan, kui ei ole, siis uue listi, ja lisan ta sinna
        if (!mapOfPeople.keySet().contains(personalId)) {
            mapOfPeople.put(personalId, this);
        }

        //teeks ehk meetodi getById vms, et saada nime järgi, ka siis kui nimesid mitu samasugust?
    }

    public static Person getById(String personalId) {
        return mapOfPeople.keySet().contains(personalId) ? mapOfPeople.get(personalId) : null;
    }

    // ei kasuta dictionary't, lihtsalt otsime:
    public static Person getById2(String personalId) {
        return mapOfPeople.keySet().contains(personalId) ? mapOfPeople.get(personalId) : null;
    }


    public static List<Person> getByName(String name) {
        return mapOfPeopleNames.keySet().contains(name) ? mapOfPeopleNames.get(name) : null; //kui on siuke seal, siis anname

    }



    public static List<Person> getByName2(String name) {
        List<Person> vastus = new ArrayList<>();
        for (var p : listOfPeople) if (p.name.equalsIgnoreCase(name)) vastus.add(p);
        return vastus;
    }


    // selline on vaikimisi (default) konstruktor
    // kui on omatehtud, siis sellist süsteem ise ei tee
    // kui mul on mitu konstruktorit - overloadimine
    Person() {
        inimesteArv++;
    }
    //kui siia poleks inimesteArv lisatud, poleks seda konstruktorit arvestatud, ja need inimesed lisamata

    public Person(String personalId) {
        inimesteArv++;
        this.personalId = personalId;
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


