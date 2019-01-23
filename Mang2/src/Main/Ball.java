package Main;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Ball extends Circle {

    double vectorX = Math.random() * 3;
    double vectorY = Math.random() * 3;

    Random rand = new Random();
    int low = 10;
    int high = 100;
    int result = rand.nextInt(high - low) + low;

    int r1 = result;
    int g1 = rand.nextInt(255);
    int b1 = rand.nextInt(255);
    int r2 = rand.nextInt(255);
    int g2 = rand.nextInt(255);
    int b2 = rand.nextInt(255);

//    Color colorRand = new Color(a, b, c);


    public Ball() {
        //näiteks:
//        Circle a = new Circle();
//        a.setRadius(30);
// aga kuna on vaja juba defineeritud asja, nt circle, extendime cirlcit balli-i mis juba on circle
        // ball juba oskab teda vastu võtta. teeme extends cirlce


        Random rand = new Random();
        int low = 10;
        int high = 56;
        int result = rand.nextInt(high - low) + low;

        this.setRadius(result);

        this.setStroke(Color.rgb(r2, g2, b2));

//           lihtne võimalus: this.setFill(Color.RED);
        this.setFill(Color.rgb(r1, g1, b1));

        this.setCenterX(100);
        this.setCenterY(100);
        handleClick();

    }


    public void fillColor() {
        int r1 = rand.nextInt(255);
        int g1 = rand.nextInt(255);
        int b1 = rand.nextInt(255);
        int r2 = rand.nextInt(255);
        int g2 = rand.nextInt(255);
        int b2 = rand.nextInt(255);
        this.setFill(Color.rgb(r1, g1, b1));
        this.setStroke(Color.rgb(r2, g2, b2));

    }

    private void handleClick() {
        this.setOnMouseClicked(event -> {
            Pane pane = (Pane) this.getParent();
            List nodes = pane.getChildren();
            int index = nodes.indexOf(this);
            nodes.remove(index);
        });
    }

    public void update() {
//        vectorX = vectorX + 1; //bouncy-bouncy

        Pane pane = (Pane) this.getParent(); //kuidas see nüüd toimibki?
        System.out.println(pane);
        double paneWidth = pane.getWidth() - this.getRadius();
        double paneHeight = pane.getHeight() - this.getRadius();
        double praeguneX = this.getCenterX();
        double uusX = praeguneX + vectorX;        //this.setCenterX(praeguneX + 1);
        double praeguneY = this.getCenterY();
        double uusY = praeguneY + vectorY;

        int min = 1;
        int max = 3;

//        double muut = Math.random() * 3; //todo: teha ta suuremaksminevaks/väiksemaks
//        double uusR = this.getRadius() + muut;

        // could be made MUCH simpler with vectorY *= -1;
        int randomNumX = ThreadLocalRandom.current().nextInt(min, max);
        int randomNumY = ThreadLocalRandom.current().nextInt(min, max);
        int randomNumAllX = ThreadLocalRandom.current().nextInt(-max, max);
        int randomNumAllY = ThreadLocalRandom.current().nextInt(-max, max);


        //another way to random:
//        private int rand(int range) {
//            return (int) (Math.random() * range);


        if (uusX > paneWidth) { // "{  }" pole tingimata vaja
            //&& uusY < paneHeight
            vectorX = -randomNumX;
            vectorY = randomNumAllY;
            fillColor();


        } else if (uusX < 0 + this.getRadius()) {
            vectorX = randomNumX;
            vectorY = randomNumAllY;
            fillColor();

        } else if (uusY < 0 + this.getRadius()) {
            vectorX = randomNumAllX;
            vectorY = randomNumY;
            fillColor();

        } else if (uusY > paneHeight) {
            vectorX = randomNumAllX;
            vectorY = -randomNumY;
            fillColor();
        }


        this.setCenterX(uusX);
        this.setCenterY(uusY);
//this.setRadius(uusR);

    }

}

//
//
//another option:
//
//
//
//
//
//package Main;
//
//import javafx.scene.layout.Pane;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Circle;
//
//import java.util.Random;
//
//public class Ball extends Circle {
//    double vectorX = Math.random() * 10;
//    double vectorY = Math.random() * 10;
//    Random rand = new Random();
////    int r = rand.nextInt(255);
////    int g = rand.nextInt(255);
////    int b = rand.nextInt(255);
//    int r1 = rand.nextInt(255);
//    int g1 = rand.nextInt(255);
//    int b1 = rand.nextInt(255);
//
//
//    public Ball() {//konsturktor
//        this.setRadius(30);
//        this.setCenterX(50);
//        this.setCenterY(50);
//    }
//
//    public void update() {// OBJEKT
//
//        Pane pane = (Pane) this.getParent();
//        double paneWidth = (pane.getWidth() - this.getRadius());
//        double paneHeight = (pane.getHeight() - this.getRadius());
//
//        double praeguneAsukohtX = this.getCenterX();
//        double uusAsukohtX = praeguneAsukohtX + vectorX;
//        if (uusAsukohtX > paneWidth || uusAsukohtX < this.getRadius()) {
//            vectorX *= -1;
//            int r = rand.nextInt(255);
//            int g = rand.nextInt(255);
//            int b = rand.nextInt(255);
//            this.setFill(Color.rgb(r, g, b));
//        }
//        this.setCenterX(uusAsukohtX);
//
//        double praeguneAsukohtY = this.getCenterY();
//        double uusAsukohtY = praeguneAsukohtY + vectorY;
//        if (uusAsukohtY > paneHeight || uusAsukohtY < this.getRadius()) {
//            vectorY *= -1;
//            int r1 = rand.nextInt(255);
//            int g1 = rand.nextInt(255);
//            int b1 = rand.nextInt(255);
//            this.setFill(Color.rgb(r1, g1, b1));
//        }
//        this.setCenterY(uusAsukohtY);
//
//
////        if(uusAsukohtY > paneHeight &) {
////            vectorY = -10;
////        }
////            this.setCenterY(uusAsukohtY);
//
//
//    }
//}
//
