package com.example.kyrsova.Salad;

import com.example.kyrsova.Vegetable.Vegetable;
import com.example.kyrsova.Vegetable.Veggie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Лист овочів, друк листа, створення салату
 */
public class CreateSalad {

    public Scanner scanner;
    List<Vegetable> veggie;

    public CreateSalad(Scanner scanner) {
        this.scanner = scanner;
        veggie=vegetables();
    }


    public static List<Vegetable> vegetables() {
        List<Vegetable> veggie=new ArrayList<>();

        veggie.add(Veggie.broccoli);
        veggie.add(Veggie.carrot);
        veggie.add(Veggie.celery);
        veggie.add(Veggie.cucumber);

        veggie.add(Veggie.corn);
        veggie.add(Veggie.garlic);
        veggie.add(Veggie.potato);
        veggie.add(Veggie.peas);

        veggie.add(Veggie.parsley);
        veggie.add(Veggie.pumpkin);
        veggie.add(Veggie.tomato);
        veggie.add(Veggie.radish);

        veggie.add(Veggie.onion);
        veggie.add(Veggie.cabbage);

        return veggie;
    }
    //показую
    public void showVeggie(){
        for(int i = 0 ;i<veggie.size();i++)
        {
            System.out.println(i+1+" "+ veggie.get(i).getName());
        }
    }

    public BasicSalad createSalad(){
        List<Vegetable> list = new ArrayList<>();
        showVeggie();
        System.out.print("Виберайте овочі, які бажаєте додати в салат, ввівши їх номера... " +
                            "(якщо передумали, то введіть 0)\n");
        int ans;
        while (true)
        {
            ans = scanner.nextInt();
            scanner.nextLine();//забрати ентер
            if(ans==0)
                break;
            list.add(veggie.get(ans-1));
        }
        System.out.print("Введіть назву салату\n-->\t");
        String name = scanner.nextLine();
        return  new BasicSalad(list,name);
    }
}
