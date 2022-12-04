package com.example.kyrsova.Menu;

import com.example.kyrsova.Salad.Salads;

/**
 * Сортування салатів по калоріях
 */
public class SortingSaladByCalorie implements MenuItem{
    @Override
    public void execute() {
        Salads.getInstance().getSalads().sort((x1, x2)-> (int) (x1.saladCalorie()-x2.saladCalorie()));
        System.out.println("Відсортований список салатів по калорійності(від найменшої до найбільшої)");
        Salads.getInstance().printAllBaseSalad();
    }
}
