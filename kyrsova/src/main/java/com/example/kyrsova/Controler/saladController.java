package com.example.kyrsova.Controler;

import com.example.kyrsova.Menu.Exit;
import com.example.kyrsova.Menu.SortingBasedOn;
import com.example.kyrsova.Salad.BasicSalad;
import com.example.kyrsova.Salad.CreateSalad;
import com.example.kyrsova.Salad.Salads;
import com.example.kyrsova.Vegetable.Vegetable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class saladController implements Initializable {

    @FXML
    private CheckBox brocoli;
    @FXML
    private CheckBox carrot;
    @FXML
    private CheckBox celery;
    @FXML
    private CheckBox cucumber;
    @FXML
    private CheckBox corn;
    @FXML
    private CheckBox garlic;
    @FXML
    private CheckBox potato;
    @FXML
    private CheckBox peas;
    @FXML
    private CheckBox parsley;
    @FXML
    private CheckBox pumpkin;
    @FXML
    private CheckBox tomato;
    @FXML
    private CheckBox radish;
    @FXML
    private CheckBox onion;
    @FXML
    private CheckBox cabbage;
    @FXML
    private AnchorPane sortPane;
    @FXML
    private AnchorPane listPane;
    @FXML
    private AnchorPane createPane;
    @FXML
    private Button exitButton;
    @FXML
    private ListView<String> listOfSalad;
    @FXML
    private ChoiceBox<String> sortTypes;

    @FXML
    private TextField saladName;

    private String[] sort = {"Калорійність","Білки", "Жири", "Вугляводи"};

    private String sortType;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        exitButton.setOnAction(event -> {
            new Exit().execute();
        });
        sortTypes.getItems().addAll(sort);
        sortTypes.setOnAction(this::getSortType);
        List<Vegetable> list = CreateSalad.vegetables();
        for (Vegetable veg : list) {
            listOfSalad.getItems().addAll(veg.toString());
        }
    }

    public void createSalad(javafx.event.ActionEvent e){
        createPane.setVisible(true);
        createPane.setDisable(false);

        sortPane.setVisible(false);
        sortPane.setDisable(true);

        listPane.setVisible(false);
        listPane.setDisable(true);
    }

    public void submitCreateSalad(javafx.event.ActionEvent e) throws IOException {
        List<Vegetable> veggie = new CreateSalad(new Scanner(System.in)).vegetables();
        List<Vegetable> list = new ArrayList<>();

        if(brocoli.isSelected()){
            list.add(veggie.get(0));
        }
        if(carrot.isSelected()){
            list.add(veggie.get(1));
        }
        if(celery.isSelected()){
            list.add(veggie.get(2));
        }
        if(cucumber.isSelected()){
            list.add(veggie.get(3));
        }
        if(corn.isSelected()){
            list.add(veggie.get(4));
        }
        if(garlic.isSelected()){
            list.add(veggie.get(5));
        }
        if(potato.isSelected()){
            list.add(veggie.get(6));
        }
        if(peas.isSelected()){
            list.add(veggie.get(7));
        }
        if(parsley.isSelected()){
            list.add(veggie.get(8));
        }
        if(pumpkin.isSelected()){
            list.add(veggie.get(9));
        }
        if(tomato.isSelected()){
            list.add(veggie.get(10));
        }
        if(radish.isSelected()){
            list.add(veggie.get(11));
        }
        if(onion.isSelected()){
            list.add(veggie.get(12));
        }
        if(cabbage.isSelected()){
            list.add(veggie.get(13));
        }


        String name = saladName.getText();
        listBaseSaladsControler.salad = new BasicSalad(list,name);

        createPane.setVisible(false);
        createPane.setDisable(true);

        sortPane.setVisible(false);
        sortPane.setDisable(true);

        listPane.setVisible(true);
        listPane.setDisable(false);

        new Controller().changeScene("createSalad.fxml",e);
    }

    public void getSortType(javafx.event.ActionEvent e){ sortType = sortTypes.getValue(); }

    public void sortVegetables(javafx.event.ActionEvent e){
        sortPane.setVisible(true);
        sortPane.setDisable(false);

        listPane.setDisable(true);
        listPane.setVisible(false);
    }

    public void submitSortVegetables(javafx.event.ActionEvent e){
            int s = 0;
            for(int i = 0; i < sort.length; i++){
                if(sort[i].equals(sortType)){
                    s = i + 1;
                    break;
                }
            }

            sortPane.setVisible(false);
            sortPane.setDisable(true);

            listOfSalad.getItems().clear();

            if (s == 1) {
                List<Vegetable> list = CreateSalad.vegetables();
                new SortingBasedOn().sortByCallories(list);
                for (Vegetable veg : list) {
                    listOfSalad.getItems().addAll(veg.veggiePlusCalorie());
                }
            }else if (s == 2) {
                List<Vegetable> list = CreateSalad.vegetables();
                new SortingBasedOn().sortByProteins(list);
                for (Vegetable veg : list) {
                    listOfSalad.getItems().addAll(veg.veggiePlusProteins());
                }
            }else if (s == 3) {
                List<Vegetable> list = CreateSalad.vegetables();
                new SortingBasedOn().sortByFats(list);
                for (Vegetable veg : list) {
                    listOfSalad.getItems().addAll(veg.veggiePlusFats());
                }
            }else if (s == 4) {
                List<Vegetable> list = CreateSalad.vegetables();
                new SortingBasedOn().sortByCarbohydrates(list);
                for (Vegetable veg : list) {
                    listOfSalad.getItems().addAll(veg.veggiePlusCarbo());
                }
            }else{
                new Exit().execute();
            }

            listPane.setDisable(false);
            listPane.setVisible(true);

    }

    public void returnToMain(javafx.event.ActionEvent e) throws IOException {
        new Controller().changeScene("MainCoocker.fxml",e);
    }
}
