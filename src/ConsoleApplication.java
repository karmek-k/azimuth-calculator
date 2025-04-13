import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleApplication {
    Scanner sc;

    public ConsoleApplication() {
        sc = new Scanner(System.in);
        sc.useLocale(Locale.US);  // use a dot for decimal notation
    }

    public void run() {
        System.out.println("~~~ Azimuth Calculator ~~~");

        double firstX = promptFor("First point - X");
        double firstY = promptFor("First point - Y");
        double secondX = promptFor("Second point - X");
        double secondY = promptFor("Second point - Y");

        System.out.println(firstX);
        System.out.println(firstY);
        System.out.println(secondX);
        System.out.println(secondY);

        sc.close();
    }

    private double promptFor(String promptText) {
        double result = 0.0;
        boolean hasReceivedResult = false;

        do {
            System.out.print(promptText + ": ");

            try {
                result = sc.nextDouble();
                hasReceivedResult = true;
            } catch (InputMismatchException e) {
                System.err.println("Invalid data provided, it should be a decimal number only.");

                if (sc.hasNext()) {
                    sc.next();
                }
            }
        } while (!hasReceivedResult);

        return result;
    }
}
