package edu.uoc.uocoban.model.entities;

import edu.uoc.uocoban.model.utils.Position;
import edu.uoc.uocoban.model.utils.Sprite;

/**
 * Item of a game map
 *
 * @author Ivan Gentile
 * @version 1.0
 */
public abstract class MapItem {

    /**
     * Position where the map item is placed
     */
    private Position position;
    /**
     * Value of {@link Sprite} linked to the map item
     */
    private Sprite sprite;

    /**
     * Constructor with arguments
     * @param position Initial value of the attribute {@code position}
     * @param sprite Initial value of the attribute {@code position}
     */
    protected MapItem(Position position, Sprite sprite) {
        this.position = position;
        this.sprite = sprite;
    }

    /**
     * Gets the current position of the entity.
     *
     * @return current position.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets the position of the entity. If position is null, then the position is not set.
     *
     * @param position to set to the entity
     */
    public void setPosition(Position position) {
        this.position = position != null ? position : this.position;
    }

    /**
     * Getter of the attribute {@code sprite}.
     *
     * @return Current value of {@code sprite}.
     */
    public Sprite getSprite() {
        return sprite;
    }

    /**
     * Setter of the attribute {@code sprite}.
     *
     * @param sprite New value for the attribute {@code sprite}.
     */
    protected void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    /**
     * Determines whether the map item is pahable or not by at least one type of entity
     *
     * @return If pathable, ({@code true}); otherwise, ({@code false})
     */
    public abstract boolean isPathable();

}
