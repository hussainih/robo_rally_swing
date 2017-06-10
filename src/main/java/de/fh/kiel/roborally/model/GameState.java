package de.fh.kiel.roborally.model;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Representation of the state of a game.<br/>
 * A Game can be identified via an ID. It knows about all the players, all the Elements on a Board, all the card piles
 *
 * @author jpr
 */
public class GameState {


    private final String id;
    private final int maxRobotCount;
    private final String gameName;
    private final Set<Player> players = new HashSet<>();
    private final Board board;
    private final Queue<Card> spamCards;
    private final Queue<Card> otherDamageCards;
    private final State currentState = State.JOINING;

    /**
     * Constructor
     *
     * @param id            ID of the game
     * @param maxRobotCount maximum number of robots
     * @param gameName      the name of the game
     * @param board         the board
     */
    public GameState(final String id, final int maxRobotCount, final String gameName, final Board board) {
        this.id = id;
        this.maxRobotCount = maxRobotCount;
        this.gameName = gameName;
        this.board = board;
        spamCards = new LinkedBlockingQueue<>(Stream.generate(() -> Card.SPAM).limit(38).collect(Collectors.toList()));
        List<Card> tmp = Stream.concat(Stream.concat(Stream.generate(() -> Card.VIRUS).limit(18), Stream.generate(() -> Card.TROJAN_HORSE).limit(12)),
                Stream.generate(() -> Card.WORM).limit(6)).collect(Collectors.toList());
        Collections.shuffle(tmp);
        this.otherDamageCards = new LinkedBlockingQueue<>(tmp);
    }

    public String getId() {
        return id;
    }

    public int getMaxRobotCount() {
        return maxRobotCount;
    }

    public String getGameName() {
        return gameName;
    }

    /**
     * @return a defensive copy of the Players
     */
    public Set<Player> getPlayers() {
        return Collections.unmodifiableSet(players);
    }

    /**
     * Adds a player to the game, if they are not present yet and if the game is not yet fully occupied.
     *
     * @param player the Player to be added
     * @return was the Player successfully added to the game?
     */
    public synchronized boolean addPlayer(Player player) {
        if (players.size() < maxRobotCount) {
            return players.add(player);
        }
        return false;
    }

    public Board getBoard() {
        return board;
    }

    public State getCurrentState() {
        return currentState;
    }
}
