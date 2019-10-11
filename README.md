# custom-banner
Custom Banner for Springboot service

Visit https://devops.datenkollektiv.de/banner.txt/index.html
Give the Banner text an select the font.
copy the output banner text and paste it in src/main/resources/banner.txt file.

# OR

Use this code to create custom banner

```aidl
import java.awt.*;
import java.awt.image.BufferedImage;

public class CustomBannerCreator {

    public static void main(String[] args) {
        int width = 150;
        int height = 30;
        printCustomBanner("Welcome", new Font("SansSerif", Font.BOLD, 24), width, height, '*');
    }

    private static void printCustomBanner(String bannerText, Font font, int width, int height, char character) {
        //BufferedImage image = ImageIO.read(new File("/Users/mkyong/Desktop/logo.jpg"));
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(font);

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString(bannerText, 10, 20);

        //save this image
        //ImageIO.write(image, "png", new File("/users/mkyong/ascii-art.png"));

        for (int y = 0; y < height; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < width; x++) {
                sb.append(image.getRGB(x, y) == -16777216 ? " " : character);
            }
            if (sb.toString().trim().isEmpty()) {
                continue;
            }
            System.out.println(sb);
        }
    }

}
```

copy the output banner text and paste it in src/main/resources/banner.txt file.
 