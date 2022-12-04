package com.example.kyrsova.Menu;


import com.example.kyrsova.Salad.BasicSalad;
import com.example.kyrsova.Vegetable.Vegetable;

import java.util.Scanner;

/**
 * Пошук овочів в салаті в заданому діапазоні калорійності
 */
public class FindByCalorie implements MenuItem{

    @Override
    public void execute() {}
    public void findByCalorie(Scanner scanner, BasicSalad salad){
        int vMin = 1, vMax = 1;
        int x = 0, y;

        System.out.print("Вкажіть нижнє значення діапазону калорійності(Більше за 0 і менше за 150)\n-->\t");
        while (vMin == 1){
            vMin=(rangeCalorie(x = scanner.nextInt()));
        }x = vMin;
        scanner.nextLine();
        System.out.print("Вкажіть верхнє значення діапазону калорійності(Більше за 0 і менше за 150)\n-->\t");
        while ( vMax== 1){
            vMax=(rangeCalorie(y = scanner.nextInt()));
        }y = vMax;
        scanner.nextLine();

        if (x > y) {
        int i = y;
            y = x;
            x = i;}

        new MessageforCommand().FindByCalorieRangeMessage(x, y);
        findByRange(salad, x, y);
    }

    public int rangeCalorie(int i){
        if (i <=0 || i >= 150){
            System.out.println("You miss the range, try again");
            return 1;
            }
            else {
            return i;
        }
    }


    public void findByRange(BasicSalad salad, int min, int max){
        for (Vegetable vegetable: salad.getVegetables()){
            if (vegetable.getCalories() >min && vegetable.getCalories() < max )
                System.out.println(vegetable.veggiePlusCalorie());
        }
    }

}
