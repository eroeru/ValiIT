package Main;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.List;


public class Game {
    public int stageWidth;
    int stageHeight;
    Pane root = new Pane();
    Ball ball = new Ball();


    public Game(int width, int height) {
        stageWidth = width; // võib ka teha this.width, juhul kui ülal class game all on width
        stageHeight = height;
        createStage();
        createBalls();
        startGameLoop(); //tick - on üks frame, ajaühik, hetk

    }

    private void startGameLoop() {
        AnimationTimer loop = new AnimationTimer() {

            @Override
            public void handle(long l) {


//                List<Node> pallid = root.getChildren(); // node'id on kõik circlid ja triangle'id jne
                // for tsükkel iga palli kohta
                ball.update();




            }
        };
        loop.start();
    }

    private void createBalls() {
//        Ball b = new Ball(); //ülaldefineeritud juba
        root.getChildren().add(ball);
        //extendida circle klassi
    }

    private void drawCircles() {

        Stage stage = new Stage();
        Circle ring = new Circle(30);

    }

    private void createStage() {
        Stage stage = new Stage();
        stage.setScene(new Scene(root, stageWidth, stageHeight));
        stage.show();


//            StackPane stack = new StackPane();    //ENDACOPYtu - aga ei sobi, sest StackPane paneb asjad keskele jne, kuigi lihtsam
//            Scene scene = new Scene(stack, stageWidth, stageHeight);
//            primaryStage.setScene(scene);
//
//
//
//            primaryStage.show();

    }


}
