package com.example.kyrsova.Menu;


public class PrintMenuCommand implements MenuItem{

    @Override
    public void execute() {
        System.out.print("""

                \t\t[Головне меню]
                1.Список готових салатів
                2.Зробити власний салат
                3.Закінчити програму

                -->\t""");
    }
}