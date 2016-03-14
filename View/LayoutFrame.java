package View;

import Model.ImagesModel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

/**
 * Created by SPARK on 2016-03-08.
 */

public class LayoutFrame extends JFrame { // implements Observer {

    public LayoutFrame(String title, JPanel contents, ImagesModel imagesModel) {
        super(title);
        this.setContentPane(contents);
        this.setSize(1500, 1000);
        this.setMinimumSize(new Dimension(1400,600));



        imagesModel.setScreenSize(new Dimension(this.getSize().width, this.getSize().height));
        System.out.println("this.getSize().width  = " + this.getSize().width);
        System.out.println("this.getSize().height = " + this.getSize().height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(true);







    }
}