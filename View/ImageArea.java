package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by SPARK on 2016-03-08.
 */
public class ImageArea {

    private Image image;

    public void ImageArea(String filepath) {

        image = new ImageIcon(this.getClass().getResource(filepath)).getImage();




    }


}
