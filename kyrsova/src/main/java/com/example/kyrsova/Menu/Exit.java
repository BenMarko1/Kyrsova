package com.example.kyrsova.Menu;

/**
 * Для закінчення програми
 */
public class Exit implements MenuItem{

    @Override
    public void execute() {
        System.out.println("\nПрограму завершено ");
        System.exit(0);
    }
}
