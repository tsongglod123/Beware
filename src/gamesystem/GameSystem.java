package gamesystem;

public class GameSystem {
    
    private static boolean checkWin = false;
    private static boolean checkLose = false;
    
    void checkGameStatusLose(Player player, Map map) {
        if (player.getCurrentHP() <= 0) {
            System.out.println();
            System.out.println("============================");
            System.out.println("==--------YOU LOSE--------==");
            System.out.println("============================");
            checkLose = true;
        } else {
            checkLose = false;
        }
    }
    
    void checkGameStatusWin(Player player, Map map) {
        if (map.getArraysOfMapWithBombs()[player.getPlayerPositionY()][player.getPlayerPositionX()].equals(map.getEND_SYM())) {
            System.out.println();
            System.out.println("===========================");
            System.out.println("==--------YOU WON--------==");
            System.out.println("===========================");
            checkWin = true;
        } else {
            checkWin = false;
        }
    }

    public static boolean check_WIN() {
        return checkWin;
    }
    
    public static boolean check_LOSE() {
        return checkLose;
    }
    
    public boolean isGameEnd(boolean isEnd) {
        return isEnd;
    }
}
