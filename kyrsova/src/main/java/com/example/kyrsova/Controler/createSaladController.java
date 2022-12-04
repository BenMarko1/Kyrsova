package com.example.kyrsova.Controler;

import com.example.kyrsova.Menu.Exit;
import com.example.kyrsova.Menu.MessageforCommand;
import com.example.kyrsova.Vegetable.Vegetable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.kyrsova.Controler.listBaseSaladsControler.salad;

public class createSaladController implements Initializable {

    @FXML
    public TextField minField;
    @FXML
    public TextField maxField;
    @FXML
    public Button exitButton;
    @FXML
    public Button foodButton;
    @FXML
    public AnchorPane listPane;
    @FXML
    public AnchorPane searchPane;
    @FXML
    public AnchorPane infoPane;
    @FXML
    public ListView<String> listOfSalad;
    @FXML
    public Label infoLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        exitButton.setOnAction(event -> {
            new Exit().execute();
        });
        foodButton.setOnAction(event -> {
            new MessageforCommand().EatingSaladMessage();
        });

    }

    public void saladInfo(javafx.event.ActionEvent e){
        listPane.setDisable(true);
        listPane.setVisible(false);

        searchPane.setDisable(true);
        searchPane.setVisible(false);

        infoPane.setVisible(true);
        infoPane.setDisable(false);

        infoLabel.setText("""
                    Інформація про ваш салат: 
                    1.Загальна калорійність: """ + salad.saladCalorie() + """
                    \n2.Загальна кількість білків: """ + salad.saladProtein() + """
                    \n3.Загальна кількість жирів: """ + salad.saladFats() + """
                    \n4.Загальна кількість вуглеводів: """ + salad.saladCarbo());

    }

    public void findByKalory(javafx.event.ActionEvent e){
        listPane.setDisable(true);
        listPane.setVisible(false);

        searchPane.setDisable(false);
        searchPane.setVisible(true);

        infoPane.setVisible(false);
        infoPane.setDisable(true);
    }

    public void submitFindByKalory(javafx.event.ActionEvent e){
        int min = Integer.parseInt(minField.getText());
        int max = Integer.parseInt(maxField.getText());
        listOfSalad.getItems().clear();
        for (Vegetable vegetable: salad.getVegetables()){
            if (vegetable.getCalories() >min && vegetable.getCalories() < max )
                listOfSalad.getItems().addAll(vegetable.toString());
        }
        listPane.setDisable(false);
        listPane.setVisible(true);

        searchPane.setDisable(true);
        searchPane.setVisible(false);

        infoPane.setVisible(false);
        infoPane.setDisable(true);
    }

    public void returnToMain(javafx.event.ActionEvent e) throws IOException {
        new Controller().changeScene("MainCoocker.fxml",e);
    }

}
