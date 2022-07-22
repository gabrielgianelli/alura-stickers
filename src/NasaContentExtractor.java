import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NasaContentExtractor implements ContentExtractor {
    public List<Content> extractContent(String json) {
        var parser = new JsonParser();
        List<Map<String, String>> listOfAttributes = parser.parse(json);
        List<Content> contents = new ArrayList<>();
        for (Map<String,String> attributes : listOfAttributes) {
            var title = attributes.get("title");
            var imageURL = attributes.get("url");
            var content = new Content(title, imageURL);
            contents.add(content);
        }
        return contents;
    }        
}
