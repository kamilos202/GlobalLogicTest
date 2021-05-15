import java.text.DecimalFormat;
import java.util.Scanner;

public class Util {
    public static final String definedChars = "( !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~);";
    public static final char[] word = {'l','o','g','i','c'};
    public static final String wordString = "logic";
    public static final String testStatement = "I love to work in global logic!";
    public static final DecimalFormat df = new DecimalFormat("0.00");
    public static float roundNum(float n){
        return (float)Math.round(n*100)/100;
    }
    static Scanner sc = new Scanner(System.in);
    /**
     * Only works if not seperated by spaces
     * @return
     */
    public static String getValidStringInput()
    {
        return sc.next();
    }
    /**
     * works for full lines of text
     * @return
     */
    public static String getValidLineInput()
    {
        //The dummy string makes sure something is entered so no empty string is returned unless this is desired.
        String dummy = getValidStringInput();
        return dummy + sc.nextLine();
    }
}
