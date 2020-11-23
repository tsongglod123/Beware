package gamesystem;

import java.util.Random;

public class Map {

    private final String BOMB_SYM = "x ";
    private final String PLAYER_SYM = "\u25a0 ";
    private final String MAP_SYM = "\u25a1 ";
    private final String END_SYM = "= ";
    private int size = 0;
    private final int MAP_SIZE = 5;
    private final int BOMBS_DMG = 2;
    private final String[][] mapWithBomb;
    private String[][] originalMap;

    public Map() {
        originalMap = new String[MAP_SIZE][MAP_SIZE];
        mapWithBomb = new String[MAP_SIZE][MAP_SIZE];
        for (int i = 0; i < MAP_SIZE; ++i) {
            for (int j = 0; j < MAP_SIZE; ++j) {
                if (i == 0 && j == 0) {
                    originalMap[i][j] = PLAYER_SYM;
                    mapWithBomb[i][j] = PLAYER_SYM;
                } else if (i == MAP_SIZE - 1 && j == MAP_SIZE - 1) {
                    originalMap[i][j] = END_SYM;
                    mapWithBomb[i][j] = END_SYM;
                } else {
                    originalMap[i][j] = MAP_SYM;
                    mapWithBomb[i][j] = MAP_SYM;
                }
            }
        }
    }
    
    public Map(int sizeFromUser) {
        if (sizeFromUser < 5 || sizeFromUser > 10) {
            size = MAP_SIZE;
        } else {
            size = sizeFromUser;
        }
        originalMap = new String[size][size];
        mapWithBomb = new String[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (i == 0 && j == 0) {
                    originalMap[i][j] = PLAYER_SYM;
                    mapWithBomb[i][j] = PLAYER_SYM;
                } else if (i == size - 1 && j == size - 1) {
                    originalMap[i][j] = END_SYM;
                    mapWithBomb[i][j] = END_SYM;
                } else {
                    originalMap[i][j] = MAP_SYM;
                    mapWithBomb[i][j] = MAP_SYM;
                }
            }
        }
    }

    public int getMapSize() {
        return ((size >= MAP_SIZE) ? size : MAP_SIZE);
    }

    public int getBOMBS_DMG() {
        return BOMBS_DMG;
    }
    
    public String getBOMB_SYM() {
        return BOMB_SYM;
    }

    public String getEND_SYM() {
        return END_SYM;
    }

    public String getMAP_SYM() {
        return MAP_SYM;
    }

    public String getPLAYER_SYM() {
        return PLAYER_SYM;
    }

    public String[][] getArraysOfMapWithBombs() {
        return mapWithBomb;
    }

    public String[][] getArraysOfOriginalMap() {
        return originalMap;
    }

    public void getOriginalMap() {
        for (int yAxis = 0; yAxis < getMapSize(); ++yAxis) {
            System.out.print("\t");
            for (int xAxis = 0; xAxis < getMapSize(); ++xAxis) {
                System.out.print(originalMap[yAxis][xAxis]);
            }
            System.out.println();
        }
    }

    public void getMapWithBombs() {
        for (int i = 0; i < getMapSize(); ++i) {
            System.out.print("\t");
            for (int j = 0; j < getMapSize(); ++j) {
                System.out.print(mapWithBomb[i][j]);
            }
            System.out.println();
        }
    }

    void updatePlayerPositionOnMap(Control control) {
        for (int yAxis = 0; yAxis < getMapSize(); ++yAxis) {
            for (int xAxis = 0; xAxis < getMapSize(); ++xAxis) {
                if (yAxis == getMapSize() - 1 && xAxis == getMapSize() - 1) {
                    originalMap[yAxis][xAxis] = getEND_SYM();
                } else {
                    originalMap[yAxis][xAxis] = getMAP_SYM();
                }
                if (control.getPosition_y() == yAxis && control.getPosition_x() == xAxis) {
                    if (mapWithBomb[control.getPosition_y()][control.getPosition_x()].equals(getBOMB_SYM())) {
                        originalMap[yAxis][xAxis] = "X ";
                    } else {
                        originalMap[yAxis][xAxis] = getPLAYER_SYM();
                    }
                }
            }
        }
        getOriginalMap();
    }

    void getBombsPositionOnMap() {
        for (int yAxis = 0; yAxis < mapWithBomb.length; ++yAxis) {
            for (int xAxis = 0; xAxis < mapWithBomb[yAxis].length; ++xAxis) {
                if (mapWithBomb[yAxis][xAxis].equals(getBOMB_SYM())) {
                    System.out.print("Bomb position[index: ");
                    System.out.print("(" + yAxis + "," + xAxis + ")" + "]");
                    System.out.println();
                }
            }
        }
    }

    public void setBombsOnMap() {
        Random rand = new Random();
        for (int yAxis = 0; yAxis < mapWithBomb.length; ++yAxis) {
            int i = rand.nextInt(getMapSize());
            int j = rand.nextInt(getMapSize());
            if (i == 0 && j == 0) {
                ++j;
            } else if (i == getMapSize() - 1 && j == getMapSize() - 1) {
                --j;
            }
            for (int xAxis = 0; xAxis < mapWithBomb[yAxis].length; ++xAxis) {
                mapWithBomb[i][j] = getBOMB_SYM();
                mapWithBomb[i][(j + 2 >= getMapSize() - 1) ? getMapSize() - 2 : j + 2] = getBOMB_SYM();
            }
        }
    }   
}
