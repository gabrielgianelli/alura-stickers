import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // do a HTTP connection e get the top 250 movies
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        var address = URI.create(url);        
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        var body = response.body();
        // extract only the desired data (title, poster and rating)
        var parser = new JsonParser();
        List<Map<String, String>> listOfMovies = parser.parse(body);
        // show and manipulate data
        for (Map<String,String> movie : listOfMovies) {
            System.out.println(movie.get("title"));
            System.out.println(movie.get("image"));
            System.out.println(movie.get("imDbRating"));
        }
    }
}



