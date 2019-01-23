package project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

//pastebin.com/1ai8UHvR

public class Main extends Application {

    ArrayList<String[]> andmebaas = new ArrayList<>(); // seda hetkel ei kasuta


    // kõige olulisemad muutujad nüüd
    static VBox tabel = new VBox();
    static int koguSumma = 0;
    static Label summaLabel = new Label();

    @Override
    public void start(Stage stage) throws Exception {


        VBox vbox = new VBox();
        vbox.setBackground(new Background(
                new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)
        ));
        Scene scene = new Scene(vbox, 400, 600);
        stage.setScene(scene);
        stage.show();

        // Sektsioon ülemine


//        Label summaLabel = new Label("600 €"); siin oli enne kuna ülal polnud
        summaLabel.setText("0€");
        summaLabel.setPadding(new Insets(45)); // laiutamine selle ümber, pixlid
        summaLabel.setFont(new Font(32));
        StackPane summaPane = new StackPane(); //stackpane-iga keskelt, mitte ülalnurgast
        summaPane.getChildren().add(summaLabel); //summaLabelpane'i laps on summaLabel
        vbox.getChildren().add(summaPane); //


        // Sektsioon keskmine
        HBox keskmineBox = new HBox();
        TextField kuluPealkiri = new TextField();
        kuluPealkiri.setPromptText("Kulu tüüp");
        TextField kuluSumma = new TextField();
        kuluSumma.setPromptText("Kulu summaLabel");
        Button liida = new Button("+");
        Button lahuta = new Button("-");
        keskmineBox.getChildren().addAll(kuluPealkiri, kuluSumma, liida, lahuta);
        vbox.getChildren().add(keskmineBox);

        // Sektsioon alumine

//        Label tabel = new Label("tabel"); - nüüd tegime üles array, võtame sealt tabeli küljest
        vbox.getChildren().add(tabel);

        // Andmete sisestamine


        lahuta.setOnMouseClicked(event -> {
            lisaAndmebaasi(kuluPealkiri.getText(), kuluSumma.getText(), true);
        });
    }


    public static void lisaAndmebaasi(String tyyp, String summa, boolean lahuta) {
        koguSumma = Integer.parseInt(summa);
        Label rida = new Label(tyyp + " " + summaLabel + "€");
        tabel.getChildren().add(rida);
        summaLabel.setText(koguSumma + "€");

    }


    public static void main(String[] args) {
        launch(args);
    }
}


