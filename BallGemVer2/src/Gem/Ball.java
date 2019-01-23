package Gem;

import javafx.scene.layout.Pane;

import java.util.List;

public abstract class Ball implements Mover { //abstract - extendime, template'i loome et seda teha. update kirjeldat, move'i mitte nt. abstraktne, st ei saa kasutada, aga peaaegu. kirjeldada kuidas struktuuri. interface'i üldse mitte, aint kirjeldused mis peab olema

    public Ball() {
        handleClick();
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

    }

    private void move() {

    };

   private void limit(){

   }



}
