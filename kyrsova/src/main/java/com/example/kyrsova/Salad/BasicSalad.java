package com.example.kyrsova.Salad;


import com.example.kyrsova.Vegetable.Vegetable;

import java.util.List;


public class BasicSalad {
    String name;
    List<Vegetable> vegetables;

    public BasicSalad(List<Vegetable> vegetables, String name) {
        this.vegetables = List.copyOf(vegetables);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Vegetable> getVegetables() {
        return vegetables;
    }

    @Override
    public String toString() {
        StringBuilder ingredients = new StringBuilder();
        for (Vegetable vegetable : vegetables) {
            ingredients.append(vegetable.getName()).append("\n");
        }

        return "Салат: " + name + "\n" +
                "Інгредієнти:\n" +
                ingredients +
                "Калорійність: " + saladCalorie() +"\n";
    }

    /**
     * Підрахунок загальної характеристики салату
     *
     */
    public double saladCalorie() {
        double generalCalorie = 0;
        for (Vegetable vegetable : vegetables) {
            generalCalorie += vegetable.getCalories();
        }
        return generalCalorie;
    }

    public double saladProtein() {
        double generalProtein = 0;
        for (Vegetable vegetable : vegetables) {
            generalProtein += vegetable.getProteins();
        }
        return generalProtein;
    }

    public double saladFats() {
        double generalFats = 0;
        for (Vegetable vegetable : vegetables) {
            generalFats += vegetable.getFats();
        }
        return generalFats;
    }

    public double saladCarbo() {
        double generalCarbo = 0;
        for (Vegetable vegetable : vegetables) {
            generalCarbo += vegetable.getCarbohydrates();
        }
        return generalCarbo;
    }
}
