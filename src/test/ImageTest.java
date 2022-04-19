package test;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class ImageTest {
    @Test
    public void test() {
        try {
            BufferedImage image = ImageIO.read(new File("F:\\workspace\\tank\\src\\images\\bulletD.gif"));
            assertNotNull(image);
            BufferedImage image1 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            assertNotNull(image1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("test");
    }
}
