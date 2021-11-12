package exception;

/**
 *
 * InvalidMoveException is thrown when:<br/>
 * 1. Maximum game pieces on a SaveField are reached<br/>
 * 2. Game piece tries to join another players HomeField<br/>
 * 3. The chosen number for the next field isn't a neighbour
 *
 * @author Cedric Nees, Daniel Schedek, Dominik Vennegeerts, Jonathan Uhlmann, Vanessa Grauer
 * @version 2021-11-11
 */
public class InvalidMoveException extends Exception {
    // Constructor
    public InvalidMoveException(String msg) {
        super(msg);
    }
}
