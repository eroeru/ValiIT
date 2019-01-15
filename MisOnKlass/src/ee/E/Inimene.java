


//package ee.E;
//
//import java.util.Date;
//import java.util.GregorianCalendar;
//
//public class Inimene {
//
//    public static void main(String[] args) {
//
//
//    }
//
//
//
//    public String personalId = "0000000";
//    private String name = "tundmatu";
//
//
//    public String getName () {
//        return name;
//        } //getter meetod
//        public void setName (String name){
//            this.name = name;
//        } //setter meetod
//
//    public Person(String personalId, String name) {
//            this.name = name;
//            this.personalId = personalId;
//
//        }
//
//
////
////    public String nimi = "tundmatu"; // paneme sellele vaikimisi väärtuse
//
////    public Integer vanus;
////    public Integer kinganumber;
//
//        //järgneva meetodi nimi täpselt sama mis klassi nimi. see on konstruktor. Meetod, mis pannakse käima, kui vaja teha new Inimene
////
////    public Inimene(String uusnimi, int uusvanus) {
////        this.nimi = uusnimi;
////        this.vanus = uusvanus;
////    }
//
////
////    public Inimene(String isikukood) {
////        this.personalID = isikukood;
////    }
//
//        public int getBirthYear () {
//            return (((Integer.parseInt(personalId.substring(0, 1)) - 1) / 2) * 100 + 1800 + Integer.parseInt(personalId.substring(1, 3)));
//        }
//
//        //võib ka switch case1:case2: saj = 1800
//        // 3: 4: 1900
//        // 5: 6 2000
//        // (ik[0]-'1')/2
//
//
//        public Date getBirthDate () {
//            return (new GregorianCalendar(
//                    getBirthYear(),
//                    Integer.parseInt(personalId.substring(3, 5)) - 1,
//                    Integer.parseInt(personalId.substring(5, 7))
//            )).getTime();
//        }
//
//        public String getBirthMonth () {
//            //vaja leida isikuk järgi sünnikuu Märts
//            //siin võib ka Map teha
////
////        String[] kuunimed = {"jaanuar", "veebruar", "märts", "aprill", "mai", "juuni", "juuli", "august", "september", "oktoober", "november", "detsember"}
////
//
//            return String.format("%tB", getBirthDate()); //näita kuup formaadis B (kuu)
//        }
//
//
////siit algavad overridetud meetodid, misiganes need on
//        public String toString () {
//            return String.format("inimene %s syndinud %td.%< %s synniaastaga %s", nimi, getBirthYear());
//        }
//
//
//        public String getBirthDayofMonth;
//
//
//        //nüüd olemas ka vaikimisi (default) konstruktor, millel pole muud teha kui küsida op sysilt mälu:
//        // kui on omatehtud, siis sellist süsteem ise ei tee
//        // kui mul on mitu konstruktorit - see on overloadimine
//
//    public Inimene() {
//        }
//
//
////    public String toString() {
////        return String.format("inimene on %s vanusega %s%n", nimi, vanus);
////    }
//
//    }
