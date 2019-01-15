package ee.E;

import java.util.Date;
import java.util.GregorianCalendar;

public class Person {

    private String personalId = "00000000000";
    private String name = "unknownName"; //väljaspool klassi enam muuta ei saa, tegime private'iks

    public String getName() {
        return name;
    } //lugemiseks getter

    public void setName(String name) { //kirjutamiseks setter - mõlemad nad moodused et... klassist välja lugeda? ka teises .java-s?
        this.name =
                name.length() < 1 ? "unknown" :
//        this.name =
                        name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase(); //saab, aga allub rangele kontrollile //ainult 1 substring, siis alates sellest. ignob kui vähem tähti.
    }

    // see siin on konstruktor
    public Person(String personalId, String name) {
        this.name = name;
        this.personalId = personalId;
    }

    // selline on vaikimisi (default) konstruktor
    // kui on omatehtud, siis sellist süsteem ise ei tee
    // kui mul on mitu konstruktorit - overloadimine
    Person() {
    }


    public Person(String personalId) {
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

    public Gender getGender() { // gender enda oma - enum tüüpi klass
        if (Integer.parseInt(personalId.substring(0, 1)) % 2 == 0)
            return Gender.NAINE;
        else
            return Gender.MEES;
    }

}


