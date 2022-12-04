package com.example.kyrsova.Menu;

import com.example.kyrsova.Salad.Salads;

/**
 * Готові повідомлення
 */
public class MessageforCommand implements MenuItem{


    public void BasicSaladMessage(){
        System.out.println("Список готових салатів: ");
        Salads.getInstance().printAllBaseSalad();
    }


    public void SortingMessage(int sort){
        if (sort == 1)
            System.out.println("Овочі відсортовані по калорійності :");
        else if (sort == 2)
            System.out.println("Овочі відсортовані по вмісту білків :");
        else if (sort == 3)
            System.out.println("Овочі відсортовані по вмісту жирів :");
        else if (sort == 4)
            System.out.println("Овочі відсортовані по вмісту вуглеводів :");
    }

    public void FindByCalorieRangeMessage(int min, int max){

        System.out.println("Овочі в заданому діапазоні калорійності: " +min +"-" + max);
    }

    public void EatingSaladMessage(){
        System.out.println("Ви з'їли салат\nСподіваємось вам смакувало;)");
        new Exit().execute();
    }

    @Override
    public void execute() {

    }
}
