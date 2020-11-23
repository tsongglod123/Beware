package gamesystem;

public class Control {
    
    private int move_x;
    private int move_y;

    public Control() {
        move_x = 0;
        move_y = 0;
    }

    Control moveLeft(Player player, Map map) {
        GameSystem gameSystem = new GameSystem();
        --move_x;
        if (move_x < 0) {
            move_x = map.getMapSize() - 1;
        }
        player.getCurrentPlayerPosition(map, this);
        if (player.isPlayerStepOnBombs(map)) {
            gameSystem.checkGameStatusLose(player, map);
        } else {
            gameSystem.checkGameStatusWin(player, map);
        }
        return this;
    }

    Control moveRight(Player player, Map map) {
        GameSystem gameSystem = new GameSystem();
        ++move_x;
        if (move_x > map.getMapSize() - 1) {
            move_x = 0;
        }
        player.getCurrentPlayerPosition(map, this);
        if (player.isPlayerStepOnBombs(map)) {
            gameSystem.checkGameStatusLose(player, map);
        } else {
            gameSystem.checkGameStatusWin(player, map);
        }
        return this;
    }

    Control moveUp(Player player, Map map) {
        GameSystem gameSystem = new GameSystem();
        --move_y;
        if (move_y < 0) {
            move_y = map.getMapSize() - 1;
        }
        player.getCurrentPlayerPosition(map, this);
        if (player.isPlayerStepOnBombs(map)) {
            gameSystem.checkGameStatusLose(player, map);
        } else {
            gameSystem.checkGameStatusWin(player, map);
        }
        return this;
    }

    Control moveDown(Player player, Map map) {
        GameSystem gameSystem = new GameSystem();
        ++move_y;
        if (move_y > map.getMapSize() - 1) {
            move_y = 0;
        }
        player.getCurrentPlayerPosition(map, this);
        if (player.isPlayerStepOnBombs(map)) {
            gameSystem.checkGameStatusLose(player, map);
        } else {
            gameSystem.checkGameStatusWin(player, map);
        }
        return this;
    }

    int getPosition_x() {
        return move_x;
    }

    int getPosition_y() {
        return move_y;
    }
}
