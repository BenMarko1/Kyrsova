
package com.example.kyrsova.Controler;


import com.example.kyrsova.MainApplication;
import com.example.kyrsova.Menu.Exit;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller{

    private static Stage stage;//контейнер з елементами інтерфейсу
    private static Scene scene;


    public void changeScene(String name, javafx.event.ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.getInstance().getClass().getResource(name));//загрузка Fxml
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void showList(javafx.event.ActionEvent e) throws IOException{
        changeScene("listBaseSalads.fxml",e);
    }

    public void showSalad(javafx.event.ActionEvent e) throws IOException{
        changeScene("salad.fxml",e);
    }

    public void exitProgram(javafx.event.ActionEvent e){
        new Exit().execute();
    }
}
