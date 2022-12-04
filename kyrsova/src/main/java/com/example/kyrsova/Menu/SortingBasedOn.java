package com.example.kyrsova.Menu;


import com.example.kyrsova.Salad.CreateSalad;
import com.example.kyrsova.Vegetable.Vegetable;

import java.util.List;
import java.util.Scanner;

/**
 * Сортування овочів для салату на основі одного з параметрів(Калорії, білки, жири, вуглеводи)
 */
public class SortingBasedOn implements MenuItem {

    @Override
    public void execute() {}


    public List<Vegetable>  sortByCallories(List<Vegetable> list){
        list.sort((x1,x2)-> (int) (x1.getCalories()*100-x2.getCalories()*100));
        new MessageforCommand().SortingMessage(1);
        list.forEach(x-> System.out.println(x.veggiePlusCalorie()));
        return list;
    }

    public List<Vegetable> sortByProteins(List<Vegetable> list){
        list.sort((x1,x2)-> (int) (x1.getProteins()*100-x2.getProteins()*100));
        new MessageforCommand().SortingMessage(2);
        list.forEach(x-> System.out.println(x.veggiePlusProteins()));
        return list;
    }
    public List<Vegetable> sortByFats(List<Vegetable> list){
        list.sort((x1,x2)-> (int) (x1.getFats()*100-x2.getFats()*100));
        new MessageforCommand().SortingMessage(3);
        list.forEach(x-> System.out.println(x.veggiePlusFats()));
        return list;
    }

    public List<Vegetable> sortByCarbohydrates(List<Vegetable> list){
        list.sort((x1,x2)-> (int) (x1.getCarbohydrates()*100-x2.getCarbohydrates()*100));
        new MessageforCommand().SortingMessage(4);
        list.forEach(x-> System.out.println(x.veggiePlusCarbo()));
        return list;
    }
}
