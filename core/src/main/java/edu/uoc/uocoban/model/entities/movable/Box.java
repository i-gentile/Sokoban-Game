package edu.uoc.uocoban.model.entities.movable;

import edu.uoc.uocoban.model.Level;
import edu.uoc.uocoban.model.entities.MapItem;
import edu.uoc.uocoban.model.entities.pathable.BigBoxDestination;
import edu.uoc.uocoban.model.entities.pathable.Destination;
import edu.uoc.uocoban.model.entities.pathable.SmallBoxDestination;
import edu.uoc.uocoban.model.utils.Direction;
import edu.uoc.uocoban.model.utils.Position;
import edu.uoc.uocoban.model.utils.Sprite;

/**
 * Represents a box in the map
 *
 * @author Ivan Gentile
 * @version 1.0
 */
public abstract class Box extends MovableEntity {

    /**
     * States whether the box has been delivered to a valid destination point
     */
    private boolean delivered;

    /**
     * Constructor with arguments (by default, {@code delivered} attribute
     * is set as {@code false}).
     *
     * @param position Initial value of the attribute {@code position}
     * @param sprite   Initial value of the attribute {@code sprite}
     * @param level   Initial value of the attribute {@code level}
     */
    protected Box(Position position, Sprite sprite, Level level) {
        super(position, sprite, level);
        setDelivered(false);
    }

    /**
     * Getter for the {@code delivered} attribute
     *
     * @return {@code delivered} attribute value
     */
    public boolean isDelivered() {
        return delivered;
    }

    /**
     * Setter for the {@code delivered} attribute
     *
     * @param delivered {@code delivered} attribute value
     */
    private void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    /**
     * States whether the box element is pathable or not
     *
     * @return {@code false}
     */
    @Override
    public boolean isPathable() {
        return false;
    }

    /**
     * Tries to move the box to the adjacent position determined by {@code direction}.
     *
     * A box moves according to the following rules:
     *
     * <ul>
     *     <li>A box can only move to a {@link edu.uoc.uocoban.model.entities.pathable.Path} or a {@link Destination} of the same type that the box
     *     (i.e., a {@link BigBox} cannot move to a {@link SmallBoxDestination}; a {@link SmallBox} cannot move to a {@link BigBoxDestination}).</li>
     *     <li>A box cannot move to a {@link Destination} map item that is already occupied by another box.</li>
     *     <li>If a box is moving to a {@link edu.uoc.uocoban.model.entities.pathable.Path} map item, then (1) the {@link edu.uoc.uocoban.model.entities.pathable.Path}
     *     is removed from the level map; and (2) the position of the {@link Box} is updated.</li>
     *     <li>If a box is moving to a valid {@link Destination} map item, then (1) the {@link Box}
     *     is removed from the level map; (2) the {@link Box} is marked as delivered (i.e., {@code delivered} = {@code true};
     *     and (3) the {@link Box} is assigned to the {@link Destination}.</li>
     * </ul>
     *
     * @param direction The {@code direction} where the box attempts to move
     * @return {@code true} if the box could successfully move; {@code false} otherwise
     */
    @Override
    public boolean move(Direction direction) {
        Level level = getLevel();

        int newX = getPosition().getX() + direction.getX();
        int newY = getPosition().getY() + direction.getY();
        Position newPosition = new Position(newX, newY);

        MapItem mapItem = level.getMapItem(newPosition);

        // The box moves to a pathable position
        if (mapItem != null && mapItem.isPathable()) {

            // check if pathable sprite is non-valid destination
            if (this instanceof SmallBox && mapItem instanceof BigBoxDestination ||
                this instanceof BigBox && mapItem instanceof SmallBoxDestination) {
                return false;
            }
            // if none of the above, check if moving to
            else if (mapItem instanceof Destination) {
                // if not empty, then it cannot be moved
                if (!((Destination) mapItem).isEmpty())
                    return false;
                // otherwise, the box is moved to the destination
                level.removeMapItem(this);
                ((Destination) mapItem).setBox(this);
                setDelivered(true);
            }
            // otherwise, moving to path
            else {
                level.removeMapItem(mapItem);
                setPosition(newPosition);
            }
            return true;
        }
        else {
            return false;
        }
    }
}
