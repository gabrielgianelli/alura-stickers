import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        // String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        // String url = "http://localhost:8080/languages";
        String url = "https://gabrielgianelli-languages-api.herokuapp.com/languages";
        ImdbContentExtractor contentExtractor = new ImdbContentExtractor();        
        // ContentExtractor contentExtractor = new NasaContentExtractor();        
        var client = new HTTPClient();
        var json = client.getBody(url);
        List<Content> contents = contentExtractor.extractContent(json);
        var stickerGenerator = new StickerGenerator();
        for (Content content : contents) {
            // Content content = contents.get(index);            
            var filename = "output/" + content.getTitle() + ".png";
            var inputStream = new URL(content.getImageURL()).openStream();
            stickerGenerator.create(inputStream, filename);
            System.out.println(content.getTitle());
            System.out.println();
        }
    }
}



