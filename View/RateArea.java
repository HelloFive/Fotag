package View;

import Model.ImagesModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by SPARK on 2016-03-08.
 */
public class RateArea extends JPanel implements Observer {


    ImageIcon starAIcon = new ImageIcon(getClass().getResource("/resources/star1.png"));
    ImageIcon starBIcon = new ImageIcon(getClass().getResource("/resources/star2.jpeg"));
    ImageIcon starCIcon = new ImageIcon(getClass().getResource("/resources/star3.png"));


    JButton star1Button = new JButton (starAIcon);
    JButton star2Button = new JButton (starAIcon);
    JButton star3Button = new JButton (starAIcon);
    JButton star4Button = new JButton (starAIcon);
    JButton star5Button = new JButton (starAIcon);


    int index2;
    ImagesModel imagesModel2;

//    String strIndex;

    @Override
    public void update(Observable observable, Object arg) {


        System.out.println("DisplayBox.java: Update is Live. [STARTED]");


        if (arg == Integer.toString(index2) ){
            if (imagesModel2.getRates().get(index2) == 0) {
                star1Button = new JButton (starAIcon);
                star2Button = new JButton (starAIcon);
                star3Button = new JButton (starAIcon);
                star4Button = new JButton (starAIcon);
                star5Button = new JButton (starAIcon);

            } else if (imagesModel2.getRates().get(index2) == 1) {
                star1Button = new JButton (starCIcon);
                star2Button = new JButton (starAIcon);
                star3Button = new JButton (starAIcon);
                star4Button = new JButton (starAIcon);
                star5Button = new JButton (starAIcon);

            } else if (imagesModel2.getRates().get(index2) == 2) {
                star1Button = new JButton (starCIcon);
                star2Button = new JButton (starCIcon);
                star3Button = new JButton (starAIcon);
                star4Button = new JButton (starAIcon);
                star5Button = new JButton (starAIcon);

            } else if (imagesModel2.getRates().get(index2) == 3) {
                star1Button = new JButton (starCIcon);
                star2Button = new JButton (starCIcon);
                star3Button = new JButton (starCIcon);
                star4Button = new JButton (starAIcon);
                star5Button = new JButton (starAIcon);

            } else if (imagesModel2.getRates().get(index2) == 4) {
                star1Button = new JButton (starCIcon);
                star2Button = new JButton (starCIcon);
                star3Button = new JButton (starCIcon);
                star4Button = new JButton (starCIcon);
                star5Button = new JButton (starAIcon);

            } else if (imagesModel2.getRates().get(index2) == 5) {
                star1Button = new JButton (starCIcon);
                star2Button = new JButton (starCIcon);
                star3Button = new JButton (starCIcon);
                star4Button = new JButton (starCIcon);
                star5Button = new JButton (starCIcon);

            } else {
                System.out.println("RateArea.java: ERROR: This should NEVER appear!!!");
            }
        }



        System.out.println("DisplayBox.java: Update is Live. [ENDED]");
    }










    public RateArea(ImagesModel imagesModel, int index) {

        index2 = index;
        imagesModel2 = imagesModel;

        star1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionListener Performed: 1");
                if (imagesModel.getRates().get(index) == 1) {
                    imagesModel.setRates(index, 0);
                } else {
                    imagesModel.setRates(index, 1);
                }
                System.out.println("Rate of " + (index+1) + "th picture: " + imagesModel.getNames().get(index) + " = " + imagesModel.getRates().get(index));
            }
        });
        star2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionListener Performed: 2");
                if (imagesModel.getRates().get(index) == 2) {
                    imagesModel.setRates(index, 0);
                } else {
                    imagesModel.setRates(index, 2);
                }
                System.out.println("Rate of " + (index+1) + "th picture: " + imagesModel.getNames().get(index) + " = " + imagesModel.getRates().get(index));
            }
        });
        star3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionListener Performed: 3");
                if (imagesModel.getRates().get(index) == 3) {
                    imagesModel.setRates(index, 0);
                } else {
                    imagesModel.setRates(index, 3);
                }
                System.out.println("Rate of " + (index+1) + "th picture: " + imagesModel.getNames().get(index) + " = " + imagesModel.getRates().get(index));
            }
        });
        star4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionListener Performed: 4");
                if (imagesModel.getRates().get(index) == 4) {
                    imagesModel.setRates(index, 0);
                } else {
                    imagesModel.setRates(index, 4);
                }
                System.out.println("Rate of " + (index+1) + "th picture: " + imagesModel.getNames().get(index) + " = " + imagesModel.getRates().get(index));
            }
        });
        star5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionListener Performed: 5");
                if (imagesModel.getRates().get(index) == 5) {
                    imagesModel.setRates(index, 0);
                } else {
                    imagesModel.setRates(index, 5);
                }
                System.out.println("Rate of " + (index+1) + "th picture: " + imagesModel.getNames().get(index) + " = " + imagesModel.getRates().get(index));
            }
        });

        if (imagesModel.getRates().get(index) == 0) {
            star1Button.setIcon(starAIcon);
            star2Button.setIcon(starAIcon);
            star3Button.setIcon(starAIcon);
            star4Button.setIcon(starAIcon);
            star5Button.setIcon(starAIcon);
        } else if (imagesModel.getRates().get(index) == 1) {
            star1Button.setIcon(starCIcon);
            star2Button.setIcon(starAIcon);
            star3Button.setIcon(starAIcon);
            star4Button.setIcon(starAIcon);
            star5Button.setIcon(starAIcon);
        } else if (imagesModel.getRates().get(index) == 2) {
            star1Button.setIcon(starCIcon);
            star2Button.setIcon(starCIcon);
            star3Button.setIcon(starAIcon);
            star4Button.setIcon(starAIcon);
            star5Button.setIcon(starAIcon);
        } else if (imagesModel.getRates().get(index) == 3) {
            star1Button.setIcon(starCIcon);
            star2Button.setIcon(starCIcon);
            star3Button.setIcon(starCIcon);
            star4Button.setIcon(starAIcon);
            star5Button.setIcon(starAIcon);
        } else if (imagesModel.getRates().get(index) == 4) {
            star1Button.setIcon(starCIcon);
            star2Button.setIcon(starCIcon);
            star3Button.setIcon(starCIcon);
            star4Button.setIcon(starCIcon);
            star5Button.setIcon(starAIcon);
        } else if (imagesModel.getRates().get(index) == 5) {
            star1Button.setIcon(starCIcon);
            star2Button.setIcon(starCIcon);
            star3Button.setIcon(starCIcon);
            star4Button.setIcon(starCIcon);
            star5Button.setIcon(starCIcon);
        }



        this.add(star1Button);
        this.add(star2Button);
        this.add(star3Button);
        this.add(star4Button);
        this.add(star5Button);

        add(star1Button);
        add(star2Button);
        add(star3Button);
        add(star4Button);
        add(star5Button);

    }







}
