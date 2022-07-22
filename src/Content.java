public class Content {
    private final String title;
    private final String imageURL;

    public Content(String title, String imageURL) {
        this.title = title;
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return this.title;
    }

    public String getImageURL() {
        return this.imageURL;
    }
}
