package de.fh.kiel.roborally.model;

import java.util.List;

/**
 * Models an action of robot for a single register
 *
 * @author jpr
 */
public class Action {

    private final Card card;
    private final List<Card> damageCards;
    private final String playerId;
    private final int positionX;
    private final int positionY;
    private final Direction direction;

    /**
     * Constructor
     *
     * @param card        the card played in the register
     * @param damageCards the damage cards that the robot got
     * @param playerId    the ID of the player of the robot
     * @param positionX   the x-coordinate of the robot position at the end of the register
     * @param positionY   the y-coordinate of the robot position at the end of the register
     * @param direction   the direction of the robot  at the end of the register
     */
    private Action(final Card card, final List<Card> damageCards, final String playerId, final int positionX, final int positionY, final Direction direction) {
        this.card = card;
        this.damageCards = damageCards;
        this.playerId = playerId;
        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
    }


    public String getPlayerId() {
        return playerId;
    }

    public Card getCard() {
        return card;
    }

    public List<Card> getDamageCards() {
        return damageCards;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public Direction getDirection() {
        return direction;
    }

    /**
     * Builder for {@link Action}. A builder for creating an {@link Action} allows you to create the action step by step by chaining method calls in orer to set the values of
     * members of the thing to build. E.g. {@code new ActionBuilder().card(Card.SPAM).playerId("id123")...build();} to get an instance of {@link Action}.
     * By using builder patterns instead of setting the constructors visibility to public, you can prevent the accidentally permutation of constructor arguments of the same type.
     */
    public static class ActionBuilder {
        private Card card;
        private List<Card> damageCards;
        private String playerId;
        private int positionX;
        private int positionY;
        private Direction direction;

        public ActionBuilder card(final Card card) {
            this.card = card;
            return this;
        }

        public ActionBuilder damageCards(final List<Card> damageCards) {
            this.damageCards = damageCards;
            return this;
        }

        public ActionBuilder playerId(final String playerId) {
            this.playerId = playerId;
            return this;
        }

        public ActionBuilder positionX(final int positionX) {
            this.positionX = positionX;
            return this;
        }

        public ActionBuilder positionY(final int positionY) {
            this.positionY = positionY;
            return this;
        }

        public ActionBuilder direction(final Direction direction) {
            this.direction = direction;
            return this;
        }

        public Action build() {
            return new Action(card, damageCards, playerId, positionX, positionY, direction);
        }
    }
}
