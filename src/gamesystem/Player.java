package gamesystem;

public class Player {
    
    private final int MAX_HP = 20;
    private int currentHP;
    private final Control control;

    public Player() {
        control = new Control();
        currentHP = MAX_HP;
    }
    
    void getCurrentHP_bar() {
        System.out.print("PLAYER" + "[HP: " + getCurrentHP() + "]: ");
        for (int i = 0; i < currentHP; ++i) {
            System.out.print("\u25a0");
        }
        System.out.println();
    }

    public int getCurrentHP() {
        return currentHP;
    }
    
    void getCurrentPlayerPosition(Map map, Control control) {
        map.updatePlayerPositionOnMap(control);
        System.out.print("Player position: " + "(" + control.getPosition_y() + "," + control.getPosition_x() + ")");
        System.out.print(isPlayerStepOnBombs(map) ? " BOOM!!!\n" : "\n");
        if (isPlayerStepOnBombs(map)) {
            currentHP = getCurrentHP() - map.getBOMBS_DMG();
        }
        getCurrentHP_bar();
    }

    public Player moveLeft(Map map) {
        control.moveLeft(this, map);
        return this;
    }

    public Player moveRight(Map map) {
        control.moveRight(this, map);
        return this;
    }

    public Player moveUp(Map map) {
        control.moveUp(this, map);
        return this;
    }

    public Player moveDown(Map map) {
        control.moveDown(this, map);
        return this;
    }
    
    public int getPlayerPositionY() {
        return control.getPosition_y();
    }
    
    public int getPlayerPositionX() {
        return control.getPosition_x();
    }

    boolean isPlayerStepOnBombs(Map map) {
        String playerPosition = map.getArraysOfMapWithBombs()[control.getPosition_y()][control.getPosition_x()];
        boolean check = playerPosition.equals(map.getBOMB_SYM());
        return check;
    }
}
