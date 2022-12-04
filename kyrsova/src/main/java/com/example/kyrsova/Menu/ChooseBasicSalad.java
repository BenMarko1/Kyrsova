package com.example.kyrsova.Menu;

import com.example.kyrsova.Salad.BasicSalad;
import com.example.kyrsova.Salad.Salads;

import java.util.Scanner;

/**
 * Під-меню для вибору базового салату і напрямок для наступних дій
 */
public class ChooseBasicSalad implements MenuItem {
    public BasicSalad salad;
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("Введіть назву бажаного салату: ");
        String saladScan = scanner.nextLine();

        for (BasicSalad basicSalad : Salads.getInstance().getSalads()) {
            if (basicSalad.getName().equals(saladScan)) {
                salad = basicSalad;
                break;
            }

        }if (salad == null)
            new Exit().execute();

        System.out.print("""
                \t\t[Оберіть дію з обраним салатом]
                1.З'їсти його
                2.Вивести повну інформацію про салат
                3.Знайти овочі в салаті в заданому діапазоні калорійності
                
                -->\t""");
        int i = scanner.nextInt();
        scanner.nextLine();
        if (i == 1)
            new MessageforCommand().EatingSaladMessage();
        else if (i == 2)
            SaladInfo.saladInfo(salad);
        else if (i == 3)
            new FindByCalorie().findByCalorie(scanner, salad);
    }

}
