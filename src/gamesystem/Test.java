package gamesystem;

import java.util.Scanner;

public class Test {
    /*
    public static void main(String[] args) {
        test();
    }
    */
    static void test() {
        var map = new Map();
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        var player = new Player();
        
        player.getCurrentHP_bar();
        map.setBombsOnMap();
        map.getMapWithBombs();
        map.getBombsPositionOnMap();
        System.out.println();
        player.moveLeft(map);
        player.moveRight(map);
        player.moveDown(map);
        player.moveDown(map);
        player.moveDown(map);
        player.moveDown(map);
        player.moveDown(map);
        player.moveUp(map);
        player.moveUp(map);
        player.moveUp(map);
        player.moveRight(map).moveRight(map).moveRight(map).moveRight(map).moveLeft(map);
        player.moveDown(map).moveDown(map).moveDown(map);
        player.moveRight(map);
        player.moveDown(map).moveDown(map).moveDown(map);
        
    }
}
