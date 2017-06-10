package de.fh.kiel.roborally.model;

/**
 * A State of a game represents the current games state. A game starts in a joining state, where all the players can
 * join a game. Then all the Phases follow and at last the game is finished and someone has won.
 *
 * @author jpr
 */
public enum State {
    /**
     * Game has not started yet and waits for players to join.
     */
    JOINING(300),
    /**
     * Players can by upgrades; this is the Upgrade Phase of the game
     */
    UPGRADE(0),
    /**
     * This is part of the Programming Phase.
     * Players can now choose their registers.
     */
    PROGRAMMING_START(180),
    /**
     * This is part of the Programming Phase. Either one Player has finished is Programming Phase or a timeout has been
     * reached. Each player now has to submit their program.
     */
    PROGRAMMING_END(30),
    /**
     * This is the Activation Phase of the game. The game will now calculate all the moves and effects.
     */
    ACTIVTATION(30),
    /**
     * The game is over -- someone has won :)
     */
    FINISH(60);

    private final int timeoutInSeconds;

    /**
     * Creates a new State of the game with a certain amount of time, this State can be in at most.
     *
     * @param timeoutInSeconds maximum time this state can exist
     */
    State(final int timeoutInSeconds) {
        this.timeoutInSeconds = timeoutInSeconds;
    }

    public int getTimeoutInSeconds() {
        return timeoutInSeconds;
    }
}
