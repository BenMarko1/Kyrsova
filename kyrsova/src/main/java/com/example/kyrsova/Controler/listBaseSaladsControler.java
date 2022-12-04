/**
 * Sample Skeleton for 'listBaseSalads.fxml' Controller Class
 */

package com.example.kyrsova.Controler;

import com.example.kyrsova.Menu.Exit;
import com.example.kyrsova.Menu.SortingSaladByCalorie;
import com.example.kyrsova.Salad.BasicSalad;
import com.example.kyrsova.Salad.Salads;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class listBaseSaladsControler implements Initializable {

    @FXML // fx:id="chooseSaladButton"
    private Button chooseSaladButton;

    @FXML // fx:id="exitButton"
    private Button exitButton;

    @FXML
    private AnchorPane saladPane;
    @FXML
    private AnchorPane mySaladPane;
    @FXML
    private ListView<String> listOfSalad;

    @FXML
    private TextField saladName;

    private String saladScan;
    public static BasicSalad salad;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exitButton.setOnAction(event -> {
            new Exit().execute();
        });
        List<BasicSalad> basic = Salads.getInstance().getSalads();
        for (BasicSalad basicSalad : basic) {
            listOfSalad.getItems().addAll(basicSalad.toString());
        }
    }

    public void returnToMain(javafx.event.ActionEvent e) throws IOException{
        new Controller().changeScene("MainCoocker.fxml",e);
    }

    public void chooseSalad(javafx.event.ActionEvent e){
        saladPane.setDisable(true);
        saladPane.setVisible(false);

        mySaladPane.setDisable(false);
        mySaladPane.setVisible(true);

    }

    public void submitChooseSalad(javafx.event.ActionEvent e) throws IOException {
        saladScan = saladName.getText();
        for (BasicSalad basicSalad : Salads.getInstance().getSalads()) {
            if (basicSalad.getName().equals(saladScan)) {
                salad = basicSalad;
                break;
            }

        }
        if (salad == null)
            new Exit().execute();

        mySaladPane.setDisable(true);
        mySaladPane.setVisible(false);

        saladPane.setDisable(false);
        saladPane.setVisible(true);

        new Controller().changeScene("createSalad.fxml",e);
    }

    public void sortSaladsByCalorie(javafx.event.ActionEvent e) {
        saladPane.setDisable(false);
        saladPane.setVisible(true);
        new SortingSaladByCalorie().execute();
        List<BasicSalad> Salad = Salads.getInstance().getSalads();
        listOfSalad.getItems().clear();
        for (BasicSalad basicSalad : Salad) {
            listOfSalad.getItems().addAll(basicSalad.toString());
        }
    }
}
