package edu.uoc.uocoban.model.utils;

import java.util.Objects;

/**
 * Stores a 2D position in a game map
 *
 * @author Ivan Gentile
 * @version 1.0
 */
public class Position {

    /**
     * Value of the attribute X axis
     */
    private int x;

    /**
     * Value of the attribute Y axis
     */
    private int y;

    /**
     * Constructor with arguments.
     *
     * @param x Initial value of the attribute {@code x}
     * @param y Initial value of the attribute {@code y}
     */
    public Position(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * Getter of the attribute {@code x}
     *
     * @return The current value of the attribute {@code x}
     */
    public int getX() {
        return x;
    }

    /**
     * Setter of the attribute {@code x}
     *
     * @param x New value for the attribute {@code x}
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Getter of the attribute {@code y}
     *
     * @return The current value of the attribute {@code y}
     */
    public int getY() {
        return y;
    }

    /**
     * Setter of the attribute {@code y}
     *
     * @param y New value for the attribute {@code y}
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Checks if two positions are equal.
     *
     * @param other object to compare against.
     * @return true if the type of {@code other} is {@link Position}
     * and x == this.x and also y == this.y, false otherwise.
     */
    @Override
    public boolean equals(Object other) {

        if (!(other instanceof Position)) {
            return false;
        }

        Position otherPosition = (Position) other;
        return this.getX() == otherPosition.getX() && this.getY() == otherPosition.getY();
    }

    /**
     * Returns the hash of a {@code Position} object.
     *
     * @return The result of applying {@code Objects.hash} on {@code x} and {@code y}.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getX(), this.getY());
    }

    /**
     * Returns a comma-seperated string representation of a Position.<br/>
     * Format: "x,y"<br/>
     * Example: "3,4"
     *
     * @return "x,y"
     */
    @Override
    public String toString() {
        return getX() + "," + getY();
    }
}
