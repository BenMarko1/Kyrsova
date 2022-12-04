package com.example.kyrsova;

import com.example.kyrsova.Menu.MainMenu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class MainApplication extends Application {
    static MainApplication instance;
    @Override
    public void start(Stage primaryStage) throws Exception{
        instance = this;
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource("MainCoocker.fxml")));//перше вікно
        primaryStage.setTitle("Master chef");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
    }


    public static void main(String[] args){
        new MainMenu().initialize();
        launch(args);
    }

    public Class<? extends MainApplication> classRet(){
        return getClass();
    }

    public static MainApplication getInstance() {return instance;}
}
