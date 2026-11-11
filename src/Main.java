import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;

public static final String RESET = "\u001B[0m";
public static final String GREEN = "\u001B[32m";
public static final String YELLOW = "\u001B[33m";
public static final String RED = "\u001B[31m";

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.


        String url = "https://random-word-api.herokuapp.com/word?number=1&length=5&diff=1";
        String word = "";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try{

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                word = response.body()
                        .replace('"', ' ')
                        .replace('[', ' ')
                        .replace(']', ' ')
                        .trim()
                        .toUpperCase();

                System.out.println(word);

                guessWord("hello", "hello");
                guessWord(word, "bingo");
                guessWord(word, "prank");
                guessWord(word, "theft");

        } catch (IOException | InterruptedException e) {
                e.printStackTrace();
        }

}

public static void guessWord(String word, String guess) {

        for (int i = 0; i < word.length(); i++) {
                for (int j = 0; j < word.length(); j++) {
                        if (i == j && word.charAt(i) == guess.charAt(i)) {
                                System.out.print(GREEN + guess.charAt(i) + RESET);
                        } else if (i != j && word.charAt(i) == guess.charAt(j)) {
                                System.out.print(YELLOW + guess.charAt(i) + RESET);
                        }
                }
        }

        System.out.println();
}
