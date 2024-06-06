package edu.uoc.uocoban.model.utils;

/**
 * Direction that entities move.<br/>
 * <b>Order</b>: RIGHT, DOWN, LEFT, UP.
 * <br/>
 * The methods <span style="font-family:'Courier New'">valueOf(String name)</span> and <span style="font-family:'Courier New'">values()</span> are provided by Java Enumeration.
 * <span style="color:#ff0000"><b>You don't have to create them!!</b></span>
 * @author Quim
 * @version 1.0
 */
public enum Direction {
    /**
     * RIGHT direction. x = 1, y = 0 and keyCode = 22.
     */
    RIGHT(1, 0, 22),
    /**
     * DOWN direction. x = 0, y = 1 and keyCode = 20.
     */
    DOWN(0, 1, 20),
    /**
     * LEFT direction. x = -1, y = 0 and keyCode = 21.
     */
    LEFT(-1, 0, 21),
    /**
     * UP direction. x = 0, y = -1 and keyCode = 19.
     */
    UP(0, -1, 19);

    /**
     * Offset in X axis
     */
    private final int x;

    /**
     * Offset in Y axis
     */
    private final int y;

    /**
     * Intenger value that is given by libgdx
     * to a key pressed by the user
     */
    private final int keyCode;

    /**
     * @param x       Value of the attribute {@code x}
     * @param y       Value of the attribute {@code y}
     * @param keyCode Value of the attribute {@code keyCode}
     */
    Direction(int x, int y, int keyCode) {
        this.x = x;
        this.y = y;
        this.keyCode = keyCode;
    }

    /**
     * Getter of the attibute {@code x}
     *
     * @return The value of the attribute {@code x}
     */
    public int getX() {
        return x;
    }

    /**
     * Getter of the attibute {@code y}
     *
     * @return The value of the attribute {@code y}
     */
    public int getY() {
        return y;
    }

    /**
     * Getter of the attibute {@code keyCode}
     *
     * @return The value of the attribute {@code keyCode}
     */
    public int getKeyCode() {
        return keyCode;
    }

    /**
     * Given the value of {@code keyCode},
     * it returns the corresponding {@code Direction} value.
     *
     * @param keyCode Integer value of a key.
     * @return The {@code Direction} value linked to {@code keyCode}.
     * If any, then returns {@code null}.
     */
    public static Direction getDirectionByKeyCode(int keyCode) {
        for (var direction : values()) {
            if (direction.getKeyCode() == keyCode)
                return direction;
        }
        return null;
    }

}
