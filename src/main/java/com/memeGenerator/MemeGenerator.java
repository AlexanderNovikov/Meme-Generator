package com.memeGenerator;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

/**
 * User: alexander
 * Date: 03.04.12
 * Time: 20:53
 */
public class MemeGenerator extends JPanel {

    private static final String IMAGE = "original.png";
    private static final String NEW_IMAGE = "meme.png";
    private static final String EXTENSION = "png";
    private static final String STRING = "ABCDEFGE";
    private static final String FONT = "Serif";
    private static final int FONT_SIZE = 45;
    private static final int UPPER_LEFT_X = 5;
    private static final int UPPER_LEFT_Y = 40;
    private static final int UPPER_RIGHT_X = 517;
    private static final int UPPER_RIGHT_Y = 40;
    private static final int BOTTOM_LEFT_X = 5;
    private static final int BOTTOM_LEFT_Y = 415;
    private static final int BOTTOM_RIGHT_X = 517;
    private static final int BOTTOM_RIGHT_Y = 415;

    private static RenderedImage renderedImage() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(IMAGE));
        } catch (IOException e) {e.printStackTrace();}
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(img, 0, 0, null);
        g2d.setFont(new Font(FONT, Font.BOLD, FONT_SIZE));
        putStringOntoImage(g2d, STRING, UPPER_LEFT_X, UPPER_LEFT_Y);
        putStringOntoImage(g2d, STRING, UPPER_RIGHT_X, UPPER_RIGHT_Y);
        putStringOntoImage(g2d, STRING, BOTTOM_LEFT_X, BOTTOM_LEFT_Y);
        putStringOntoImage(g2d, STRING, BOTTOM_RIGHT_X, BOTTOM_RIGHT_Y);
        g2d.dispose();
        return bufferedImage;
    }
    private static Graphics2D putStringOntoImage(Graphics2D graphics2D, String text, int x, int y) {
        int width = -350;
        int textLength = text.length();
        System.out.print(textLength);
        graphics2D.drawString(text, x - (width + (textLength*15)) / 2, y);
        return graphics2D;
    }
    private static void writeImage(RenderedImage image) {
        File file = new File(NEW_IMAGE);
        try {
            ImageIO.write(image, EXTENSION, file);
        } catch (IOException e) {e.printStackTrace();}
    }

    public static void main(String[] args) {
        RenderedImage renderedImage = renderedImage();
        writeImage(renderedImage);
    }
}
