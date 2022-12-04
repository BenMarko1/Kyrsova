package com.example.kyrsova.Salad;


import java.util.ArrayList;
import java.util.List;

/**
 * Клас для списку салатів(Отримання, друк усіх)
 */
public class Salads {
    private static Salads instance;
    List<BasicSalad> salads;

    public Salads() {
        salads = new ArrayList<>();
    }

    public static Salads getInstance() {
        if (instance == null)
            instance = new Salads();
        return instance;
    }

    //отримання всіх салатів
    public List<BasicSalad> getSalads() {
        return salads;
    }

    public void printAllBaseSalad(){
        for (BasicSalad basicSalad: salads){
            System.out.println(basicSalad);
        }
    }

}
