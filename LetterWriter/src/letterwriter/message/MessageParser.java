package letterwriter.message;

/**
 *
 * @author Villan
 */
public class MessageParser {

    private final String message = 
            "Hi,\n\nHow is life going?.$- It has been$---------'s been a while since we talked."
            + "\n\nI liked$-----really liked the project that you done during your$----vacation time."
            + "\n\nKeep up the good workq$-!"
            + "\n\n\t\t\t\t\t\t\t\tThanks and Regards,"
            + "\n\t\t\t\t\t\t\t\t\t Genuine Coder";
    private int pointer = 0;

    public Character getNext() {
        if (pointer >= message.length()) {
            return null;
        }
        Character entry = message.charAt(pointer);
        pointer += 1;
        return entry;
    }
}
