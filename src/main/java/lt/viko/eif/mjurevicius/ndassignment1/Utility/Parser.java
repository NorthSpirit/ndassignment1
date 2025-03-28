package lt.viko.eif.mjurevicius.ndassignment1.Utility;

public class Parser {

    public static int tryParseInt(String input)
    {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
