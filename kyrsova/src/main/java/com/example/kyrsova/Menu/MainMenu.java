package com.example.kyrsova.Menu;

import com.example.kyrsova.Salad.BasicSalad;
import com.example.kyrsova.Salad.Salads;
import com.example.kyrsova.Vegetable.*;
import com.example.kyrsova.Vegetable.Vegetable;
import com.example.kyrsova.Vegetable.Veggie;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Для початку програми і створення листа базових салатів ще на початку програми
 */


public class MainMenu {
    private Map<String, MenuItem> menuItems;
    public MainMenu(){
        initialize();

        menuItems = new LinkedHashMap<>();
        menuItems.put("1", new BasicSaladCommand());
        menuItems.put("2", new MakeSaladCommand());
        menuItems.put("3", new Exit());

    }

    public void initialize(){
        List<Vegetable> list = new ArrayList<Vegetable>();

        list.add(Veggie.tomato);
        list.add(Veggie.onion);
        list.add(Veggie.cucumber);
        Salads.getInstance().getSalads().add(new BasicSalad(list, "Tomato and Cucumber"));
        list.clear();

        list.add(Veggie.tomato);
        list.add(Veggie.onion);
        list.add(Veggie.corn);
        Salads.getInstance().getSalads().add(new BasicSalad(list, "Summer corn"));
        list.clear();

        list.add(Veggie.tomato);
        list.add(Veggie.broccoli);
        list.add(Veggie.potato);
        list.add(Veggie.parsley);
        Salads.getInstance().getSalads().add(new BasicSalad(list, "Fresh broccoli"));
        list.clear();

        list.add(Veggie.cucumber);
        list.add(Veggie.carrot);
        list.add(Veggie.corn);
        Salads.getInstance().getSalads().add(new BasicSalad(list, "Sweet carrot"));
        list.clear();

        list.add(Veggie.tomato);
        list.add(Veggie.onion);
        list.add(Veggie.celery);
        list.add(Veggie.peas);
        Salads.getInstance().getSalads().add(new BasicSalad(list, "Crunchy peas"));
        list.clear();
    }

    public void execute(String command){
        menuItems.getOrDefault(command, () -> System.out.println("\"Такої команди нема, введіть знову\""))
                .execute();
    }

    public void printAvailableCommands(){
        new PrintMenuCommand().execute();
    }

}
