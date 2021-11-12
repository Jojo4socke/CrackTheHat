package exception;

/**
 *
 * FieldNotFoundException is thrown when the fieldnumber doesn't exist.
 *
 * @author Cedric Nees, Daniel Schedek, Dominik Vennegeerts, Jonathan Uhlmann, Vanessa Grauer
 * @version 2021-11-11
 */
public class FieldNotFoundException extends Exception {
    // Constructor
    public FieldNotFoundException(String msg) {
        super(msg);
    }
}
