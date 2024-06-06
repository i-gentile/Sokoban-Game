package edu.uoc.uocoban.model.utils;

/**
 * Sprite that stores the configuration file symbol and the image's path.
 *
 * @author Ivan Gentile
 * @version 1.0
 */
public enum Sprite {
    /**
     * Sprite for a wall
     */
    WALL('#', "images/wall.png"),
    /**
     * Sprite for a path
     */
    PATH('.', "images/path.png"),
    /**
     * Sprite for a player
     */
    PLAYER('@', "images/player.png"),
    /**
     * Sprite for a big box to be placed
     */
    BIG_BOX('b', "images/big_box.png"),
    /**
     * Sprite for destination of a big box (empty)
     */
    BIG_BOX_DESTINATION('B', "images/big_box_destination.png"),
    /**
     * Sprite for a big box placed in its destination
     */
    BIG_BOX_ON_DESTINATION('8', "images/big_box_on_destination.png"),
    /**
     * Sprite for a big box to be placed
     */
    SMALL_BOX('s', "images/small_box.png"),
    /**
     * Sprite for destination of a small box (empty)
     */
    SMALL_BOX_DESTINATION('S', "images/small_box_destination.png"),
    /**
     * Sprite for a small box placed in its destination
     */
    SMALL_BOX_ON_DESTINATION('$', "images/small_box_on_destination.png");


    /**
     * Value in the configuration file.
     */
    private final char symbol;

    /**
     * Value of the image path.
     */
    private final String imageSrc;

    /**
     * Constructor with arguments.
     *
     * @param symbol   Value of the configuration file symbol.
     * @param imageSrc Value of the image path.
     */
    Sprite(char symbol, String imageSrc) {
        this.symbol = symbol;
        this.imageSrc = imageSrc;
    }

    /**
     * Getter of the attribute {@code symbol}.
     *
     * @return Current value of the attribute {@code symbol}.
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Getter of the attribute {@code imageSrc}.
     *
     * @return Current value of the attribute {@code imageSrc}.
     */
    public String getImageSrc() {
        return imageSrc;
    }
}
