package de.fh.kiel.roborally.model;

public class GameView {
    private String id;
    private String name;
    private int maxRobotCount;
    private int currentRobotCount;
    private boolean hasStarted;
    private static GameView instance = null;


    public void setGameView(String id, String name, int maxRobotCount, int currentRobotCount){
        this.id = id;
        this.name = name;
        this.maxRobotCount = maxRobotCount;
        this.currentRobotCount = currentRobotCount;
    }

    public static GameView createGameView(){
        if(instance == null){
            instance = new GameView();
        }
        return instance;
    }

    private GameView(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCurrentRobotCount() {
        return currentRobotCount;
    }

    public void setCurrentRobotCount(int currentRobotCount) {
        this.currentRobotCount = currentRobotCount;
    }

    public int getMaxRobotCount() {
        return maxRobotCount;
    }

    public void setMaxRobotCount(int maxRobotCount) {
        this.maxRobotCount = maxRobotCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasStarted() {
        return hasStarted;
    }

    public void setHasStarted(boolean hasStarted) {
        this.hasStarted = hasStarted;
    }


}
