package edu.uoc.uocoban.model.entities.movable;

import edu.uoc.uocoban.model.Level;
import edu.uoc.uocoban.model.entities.MapItem;
import edu.uoc.uocoban.model.utils.Direction;
import edu.uoc.uocoban.model.utils.Position;
import edu.uoc.uocoban.model.utils.Sprite;

/**
 * Represents an entity in the game
 *
 * @author Ivan Gentile
 * @version 1.0
 */
public abstract class MovableEntity extends MapItem {

    /**
     * Reference to the current level object.
     */
    private Level level;

    /**
     * Constructor with arguments
     *
     * @param position Initial value of the attribute {@code position}
     * @param sprite   Initial value of the attribute {@code sprite}
     * @param level   Initial value of the attribute {@code level}
     */
    protected MovableEntity(Position position, Sprite sprite, Level level) {
        super(position, sprite);
        setLevel(level);
    }

    /**
     * Getter for the {@code level} the entity belongs to
     *
     * @return {@code level} attribute value
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Setter for the {@code level} attribute
     * @param level {@code level} value to be assigned
     */
    private void setLevel(Level level) {
        this.level = level;
    }

    /**
     * Tries to move the entity to the adjacent position determined by {@code direction}.
     *
     * @param direction The {@code direction} where the entity attempts to move
     * @return {@code true} if the entity could move; {@code false} otherwise
     */
    public abstract boolean move(Direction direction);

}
