package View;

import Model.ImagesModel;
import Model.SelectView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import Model.ImagesModel;
import javafx.scene.layout.Pane;

/**
 * Created by SPARK on 2016-03-08.
 */
public class DisplayBox extends JPanel implements Observer {

    private ImagesModel imagesModel2;


    ImageIcon starAIcon = new ImageIcon(getClass().getResource("/resources/star1.png"));
    ImageIcon starBIcon = new ImageIcon(getClass().getResource("/resources/star2.jpeg"));
    ImageIcon starCIcon = new ImageIcon(getClass().getResource("/resources/star3.png"));



    @Override
    public void update(Observable observable, Object arg) {



        // File Save in Each Update --> This allows Saving Rates for each image.
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





        JButton star1Button = new JButton (starAIcon);
        JButton star2Button = new JButton (starAIcon);
        JButton star3Button = new JButton (starAIcon);
        JButton star4Button = new JButton (starAIcon);
        JButton star5Button = new JButton (starAIcon);


        System.out.println("DisplayBox.java: Update is Live. [START]");

        if(arg == "addPath") {
            imagesModel2 = (ImagesModel) observable;
            System.out.println("DisplayBox.java: arg == addPath");

        }


        else if(arg == "GridView") {
            System.out.println("DisplayBox.java: arg == GridView");

            this.removeAll();


            if(this.getSize().getWidth() < 900) {
                this.setLayout(new GridLayout(0,2));
            } else {
                this.setLayout(new GridLayout(0, 3));
            }

            ///////////////////////////////////////////////////////////////////
            for (int i=0; i<imagesModel2.getNumPaths(); i++) {
                System.out.println("-----------> TRIAL #" + i);

                ImageIcon picture2 = new ImageIcon(imagesModel2.getPaths().get(i));
                Image img = picture2.getImage();
                Image newimg = img.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH);
                ImageIcon picture3 = new ImageIcon(newimg);
                JButton pictureButton = new JButton(picture3);
                pictureButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame newFrame = new JFrame();
                        Image newimg2 = img.getScaledInstance(800,600, java.awt.Image.SCALE_SMOOTH);
                        ImageIcon picture4 = new ImageIcon (newimg2);
                        JButton pictureButton2 = new JButton(picture4);
                        newFrame.setContentPane(pictureButton2);
                        newFrame.setSize(800, 600);
                        newFrame.setMinimumSize(new Dimension(800,600));
                        newFrame.setMaximumSize(new Dimension(800,600));
                        newFrame.setLocationRelativeTo(null);
                        newFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                        newFrame.setVisible(true);
                        newFrame.setResizable(true);
                    }
                });

                JPanel tempPanel = new JPanel();
                tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.Y_AXIS));
                tempPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                tempPanel.add(pictureButton);

                tempPanel.add(new JLabel(imagesModel2.getNames().get(i)));
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                Date imageDate = imagesModel2.getModifiedDates().get(i);
                String strDate = df.format(imageDate);
                tempPanel.add(new JLabel(strDate));


                final int j = i;
                JPanel tempPanel3 = new RateArea(imagesModel2,j);

                tempPanel.add(tempPanel3);


                this.add(tempPanel);
                add(tempPanel);


                revalidate();
                repaint();
                this.revalidate();
                this.repaint();


            }

        }

        else if(arg == "ListView") {
            System.out.println("DisplayBox.java: arg == ListView");



            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


            this.removeAll();

            for (int i=0; i<imagesModel2.getNumPaths(); i++) {
                System.out.println("-----------> TRIAL #" + i);

                ImageIcon picture2 = new ImageIcon(imagesModel2.getPaths().get(i));
                Image img = picture2.getImage();
                Image newimg = img.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH);
                ImageIcon picture3 = new ImageIcon(newimg);
                JButton pictureButton = new JButton(picture3);
                pictureButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame newFrame = new JFrame();
                        Image newimg2 = img.getScaledInstance(800,600, java.awt.Image.SCALE_SMOOTH);
                        ImageIcon picture4 = new ImageIcon (newimg2);
                        JButton pictureButton2 = new JButton(picture4);
                        newFrame.setContentPane(pictureButton2);
                        newFrame.setSize(800, 600);
                        newFrame.setMinimumSize(new Dimension(800,600));
                        newFrame.setMaximumSize(new Dimension(800,600));
                        newFrame.setLocationRelativeTo(null);
                        newFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                        newFrame.setVisible(true);
                        newFrame.setResizable(true);
                    }
                });

                JPanel tempPanel = new JPanel();
                tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.X_AXIS));
                tempPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                tempPanel.add(pictureButton);

                JPanel tempPanel2 = new JPanel();
                tempPanel2.setLayout(new BoxLayout(tempPanel2, BoxLayout.Y_AXIS));


                tempPanel2.add(new JLabel(imagesModel2.getNames().get(i)));
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                Date imageDate = imagesModel2.getModifiedDates().get(i);
                String strDate = df.format(imageDate);
//                    tempPanel.add(new JLabel(imagesModel2.getModifiedDates().get(i)));
                tempPanel2.add(new JLabel(strDate));


                final int j = i;
                JPanel tempPanel3 = new RateArea(imagesModel2,j);

                tempPanel2.add(tempPanel3);
                tempPanel.add(tempPanel2);

//                this.add(tempPanel);
                add(tempPanel);


                revalidate();
                repaint();
                this.revalidate();
                this.repaint();


            }










        } else if (arg == "StarFilter") {
            System.out.println("*** In StarFilter is ALIVE!");
            if (imagesModel2.getViewValue() == "GridView") {

                this.removeAll();

                if(this.getSize().getWidth() < 900) {
                    this.setLayout(new GridLayout(0,2));
                } else {
                    this.setLayout(new GridLayout(0, 3));
                }

                for (int i=0; i<imagesModel2.getNumPaths(); i++) {
                    System.out.println("-----------> TRIAL #" + i + " / RateFilter = " + imagesModel2.getStarFilterValue());

//                        if (imagesModel2.getRates().get(i) >= 1) {
                    if (imagesModel2.getRates().get(i) >= imagesModel2.getStarFilterValue()) {

                        ImageIcon picture2 = new ImageIcon(imagesModel2.getPaths().get(i));
                        Image img = picture2.getImage();
                        Image newimg = img.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH);
                        ImageIcon picture3 = new ImageIcon(newimg);
                        JButton pictureButton = new JButton(picture3);
                        pictureButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame newFrame = new JFrame();
                                Image newimg2 = img.getScaledInstance(800,600, java.awt.Image.SCALE_SMOOTH);
                                ImageIcon picture4 = new ImageIcon (newimg2);
                                JButton pictureButton2 = new JButton(picture4);
                                newFrame.setContentPane(pictureButton2);
                                newFrame.setSize(800, 600);
                                newFrame.setMinimumSize(new Dimension(800,600));
                                newFrame.setMaximumSize(new Dimension(800,600));
                                newFrame.setLocationRelativeTo(null);
                                newFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                                newFrame.setVisible(true);
                                newFrame.setResizable(true);
                            }
                        });

                        JPanel tempPanel = new JPanel();
                        tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.Y_AXIS));
                        tempPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                        tempPanel.add(pictureButton);

                        tempPanel.add(new JLabel(imagesModel2.getNames().get(i)));
                        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                        Date imageDate = imagesModel2.getModifiedDates().get(i);
                        String strDate = df.format(imageDate);
                        tempPanel.add(new JLabel(strDate));


                        final int j = i;
                        JPanel tempPanel3 = new RateArea(imagesModel2, j);

                        tempPanel.add(tempPanel3);

                        this.add(tempPanel);
                        add(tempPanel);


                        revalidate();
                        repaint();
                        this.revalidate();
                        this.repaint();

                        System.out.println("-----------~~~~~~~~~> " + imagesModel2.getNames().get(i) + "'s Rate is " + i);


                    } else {
                        System.out.println("-----------~~~~~~~~~> " + imagesModel2.getNames().get(i) + "'s Rate is Not " + i);
                    }
                }

            } else if (imagesModel2.getViewValue() == "ListView") {

                this.removeAll();

                this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

                for (int i=0; i<imagesModel2.getNumPaths(); i++) {
                    System.out.println("-----------> TRIAL #" + i + " / RateFilter = " + imagesModel2.getStarFilterValue());

                    if (imagesModel2.getRates().get(i) >= imagesModel2.getStarFilterValue()) {



//                            for (int i=0; i<imagesModel2.getNumPaths(); i++) {
//                                System.out.println("-----------> TRIAL #" + i);

                        ImageIcon picture2 = new ImageIcon(imagesModel2.getPaths().get(i));
                        Image img = picture2.getImage();
                        Image newimg = img.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH);
                        ImageIcon picture3 = new ImageIcon(newimg);
                        JButton pictureButton = new JButton(picture3);
                        pictureButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame newFrame = new JFrame();
                                Image newimg2 = img.getScaledInstance(800,600, java.awt.Image.SCALE_SMOOTH);
                                ImageIcon picture4 = new ImageIcon (newimg2);
                                JButton pictureButton2 = new JButton(picture4);
                                newFrame.setContentPane(pictureButton2);
                                newFrame.setSize(800, 600);
                                newFrame.setMinimumSize(new Dimension(800,600));
                                newFrame.setMaximumSize(new Dimension(800,600));
                                newFrame.setLocationRelativeTo(null);
                                newFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                                newFrame.setVisible(true);
                                newFrame.setResizable(true);
                            }
                        });

                        JPanel tempPanel = new JPanel();
                        tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.X_AXIS));
                        tempPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                        tempPanel.add(pictureButton);

                        JPanel tempPanel2 = new JPanel();
                        tempPanel2.setLayout(new BoxLayout(tempPanel2, BoxLayout.Y_AXIS));


                        tempPanel2.add(new JLabel(imagesModel2.getNames().get(i)));
                        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                        Date imageDate = imagesModel2.getModifiedDates().get(i);
                        String strDate = df.format(imageDate);
                        tempPanel2.add(new JLabel(strDate));


                        final int j = i;
                        JPanel tempPanel3 = new RateArea(imagesModel2,j);

                        tempPanel2.add(tempPanel3);
                        tempPanel.add(tempPanel2);

                        add(tempPanel);

                        revalidate();
                        repaint();
                        this.revalidate();
                        this.repaint();

                        System.out.println("-----------~~~~~~~~~> " + imagesModel2.getNames().get(i) + "'s Rate is " + i);

                    } else {
                        System.out.println("-----------~~~~~~~~~> " + imagesModel2.getNames().get(i) + "'s Rate is Not " + i);
                    }

                }
            }
        }


        System.out.println("DisplayBox.java: Update is Live. [ENDED]");
    }







    public DisplayBox(ImagesModel imagesModel) {
        super();
        this.setBackground(Color.DARK_GRAY);
        imagesModel.addObserver(this);
        this.imagesModel2 = imagesModel;

        JButton star1Button = new JButton (starAIcon);
        JButton star2Button = new JButton (starAIcon);
        JButton star3Button = new JButton (starAIcon);
        JButton star4Button = new JButton (starAIcon);
        JButton star5Button = new JButton (starAIcon);


        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        System.out.println("-*-*-*-*-*- THE SCREEN SIZE: " + dim.getWidth() + " / " + dim.getHeight());


        if (imagesModel2.getNumPaths()>0) {
            System.out.println("---> imagesModel2.getViewValue() = " + imagesModel2.getViewValue());
//            for (int i=0; i<imagesModel2.getNumPaths(); i++) {
//                System.out.println("-----------> TRIAL #" + i);
            if (imagesModel2.getViewValue().equals("GridView")) {
//                if (imagesModel2.getViewValue()=="GridView") {
                System.out.println("------------*-> GridView");

                if(this.getSize().getWidth() < 900) {
                    this.setLayout(new GridLayout(0,2));
                } else {
                    this.setLayout(new GridLayout(0, 3));
                }

                ///////////////////////////////////////////////////////////////////
                for (int i=0; i<imagesModel2.getNumPaths(); i++) {
                    System.out.println("-----------> TRIAL #" + i);

                    ImageIcon picture2 = new ImageIcon(imagesModel2.getPaths().get(i));
                    Image img = picture2.getImage();
                    Image newimg = img.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon picture3 = new ImageIcon(newimg);
                    JButton pictureButton = new JButton(picture3);
                    pictureButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame newFrame = new JFrame();
                            Image newimg2 = img.getScaledInstance(800,600, java.awt.Image.SCALE_SMOOTH);
                            ImageIcon picture4 = new ImageIcon (newimg2);
                            JButton pictureButton2 = new JButton(picture4);
                            newFrame.setContentPane(pictureButton2);
                            newFrame.setSize(800, 600);
                            newFrame.setMinimumSize(new Dimension(800,600));
                            newFrame.setMaximumSize(new Dimension(800,600));
                            newFrame.setLocationRelativeTo(null);
                            newFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                            newFrame.setVisible(true);
                            newFrame.setResizable(true);
                        }
                    });

                    JPanel tempPanel = new JPanel();
                    tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.Y_AXIS));
                    tempPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    tempPanel.add(pictureButton);

                    tempPanel.add(new JLabel(imagesModel2.getNames().get(i)));
                    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                    Date imageDate = imagesModel2.getModifiedDates().get(i);
                    String strDate = df.format(imageDate);
//                    tempPanel.add(new JLabel(imagesModel2.getModifiedDates().get(i)));
                    tempPanel.add(new JLabel(strDate));


                    final int j = i;
                    JPanel tempPanel3 = new RateArea(imagesModel2,j);

                    tempPanel.add(tempPanel3);


                    this.add(tempPanel);
                    add(tempPanel);


                    revalidate();
                    repaint();
                    this.revalidate();
                    this.repaint();


                }

            } else if (imagesModel2.getViewValue().equals("ListView")) {
                System.out.println("------------*-> ListView");

                this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


                this.removeAll();

                for (int i=0; i<imagesModel2.getNumPaths(); i++) {
                    System.out.println("-----------> TRIAL #" + i);

                    ImageIcon picture2 = new ImageIcon(imagesModel2.getPaths().get(i));
                    Image img = picture2.getImage();
                    Image newimg = img.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon picture3 = new ImageIcon(newimg);
                    JButton pictureButton = new JButton(picture3);
                    pictureButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame newFrame = new JFrame();
                            Image newimg2 = img.getScaledInstance(800,600, java.awt.Image.SCALE_SMOOTH);
                            ImageIcon picture4 = new ImageIcon (newimg2);
                            JButton pictureButton2 = new JButton(picture4);
                            newFrame.setContentPane(pictureButton2);
                            newFrame.setSize(800, 600);
                            newFrame.setMinimumSize(new Dimension(800,600));
                            newFrame.setMaximumSize(new Dimension(800,600));
                            newFrame.setLocationRelativeTo(null);
                            newFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                            newFrame.setVisible(true);
                            newFrame.setResizable(true);
                        }
                    });

                    JPanel tempPanel = new JPanel();
                    tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.X_AXIS));
                    tempPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    tempPanel.add(pictureButton);

                    JPanel tempPanel2 = new JPanel();
                    tempPanel2.setLayout(new BoxLayout(tempPanel2, BoxLayout.Y_AXIS));


                    tempPanel2.add(new JLabel(imagesModel2.getNames().get(i)));
                    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                    Date imageDate = imagesModel2.getModifiedDates().get(i);
                    String strDate = df.format(imageDate);
//                    tempPanel.add(new JLabel(imagesModel2.getModifiedDates().get(i)));
                    tempPanel2.add(new JLabel(strDate));


                    final int j = i;
                    JPanel tempPanel3 = new RateArea(imagesModel2,j);

                    tempPanel2.add(tempPanel3);
                    tempPanel.add(tempPanel2);

//                this.add(tempPanel);
                    add(tempPanel);


                    revalidate();
                    repaint();
                    this.revalidate();
                    this.repaint();


                }
            } else {
                System.out.println("------------*-> ERROR #1");
//                    System.out.println("ERROR #1")
            }
        }
    }

}
