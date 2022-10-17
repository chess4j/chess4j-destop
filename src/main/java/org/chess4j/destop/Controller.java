package org.chess4j.destop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    public void processInput(ActionEvent e) {
        Button btn = (Button) e.getSource();
        System.out.println("Button clicked with id: " + btn.getId());
    }

}
