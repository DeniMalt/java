import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class URLValidator {

    private static final String URL_REGEX = "^(https?://)?(?!-)([a-zA-Z]{2,}(?:\\.[a-zA-Z]{2,})+)(:[0-9]{1,5})?(/\\S*)?(#\\S*)?$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите URL для проверки: ");
        String urlInput = scanner.nextLine();

        System.out.println(urlInput + " -> " + (isValidUrl(urlInput) ? "Valid" : "Invalid"));

        scanner.close();
    }

    public static boolean isValidUrl(String url) {
        Pattern pattern = Pattern.compile(URL_REGEX);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
}
