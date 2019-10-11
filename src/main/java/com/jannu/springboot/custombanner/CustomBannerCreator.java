package com.jannu.springboot.custombanner;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CustomBannerCreator {

    public static void main(String[] args) {
        final int width = 150;
        final int height = 30;
        final String welcome = "Welcome";
        final Font sansSerif = new Font("SansSerif", Font.BOLD, 24);
        final char character = '*';
        printCustomBanner(welcome, sansSerif, width, height, character);
    }

    private static void printCustomBanner(String bannerText, Font font, int width, int height, char character) {
        final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics g = image.getGraphics();
        g.setFont(font);

        final Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString(bannerText, 10, 20);

        for (int y = 0; y < height; y++) {
            final StringBuilder sb = new StringBuilder();
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