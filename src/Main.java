import java.util.Scanner;
import gamesystem.Map;
import gamesystem.GameSystem;
import gamesystem.Player;
import java.util.Random;
import userscreen.UserScreen;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserScreen screen = new UserScreen();
        Random random = new Random();
        
        char decide;
        int randomNumber = 0;

        screen.getScene();

        //loop stage
        do {
            Player player = new Player();
            Map map = new Map();
            GameSystem gameSystem = new GameSystem();
            
            map.setBombsOnMap();
            System.out.println("-----BOMBS HAVE BEEN PLATED-----");
            
            System.out.println();
            System.out.println("=============================");
            System.out.println("==--------S T A R T--------==");
            System.out.println("=============================");
            System.out.println();
            map.getOriginalMap();
            System.out.println("Your starting position is (0,0)");
            System.out.println("And your HP is 20. Good luck!");
            System.out.println();
            
            while (player.getCurrentHP() != 0) {
                System.out.print("Input \"r\" for random numbers (Another input = exit): ");
                String input = sc.next();
                System.out.println();
                if (input.isBlank()) {
                    throw new Error("Please input \"r\" for random numbers!!!");
                } else if (!input.equals("r")) {
                    System.exit(0);
                } else {
                    randomNumber = random.nextInt(4) + 1;
                }
                
                screen.setRandom(randomNumber, map, player);
                
                boolean tempWin = gameSystem.isGameEnd(GameSystem.check_WIN());
                if (tempWin) {
                    break;
                }
            }
            System.out.print("Try again? (y/n): ");
            decide = sc.next().charAt(0);
            System.out.println();
        } while (decide == 'y' || decide == 'Y');
    }
}
