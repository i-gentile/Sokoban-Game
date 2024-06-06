package edu.uoc.uocoban.model.entities.movable;

import edu.uoc.uocoban.model.Level;
import edu.uoc.uocoban.model.entities.MapItem;
import edu.uoc.uocoban.model.entities.pathable.Destination;
import edu.uoc.uocoban.model.entities.pathable.Path;
import edu.uoc.uocoban.model.utils.Direction;
import edu.uoc.uocoban.model.utils.Position;
import edu.uoc.uocoban.model.utils.Sprite;

/**
 * Represents the player of the game
 *
 * @author Ivan Gentile
 * @version 1.0
 */
public class Player extends MovableEntity {

    /**
     * Constructor with arguments
     * @param position Initial value of the attribute {@code position}
     * @param level   Initial value of the attribute {@code level}
     */
    public Player(Position position, Level level) {
        super(position, Sprite.PLAYER, level);
    }

    /**
     * Tries to move the player to the adjacent position determined by {@code direction}.
     *
     * A player moves according to the following rules:
     *
     * <ul>
     *     <li>A player can only move to a position occupied by a {@link Path} or a {@link Box} that can be moved.</li>
     *     <li>If the target position is occupied by a {@link Path}, the player can always be moved to that position. In
     *     this context: (1) the original position of the player must be replaced with a {@link Path}; (2) the {@link Path}
     *     item to which the player is moving to must be removed; and (3) the {@code Player} position must be updated.</li>
     *     <li>If the target position is occupied by a {@link Box}, the player tries to move the box. If the box is successfully
     *     moved, then: (1) the original position of the player must be replaced with a {@link Path}; and (2) the
     *     {@code Player} position must be updated. Otherwise, the player does not move.</li>
     * </ul>
     *
     * @param direction The {@code direction} where the player attemps to move
     * @return {@code true} if the player could move; {@code false} otherwise
     */
    @Override
    public boolean move(Direction direction) {
        Level level = getLevel();

        int newX = getPosition().getX() + direction.getX();
        int newY = getPosition().getY() + direction.getY();
        Position newPosition = new Position(newX, newY);

        MapItem mapItem = level.getMapItem(newPosition);

        // The player moves to a pathable position
        if (mapItem != null && mapItem.isPathable()) {
            //check if destination (i.e., non-valid)
            if (mapItem instanceof Destination)
                return false;
            //else, move character
            level.removeMapItem(mapItem);
            level.addMapItem(new Path(getPosition()));
            setPosition(newPosition);
            return true;
        }

        // The player tries to push a box
        if (mapItem instanceof MovableEntity) {
            boolean boxMoved = ((Box) mapItem).move(direction);

            if (boxMoved) {
                level.addMapItem(new Path(getPosition()));
                setPosition(newPosition);
                return true;
            } else
                return false;
        }
        // Otherwise
        else {
            return false;
        }
    }

    /**
     * States whether the player is pathable
     *
     * @return {@code false}
     */
    @Override
    public boolean isPathable() {
        return false;
    }
}
