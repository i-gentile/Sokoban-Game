package edu.uoc.uocoban.model.entities.movable;

import edu.uoc.uocoban.model.Level;
import edu.uoc.uocoban.model.utils.Position;
import edu.uoc.uocoban.model.utils.Sprite;

/**
 * Represents a small crate in the game
 *
 * @author Ivan Gentile
 * @version 1.0
 */
public class SmallBox extends Box {
    /**
     * Constructor with arguments
     *
     * @param position Initial value of the attribute {@code position}
     * @param level Initial value of the attribute {@code level}
     */
    public SmallBox(Position position, Level level) {
        super(position, Sprite.SMALL_BOX, level);
    }
}
