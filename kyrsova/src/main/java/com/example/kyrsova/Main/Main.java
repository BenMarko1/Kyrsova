package com.example.kyrsova.Main;


import com.example.kyrsova.Menu.MainMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        Scanner in = new Scanner(System.in);
        while (true) {
            mainMenu.printAvailableCommands();
            int a = in.nextInt();
            mainMenu.execute(String.valueOf(a));
        }
    }
}