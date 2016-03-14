package View;

import Model.ImagesModel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Created by SPARK on 2016-03-08.
 */
public class NestedLayout extends JPanel { 

    public NestedLayout(ImagesModel imagesModel) {
        super();

//        /tmp/ImageModel.ser

        File f = new File("/tmp/ImageModel.ser");
        if(f.exists() && !f.isDirectory()) {
            System.out.println("NestedLayout.java: Found the file.");
            try {
                FileInputStream fileIn = new FileInputStream("/tmp/ImageModel.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                imagesModel = (ImagesModel) in.readObject();
                in.close();
                fileIn.close();
                System.out.println("NestedLayout.java: Loaded the file.");

                for (int i=0; i<imagesModel.getNumPaths(); i++) {
                    System.out.println("--*--" + (i+1) + "st path is: " + imagesModel.getPaths().get(i));
                    System.out.println("--*--" + (i+1) + "st path is: " + imagesModel.getNames().get(i));
                }




            } catch(IOException i) {
                i.printStackTrace();
                return;
            } catch(ClassNotFoundException c) {
                System.out.println("ImagesModel class not found");
                c.printStackTrace();
                return;
            }
        } else {
            System.out.println("NestedLayout.java: Previous data of ImagesModel.ser has not been found.  Let's create new one");
        }



        JPanel menu = new MenuBoxLayout(imagesModel);
        JPanel displayBox = new DisplayBox(imagesModel);
        JScrollPane display = new JScrollPane(displayBox);


        System.out.println("THE SIZE 2 = " + display.getSize().getWidth());

        menu.setBorder(BorderFactory.createTitledBorder(""));
        display.setBorder(BorderFactory.createTitledBorder(""));

        this.setLayout(new BorderLayout());
        this.add(menu, BorderLayout.NORTH);
        this.add(display, BorderLayout.CENTER);

        display.revalidate();
        display.repaint();


    }
}