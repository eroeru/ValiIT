package Main;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.concurrent.ThreadLocalRandom;

public class Ball extends Circle {

    double vectorX = 10;
    double vectorY = 0;


    public Ball() {
    //näiteks:
//        Circle a = new Circle();
//        a.setRadius(30);
// aga kuna on vaja juba defineeritud asja, nt circle, extendime cirlcit balli-i mis juba on circle
        // ball juba oskab teda vastu võtta. teeme extends cirlce

            this.setRadius(30);
            this.setFill(Color.CYAN);
            this.setCenterX(100);
            this.setCenterY(100);

    }


    public void update() {
//        vectorX = vectorX + 1; //bouncy-bouncy

        double praeguneX = this.getCenterX();
        double uusX = praeguneX + vectorX;        //this.setCenterX(praeguneX + 1);
        double praeguneY = this.getCenterY();
        double uusY = praeguneY + vectorY;
        Pane pane = (Pane) this.getParent(); //kuidas see nüüd toimibki?
        double paneWidth = pane.getWidth() - this.getRadius();
        double paneHeight = pane.getHeight() - this.getRadius();
        int min = 1;
        int max = 10;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

        if (uusX > paneWidth) { // "{  }" pole tingimata vaja
            //&& uusY < paneHeight
            vectorX = -10;
            vectorY = randomNum;
//            uusX = paneWidth;

        } else if (uusX < 0 + this.getRadius()) {
            vectorX = 10;
            vectorY = randomNum;

        } else if (uusY < 0 + this.getRadius()) {
            vectorX = randomNum;
            vectorY = 10;

        } else if (uusY > paneHeight) {
            vectorX = randomNum;
            vectorY = -10;
        }

//        } else if (uusY)

            this.setCenterX(uusX);
        this.setCenterY(uusY);


    }

}
