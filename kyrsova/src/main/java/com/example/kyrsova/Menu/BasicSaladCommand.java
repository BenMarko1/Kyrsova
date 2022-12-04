package com.example.kyrsova.Menu;

import com.example.kyrsova.Salad.Salads;
import com.example.kyrsova.Vegetable.Vegetable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BasicSaladCommand implements MenuItem{

    public List<Vegetable> list;
    private Map<String, MenuItem> menuItems;
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        MessageforCommand message = new MessageforCommand();
        message.BasicSaladMessage();

        Salads.getInstance();
        System.out.print("""
                \t\t[Оберіть наступну дію:]
                1.Обрати салат
                2.Відсортувати салати по калорійності
                
                -->\t""");
        String command = scanner.nextLine();
        menuItems = new LinkedHashMap<>();
        menuItems.put("1", new ChooseBasicSalad());
        menuItems.put("2", new SortingSaladByCalorie());

        menuItems.getOrDefault(command, () -> System.out.println("\"Такої команди нема, введіть знову\""))
                .execute();

    }

}
