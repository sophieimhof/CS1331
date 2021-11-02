/**
 *Represents a Invalid Pet Exception.
 *
 *@author simhof3
 *@version 1331
 */
public class InvalidPetException extends RuntimeException {
    /**
    *Creates an invalid pet exception with default message.
    */
    public InvalidPetException() {
        this("Your pet is invalid!");
    }
    /**
    *Creates an invalid pet exception with provided message.
    *
    *@param s exception message
    */
    public InvalidPetException(String s) {
        super(s);
    }
}
