package ee.E;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// SQL
        // peaksin esimese asjana välja ehitama connection url-i. server, blabla, kasutaja, parool jne. connection string.


        String hostName = "hennusql.database.windows.net";
        String dbName = "Northwind";
        String user = "Student";
        String password = "Pa$$w0rd";

        //järgnev võtab blablabla ruumi, seega try asi järgneb

        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;" + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        // palun räägi mulle, mis on need neli tähte sul seal connection urli alguses


try (Connection connection = DriverManager.getConnection(url)) { //seda minimaalselt vaja, et oleks koht kuhu päring saata. drivermanager teeb connectioni. vaja ette anda url-e
// selleks et teha connectioni läksime veelkord try juurde, et sinna sisse panna

    Scanner scan = new Scanner(System.in);
    System.out.print("Anna tootekood: ");
    int productId = scan.nextInt();
    System.out.print("Anna uus hind: ");
    double unitPrice = scan.nextDouble();


    String updateSql  =
            String.format(
//            "update products set unitprice = 100 where productid = 76"; //see üksi ilma string.formatita ei toimind, sestap eelnev
    "update products set unitprice = %s where productid = %s"
                    , unitPrice, productId
            ); //tõstame hinda vms omal soovil



    String selectSql = "select CategoryName, ProductName, UnitPrice "
            + "FROM Products p "
            + "JOIN Categories c on p.CategoryID = c.CategoryID";


    Statement update = connection.createStatement();
    var kinnitus = update.executeUpdate(updateSql); //näitab mitu rida muudeti


    try (Statement statement = connection.createStatement(); //conncetionil olemas meetod createstatement, mis annab sql statementi.
         // execute query annan ette stringi mis sisaldab päringut. resultset annab vastuse mille andmebaasist sain
         ResultSet resultSet = statement.executeQuery(selectSql)){
        while(resultSet.next()) { //järjehoidja, next paneb edasi, vaatab kas on kirje. siin sees saab trükkida välja igast asju.
            System.out.printf("%s %s %s%n",
                    resultSet.getString(1), //indeks algab ühest. sql. andmebaasides. getString, double int mis loeb resultsetist veergusid, või set veergudel mis parameetreid asend, loetakse veerge alates 1-st.
                    resultSet.getString(2),
                    resultSet.getDouble(3)

            );

        }
            }



} catch (Exception e) {
            System.out.println(e.getMessage());
        }





    }

}


// SQL injection. kui lisan koodi vms asemel: Lollakas' --
// muudab kõik lollakateks. tooted
// 000AAA'; Shutdown--
// kui kiiruskaamera loeb, shut down

// Admin'-- nimetada

//kuidas SQL injectione ära hoida:
// Näide SQL Injectioni vältimisest onenotest

// String updateSql asemel ei update'i, vaid et ongi nii. küsimärk lisaks. peale seda prepareStatement(upDateSql);



//
//String updateSql =
//
//        "update products set unitprice = ? where productid = ?"
//        ;
//String selectSql = jan
//Statement update = connection.prepareStatement(updateSql);
//((PreparedStatement) update.setDouble(1, unitPrice);
//        ((PreparedStatement) update).setInt(2, productid);
//var kinnitus = update.executeUpdate(updateSql);




// String.format("update products set productname = '%s' where productid = %s", uusnimi, kood)
//uusnimi = "Kapsapea"

//kood = 14

//tulemuseks oleks lause update products set productname = 'Kapsapea' where productid = 14

// AGA KUI TULEB HÄKKER, ja ütleb et uusnimi = "Kapsapea'--" ja kood = 14, siis update lause tuleb:
//update products set productname = 'Kapsapea'--' where productid = 14 , seda -- alates ei vaata. kõik tooted nimetat ümber kapsapeaks. mitte ainult 14.

// see oli veel hea häkker. halb ütlem
//uusnimi = "Kapsapea';drop table customers--"
//või delete customers drop talbe asemel. kustutatakse andmeb ära klientide table.

//SEEPÄRAST EI TOHI KASUTADA STRINGI KOKKUPANEMIST KÄSITSI EI FORMATIGA EGA LIITMISEGA; VAID TEHNIKAT ET PANED ? MARKEERIDES; SEEJÄREL MITE CREATE STATEMENT;
//VAID PREPARESTATEMENT KUS ? SEES; SIIS ÜTLED ET UUENDA; SETDOUBLE UNITPRICE. TULEB KASUTADA PARAMEETRITEGA SQL STATEMENTE



