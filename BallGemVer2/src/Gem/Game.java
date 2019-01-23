package Gem;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Game {
    public int stageWidth;
    int stageHeight;
    Pane root = new Pane();
    Ball ball = new Ball();
    ArrayList<Ball> balls = new ArrayList<>();
    Stage stage = new Stage();


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
                root.getChildren().forEach(node -> {
                    Ball ball = (Ball) node;
                    ball.update();
                });
                if (root.getChildren().size() == 0){
                    Circle gg = new Circle(100, 100, 100);
                    StackPane sp = new StackPane();
                    sp.getChildren().add(gg);
                    stage.setScene(new Scene(sp, stageWidth, stageHeight));
                }



//                balls.forEach(ball -> ball.update()); - vana, enne mouseclicki

//                List<Node> pallid = root.getChildren(); // node'id on kõik circlid ja triangle'id jne
                // for tsükkel iga palli kohta


            }
        };
        loop.start();
    }

    private void createBalls() {
//        Ball b = new Ball(); //ülaldefineeritud juba
        Random rand = new Random();
        int q = rand.nextInt(100);
        for (int i = 0; i < q; i++) {
            Ball ball = new Ball();
            balls.add(ball);
            root.getChildren().add(ball);
            //extendida circle klassi
        }
//
//        private void drawCircles() {
//
//            Stage stage = new Stage();
//            Circle ring = new Circle(30);
//
    }

    private void createStage() {

        stage.setScene(new Scene(root, stageWidth, stageHeight));
        stage.show();


    }


}
