package userscreen;

import gamesystem.Map;
import gamesystem.Player;
import java.util.Scanner;

public class UserScreen {
    
    private String name;

    public UserScreen() {
        name = null;
    }
    
    private String getName() {
        return name;
    }
    
    public void getScene() {
        System.out.println("\n\t. . . B E W A R E . . .\n");
        System.out.println("\t1. Play game");
        System.out.println("\t2. How to play");
        System.out.println("\t3. Quit");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("choose: ");
        byte item = sc.nextByte();
        getSelectionScene(item);
    }
    
    private void getSelectionScene(byte item) {
        if (item < 1 || item > 3) {
            throw new Error("Please enter number between 1 to 3 !!!");
        } else {
            switch (item) {
                case 1 :
                    getMainScene();
                    break;
                case 2 :
                    getHowToPlayScene();
                    break;
                case 3 :
                    System.out.println("Bye~ ");
                    System.exit(0);
            }
        }
    }
    
    public void setRandom(int randomNumber, Map map, Player player) {
        getGameScene(randomNumber, map, player);
    }
    
    private void getMainScene() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        System.out.println("Hello! " + getName());
        System.out.println();
    }
    
    private void getHowToPlayScene() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t. . . HOW TO PLAY . . .\n");
        System.out.println("- Your mission is to go to the end of the map.");
        System.out.println("- Just random and let's see what you got.");
        System.out.println("- Beware! Something in this map will blow you up.");
        System.out.println("- Good luck~.");
        System.out.println();
        System.out.println("\t1. Play game");
        System.out.println("\t2. Back to menu");
        System.out.println();
        System.out.print("choose: ");
        byte item = sc.nextByte();
        if (item < 1 || item > 2) {
            throw new Error("Please enter number between 1 to 2 !!!");
        } else {
            switch (item) {
                case 1 :
                    getMainScene();
                    break;
                case 2 :
                    getScene();
                    break;
            }
        }
    }
    
    public void getGameScene(int getNumber, Map map, Player player) {
        //up=1 down=2 right=3 left=4        
        switch (getNumber) {
            case 1 :
                player.moveUp(map);
                break;
            case 2 :
                player.moveDown(map);
                break;
            case 3 :
                player.moveRight(map);
                break;
            case 4 :
                player.moveLeft(map);
                break;
        }
        System.out.println();
    }
}
