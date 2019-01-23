package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        Pane root = new Pane();
//        StackPane stack = new StackPane();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));



        //root asemel oleks stack, näite järgi
//        Scene scene = new Scene(stack, 150, 150); //lisaosa, näide ringi tegemiseks
//        primaryStage.setScene(scene);

        Circle ring = new Circle(30);
        root.getChildren().add(ring);
//        stack.getChildren().add(ring);

        Rectangle kast = new Rectangle(20,20,40,80); //4 arvu vaja, sest ristkülikku teeb nende järgi
        kast.setFill(Color.BLUE);
        root.getChildren().add(kast);

        kast.setOnMouseClicked(klikk -> {
            if (kast.getFill() == Color.RED) {
                kast.setFill(Color.BLUE);
                kast.setRotate(10);
            }
            else{
                kast.setFill(Color.RED);
                kast.setRotate(-10);
            }
        });



//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml")); //algne osa, versioon tühjast XML Hello World aknast, ilma ringita
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));

//
//
//        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
