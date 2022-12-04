package com.example.kyrsova.Vegetable;

/**
 * Батьківський клас овочів
 * *Гетери параметрів овочів
 * *Методи для стрінгів з характеристиками овочів
 * Перевизначений туСтрінг
 */
public class Vegetable {
    private  String name;
    private  double proteins;//білки
    private  double carbohydrates;//вуглеводи
    private  double fats;//жири
    private  double calories;//калорії

    public Vegetable(String name, double proteins, double carbohydrates, double fats, double calories) {
        this.name = name;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.calories = calories;
    }

    public String getName() {return name;}

    public double getProteins() {return proteins;}

    public double getCarbohydrates() {return carbohydrates;}

    public double getFats() {return fats;}

    public double getCalories() {return calories;}

    @Override
    public String toString() {
        return "" +
                "name - " + name +
                " proteins - " + proteins +
                " carbohydrates - " + carbohydrates +
                " fats - " + fats +
                " calories - " + calories ;
    }
    public String veggiePlusCalorie(){
        return name + " - " + calories +" калорій\n";
    }
    public String veggiePlusProteins(){
        return name + " - " + proteins +" білків\n";
    }
    public String veggiePlusFats(){
        return name + " - " + fats +" жирів\n";
    }
    public String veggiePlusCarbo(){
        return name + " - " + carbohydrates +" вуглеводів\n";
    }
}
