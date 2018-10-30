package com.company.game.utils;

import com.company.game.constants.OpponentConfig;

import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * DisplayUtil class will have methods to print on the console to interact with user
 */
public class DisplayUtil {

    public static void printWelcomeMsg(){
        printToConsole("Welcome to GTA");
        printToConsole(" ");
        printToConsole("1) Start Game");
        printToConsole("2) Exit");
        space();
    }

    public static void printInitialMsg(){
        printToConsole("1) Create player");
        printToConsole("2) Play Game");
        printToConsole("3) Save Game");
        printToConsole("4) Resume Game");
        printToConsole("5) Exit");
        space();
    }

    public static void printPlayGameMsg(){
        printToConsole("Where would you like to go :");
        printToConsole("1) Drive to Casino, earn money");
        printToConsole("2) Drive to Fight Arena");
        printToConsole("3) Drive to Shopping Mall to Gun shop");
        printToConsole("4) Drive to Gym, maintain your health");
        printToConsole("5) Drive to Restaurant, eat well! ");
        printToConsole("6) Go Home!");
        space();
    }

    public static void printCasinoMsg(){
        printToConsole("Welcome to Casino!");
        printToConsole("1) Play Jackpot");
        printToConsole("2) Leave the place");
        space();
    }

    public static void printJackPotMsg(){
        printToConsole("Lets play Jackpot!");
        space();
    }

    public static void printGymMsg(){
        printToConsole("Welcome to Gym!");
        printToConsole("1) Beginner workout");
        printToConsole("2) Intermediate workout");
        printToConsole("3) Extensive workout");
        printToConsole("4) Leave the place");
        space();
    }

    public static void printRestaurantMsg(){
        printToConsole("Welcome to Restaurant!");
        printToConsole("1) Eat Pizza");
        printToConsole("2) Eat Burger");
        printToConsole("3) Eat Cake");
        printToConsole("4) Leave the place");
        space();
    }

    public static void printGunShopMsg(){
        printToConsole("Welcome to Gun shop!");
        printToConsole("1) Buy Gun");
        printToConsole("2) Buy Bomb");
        printToConsole("3) Buy Bullets");
        printToConsole("4) Buy Rocket Launcher");
        printToConsole("5) Leave the place");
        space();
    }

    public static void printToConsole(String input) {
        System.out.println(input);
    }

    public static void printInSameLine(String input) {
        System.out.print(input);
    }

    public static void space() {
        for (int i = 1; i < 2; i++) {
            printToConsole("\n");
        }
    }


    public static void simulateLoading() {
        DisplayUtil.space();
        IntStream.range(0, 10).forEach(value -> {

                    try {
                        printInSameLine(".");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        DisplayUtil.printToConsole("Oops, that was not expected. Its taken care!");
                    }
                }
        );
        DisplayUtil.printToConsole("");

    }

    public static void printOpponentList() {

        Stream.of(OpponentConfig.values()).forEach(opponentConfig -> {
            DisplayUtil.printToConsole(opponentConfig.getId() + ") "+ opponentConfig.getName() + " Health: "+ opponentConfig.getHealth());
        });
    }
}
