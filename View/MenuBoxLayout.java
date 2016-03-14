package View;

import Model.ImagesModel;
import Model.SelectView;
//import Model.StarFilterModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by SPARK on 2016-03-08.
 */
public class MenuBoxLayout extends JPanel implements Observer {


//    private StarFilterView starFilterView = new StarFilterView();
//    private MenuBoxLayout menuBoxLayout = new MenuBoxLayout();

//    private StarFilterModel starFilterModel = new StarFilterModel(0);
//    //private ImagesModel imagesModel = new ImagesModel(new ArrayList<String>(), 0);
//    private SelectView selectView = new SelectView(true, false);

    private ImagesModel imagesModel2;

    ImageIcon starAIcon = new ImageIcon(getClass().getResource("/resources/star1.png"));
    ImageIcon starBIcon = new ImageIcon(getClass().getResource("/resources/star2.jpeg"));
    ImageIcon starCIcon = new ImageIcon(getClass().getResource("/resources/star3.png"));


    JButton star1Button = new JButton (starAIcon);
    JButton star2Button = new JButton (starAIcon);
    JButton star3Button = new JButton (starAIcon);
    JButton star4Button = new JButton (starAIcon);
    JButton star5Button = new JButton (starAIcon);



    @Override
    public void update(Observable observable, Object arg) {

        if (arg == "StarFilter") {
//            System.out.println("update " + starFilterModel.getStarFilterValue());
//            starFilterModel = (StarFilterModel) observable;

//            if (starFilterModel.getStarFilterValue() == 0) {
            if (imagesModel2.getStarFilterValue() == 0) {
                star1Button.setIcon(starAIcon);
                star2Button.setIcon(starAIcon);
                star3Button.setIcon(starAIcon);
                star4Button.setIcon(starAIcon);
                star5Button.setIcon(starAIcon);
                //starFilterModel.setStarFilterValue(0); // This made infinite loop!
                System.out.println("here" + imagesModel2.getStarFilterValue());
            } else if (imagesModel2.getStarFilterValue() == 1) {
                star1Button.setIcon(starCIcon);
                star2Button.setIcon(starAIcon);
                star3Button.setIcon(starAIcon);
                star4Button.setIcon(starAIcon);
                star5Button.setIcon(starAIcon);
                System.out.println("here" + imagesModel2.getStarFilterValue());
            } else if (imagesModel2.getStarFilterValue() == 2) {
                star1Button.setIcon(starCIcon);
                star2Button.setIcon(starCIcon);
                star3Button.setIcon(starAIcon);
                star4Button.setIcon(starAIcon);
                star5Button.setIcon(starAIcon);
                System.out.println("here" + imagesModel2.getStarFilterValue());
            } else if (imagesModel2.getStarFilterValue() == 3) {
                star1Button.setIcon(starCIcon);
                star2Button.setIcon(starCIcon);
                star3Button.setIcon(starCIcon);
                star4Button.setIcon(starAIcon);
                star5Button.setIcon(starAIcon);
                System.out.println("here" + imagesModel2.getStarFilterValue());
            } else if (imagesModel2.getStarFilterValue() == 4) {
                star1Button.setIcon(starCIcon);
                star2Button.setIcon(starCIcon);
                star3Button.setIcon(starCIcon);
                star4Button.setIcon(starCIcon);
                star5Button.setIcon(starAIcon);
                System.out.println("here" + imagesModel2.getStarFilterValue());
            } else if (imagesModel2.getStarFilterValue() == 5) {
                star1Button.setIcon(starCIcon);
                star2Button.setIcon(starCIcon);
                star3Button.setIcon(starCIcon);
                star4Button.setIcon(starCIcon);
                star5Button.setIcon(starCIcon);
                System.out.println("here" + imagesModel2.getStarFilterValue());
            }

            System.out.println("StarFilterModel is Live. It's " + imagesModel2.getStarFilterValue());

        } else {
            System.out.println("MenuBoxLayout.java: update(): nothing to be updated.");
        }

    }




    public MenuBoxLayout(ImagesModel imagesModel) {
        super();
        this.setBackground(Color.WHITE);
//        this.setBackground(Color.GREEN);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));



        imagesModel2 = imagesModel;
        imagesModel2.addObserver(this);


//        JMenuBar menuBar = new JMenuBar();
//        JMenu theFile = new JMenu("File");
//        menuBar.add(theFile);
//        this.add(menuBar);

        ImageIcon gridIcon = new ImageIcon(getClass().getResource("/resources/GridView.png"));

        JButton gridButton = new JButton (gridIcon);
        gridButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("GridView Button Pressed");
                ImageIcon grid2Icon = new ImageIcon(getClass().getResource("/resources/GridViewSelected.png"));
                //gridButton = new JButton (grid2Icon);
//                selectView.SetView("GridView");
                imagesModel2.setViewValue("GridView");
            }
        });
        this.add(gridButton);


        ImageIcon listIcon = new ImageIcon(getClass().getResource("/resources/ListView.png"));
        JButton listButton = new JButton (listIcon);
        listButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("ListView Button Pressed");
//                selectView.SetView("ListView");
                imagesModel2.setViewValue("ListView");
            }
        });
        this.add(listButton);



////////////////////////////////////////////////////////////////////////////////////////////////////////////
        this.add(Box.createHorizontalGlue());
////////////////////////////////////////////////////////////////////////////////////////////////////////////



        ImageIcon loadIcon = new ImageIcon(getClass().getResource("/resources/LoadFiles.png"));
        JButton loadButton = new JButton (loadIcon);
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Load Button Pressed");

                FileFilter filter =  new FileNameExtensionFilter("PNG file (*.png)", "png");
                // Q. how do I add different types of files.
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.addChoosableFileFilter(filter);
                fileChooser.setMultiSelectionEnabled(true);
                fileChooser.setCurrentDirectory(new java.io.File("/Users/SPARK/Desktop"));
                fileChooser.setDialogTitle("Load a File");
                if(fileChooser.showOpenDialog(loadButton) == JFileChooser.APPROVE_OPTION) {

                    File[] files = fileChooser.getSelectedFiles();

                    for (File file : files) {
                        imagesModel.addPath(file.getAbsolutePath(),file.getName(), new Date(file.lastModified()));
                    }

//                    File f = new File(fileChooser.getSelectedFile().getAbsolutePath());
//
//                    imagesModel.addPath(fileChooser.getSelectedFile().getAbsolutePath(),
//                            fileChooser.getSelectedFile().getName(), new Date(fileChooser.getSelectedFile().lastModified()));


                    try {
                        FileOutputStream fileOut = new FileOutputStream("/tmp/ImageModel.ser");
                        ObjectOutputStream out = new ObjectOutputStream(fileOut);
                        out.writeObject(imagesModel2);
                        out.close();
                        fileOut.close();
                        System.out.println("Serialized data is saved in /tmp/ImageModel.ser");
                    } catch(IOException i) {
                        System.out.println("Serialized FAILED!!!");
                        i.printStackTrace();
                    }


                    System.out.println("Reading Complete.");

                };
                System.out.println("You chose: FileName: " + fileChooser.getSelectedFile().getName());
                System.out.println("You chose: FilePath: " + fileChooser.getSelectedFile().getAbsolutePath());

            }
        });
        this.add(loadButton);


        this.add(new JLabel("Filter by:"));



//////////////////////////////////////// STAR RATE BUTTONS ////////////////////////////////////////
//        starFilterModel.addObserver(this);


        star1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionListener Performed: 1");
                if (imagesModel.getStarFilterValue() == 1) {
                    imagesModel.setStarFilterValue(0);
                } else {
                    imagesModel.setStarFilterValue(1);
                }
            }
        });
        star2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionListener Performed: 2");
                if (imagesModel.getStarFilterValue() == 2) {
                    imagesModel.setStarFilterValue(0);
                } else {
                    imagesModel.setStarFilterValue(2);
                }
            }
        });
        star3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionListener Performed: 3");
                if (imagesModel.getStarFilterValue() == 3) {
                    imagesModel.setStarFilterValue(0);
                } else {
                    imagesModel.setStarFilterValue(3);
                }
            }
        });
        star4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionListener Performed: 4");
                if (imagesModel.getStarFilterValue() == 4) {
                    imagesModel.setStarFilterValue(0);
                } else {
                    imagesModel.setStarFilterValue(4);
                }
            }
        });
        star5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionListener Performed: 5");
                if (imagesModel.getStarFilterValue() == 5) {
                    imagesModel.setStarFilterValue(0);
                } else {
                    imagesModel.setStarFilterValue(5);
                }
            }
        });







        this.add(star1Button);
        this.add(star2Button);
        this.add(star3Button);
        this.add(star4Button);
        this.add(star5Button);
/////////////////////////////////////// STAR RATE BUTTONS ////////////////////////////////////////

    }


}














