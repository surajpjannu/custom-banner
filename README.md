# custom-banner
Custom Banner for Springboot service

Visit https://devops.datenkollektiv.de/banner.txt/index.html
Give the Banner text an select the font.
copy the output banner text and paste it in src/main/resources/banner.txt file.

# OR

Use this code to create custom banner

```aidl
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomBannerApplication {
	public static void main(String[] args) {
		final SpringApplication application = new SpringApplication(CustomBannerApplication.class);
		application.setBanner(new CustomBanner());
		application.run(args);
    }
}
```

```aidl
import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.PrintStream;

public class CustomBanner implements Banner {

    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {

        final Package aPackage = this.getClass().getPackage();

        final String applicationTitle = aPackage.getImplementationTitle();
        final String applicationVersion = aPackage.getImplementationVersion();
        final int height = 20;
        final int width = height * applicationTitle.length();
        final Font sansSerif = new Font("SansSerif", Font.BOLD, 24);
        final char character = '=';
        final String banner = printCustomBanner(applicationTitle, sansSerif, width, height, character);
        
        
        out.println(banner);
        out.println("================================");
        out.println("Application Title   : " + applicationTitle);
        out.println("Application Version : " + applicationVersion);
        out.println("================================");
    }

    private String printCustomBanner(String bannerText, Font font, int width, int height, char character) {
        final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics g = image.getGraphics();
        g.setFont(font);

        final Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString(bannerText, 10, 20);

        final StringBuilder builder = new StringBuilder();
        for (int y = 0; y < height; y++) {
            final StringBuilder sb = new StringBuilder();
            for (int x = 0; x < width; x++) {
                sb.append(image.getRGB(x, y) == -16777216 ? " " : character);
            }
            if (sb.toString().trim().isEmpty()) {
                continue;
            }
            builder.append(sb);
            builder.append("\n");
        }
        return builder.toString();
    }

}

```

# Note 
banner.txt have higher precedence over custom java code.