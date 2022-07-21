import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerGenerator {
    
    public void create(InputStream inputStream, String filename) throws Exception {
        // read image
        // InputStream inputStream = new FileInputStream("input/movieBig.jpg");
        // InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@..jpg").openStream();
        BufferedImage originalImage = ImageIO.read(inputStream);
        // create new image in memory with transparency and new size
        var width = originalImage.getWidth();
        var height = originalImage.getHeight();
        int newHeight = height + 200;
        var newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
        // copy original image for new image (in memory)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);
        // configure font
        graphics.setColor(Color.YELLOW);
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 64));
        // write a phrase on the new image
        graphics.drawString("TOPZERA", width/2-100, newHeight - 100);
        // write the new image in a file
        ImageIO.write(newImage, "png", new File(filename));
    }
}
