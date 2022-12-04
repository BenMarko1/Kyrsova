package com.example.kyrsova.Menu;

import com.example.kyrsova.Salad.BasicSalad;

/**
 * Друк інформації про салат
 */
public class SaladInfo implements MenuItem{

    public BasicSalad salad;
    @Override
    public void execute() {}

    public static void saladInfo (BasicSalad salad){

        System.out.println("""
                    Інформація про ваш салат: 
                    1.Загальна калорійність: """ + salad.saladCalorie() + """
                    \n2.Загальна кількість білків: """ + salad.saladProtein() + """
                    \n3.Загальна кількість жирів: """ + salad.saladFats() + """
                    \n4.Загальна кількість вуглеводів: """ + salad.saladCarbo());
    }
}
