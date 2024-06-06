package edu.uoc.uocoban.model.entities.movable;

import edu.uoc.uocoban.model.Level;
import edu.uoc.uocoban.model.utils.Position;
import edu.uoc.uocoban.model.utils.Sprite;

/**
 * Represents a big crate in the game
 *
 * @author Ivan Gentile
 * @version 1.0
 */
public class BigBox extends Box {
    /**
     * Constructor with arguments
     *
     * @param position Initial value of the attribute {@code position}
     * @param level Initial value of the attribute {@code level}
     */
    public BigBox(Position position, Level level) {
        super(position, Sprite.BIG_BOX, level);
    }
}
