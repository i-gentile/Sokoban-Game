package edu.uoc.uocoban.model.entities.pathable;

import edu.uoc.uocoban.model.entities.MapItem;
import edu.uoc.uocoban.model.entities.movable.Box;
import edu.uoc.uocoban.model.utils.Position;
import edu.uoc.uocoban.model.utils.Sprite;

/**
 * Represents a destination for boxs in the map
 *
 * @author Ivan Gentile
 * @version 1.0
 */
public abstract class Destination extends MapItem implements Mutable {

    /**
     * The box delivered to the implicit destination (if any)
     */
    private Box box;

    /**
     * Constructor with arguments
     *
     * @param position Initial value of the attribute {@code position}
     * @param sprite   Initial value of the attribute {@code position}
     */
    protected Destination(Position position, Sprite sprite) {
        super(position, sprite);
    }

    /**
     * Getter for the {@code box} attribute
     *
     * @return {@code box} value
     */
    public Box getBox() {
        return box;
    }

    /**
     * Setter for the {@code box} attribute. When an entity is assigned to the destination, the destination must be
     * mutated to its corresponding {@link Sprite}.
     *
     * @param box {@code box} value to be assigned.
     */
    public void setBox(Box box) {
        if (box != null) {
            this.box = box;
            this.mutate();
        }
    }

    /**
     * States whether the {@code destination} is empty or not
     *
     * @return {@code true} if no entity is assigned; {@code false} otherwise
     */
    public boolean isEmpty() {
        return box == null;
    }

    /**
     * States whether the destination is pathable (i.e., if it is empty or not)
     *
     * @return {@code true} if no entity is in the destination; {@code false} otherwise
     */
    @Override
    public boolean isPathable() {
        return isEmpty();
    }

}
