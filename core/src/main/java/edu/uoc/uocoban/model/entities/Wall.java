package edu.uoc.uocoban.model.entities;

import edu.uoc.uocoban.model.utils.Position;
import edu.uoc.uocoban.model.utils.Sprite;

/**
 * Represents a wall in the map
 *
 * @author Ivan Gentile
 * @version 1.0
 */
public class Wall extends MapItem {

    /**
     * Constructor with arguments.
     * The value for {@code sprite} is {@code Sprite.WALL}
     *
     * @param position Position where the wall is placed.
     */
    public Wall(Position position) {
        super(position, Sprite.WALL);
    }

    /**
     * Determines whether the wall is a pathable item.
     *
     * @return {@code false}
     */
    @Override
    public boolean isPathable() {
        return false;
    }
}
