package Model;

import View.RateArea;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

/**
 * Created by SPARK on 2016-03-08.
 */
public class ImagesModel extends Observable implements java.io.Serializable {

    private Dimension screenSize = new Dimension();

    public Dimension getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Dimension screenSize) {
        this.screenSize = screenSize;
    }

    private String ViewValue = "GridView";

    public void setViewValue(String viewValue) {
        ViewValue = viewValue;
        setChanged();
        notifyObservers(viewValue);
    }
    public String getViewValue() {
        return ViewValue;
    }



//    private ImageData[] imageDatas;// = new ImageData[];


    private ArrayList<String> Paths = new ArrayList<String>();
    private ArrayList<String> Names = new ArrayList<String>();

    private ArrayList<Date> modifiedDates = new ArrayList<Date>();

    public ArrayList<Date> getModifiedDates() {
        return modifiedDates;
    }

    public void setModifiedDates(ArrayList<Date> modifiedDates) {
        this.modifiedDates = modifiedDates;
    }



    private int numPaths = 0;


// should I also save RateArea each time?
// In order to dynamically changing color of stars, I do think this is necessary.
// * whenever this updates, let's change the color of star according to this.
    private ArrayList<RateArea> rateAreas = new ArrayList<RateArea>();
    // build the constructor and getter and setter of above line.
//    public ArrayList<>



// No Constructor will be needed if I only use functions to take care of stored values.
//    public ImagesModel(ArrayList<String> paths, int ) {
//        Paths = paths;
//    }

    private ArrayList<Integer> Rates = new ArrayList<Integer>();


    public ArrayList<String> getPaths() {
        return Paths;
    }

    public ArrayList<String> getNames() { return Names; }

    public ArrayList<Integer> getRates() {
        return Rates;
    }
    public void setRates(int index, int rate) {
        Rates.set(index, rate);
        setChanged();
//        notifyObservers(Integer.toString(index));
        if(getViewValue() == "GridView") {
            notifyObservers("GridView");
        } else if (getViewValue() == "ListView") {
            notifyObservers("ListView");
        }
    }

    public ImagesModel(ArrayList<String> paths, int numPaths) {
        this.Paths = paths;
        this.numPaths = numPaths;
    }




    private int starFilterValue = 0;

//    public StarFilterModel(int starFilterValue) {
//        this.starFilterValue = starFilterValue;
//    }


    public int getStarFilterValue() {
        return starFilterValue;
    }

    public void setStarFilterValue(int starFilterValue) {
        this.starFilterValue = starFilterValue;
        setChanged();
        notifyObservers("StarFilter");
        System.out.println("setStarFilterValue("+starFilterValue+");");

    }




    public void setPaths(ArrayList<String> paths) {
        this.Paths = paths;
    }

    public void addPath(String path, String name, Date modifiedDate) {
        this.Paths.add(numPaths,path);
        this.Names.add(numPaths,name);
//        Paths.add(path);
        this.Rates.add(numPaths,0);
        this.numPaths++;
        this.modifiedDates.add(modifiedDate);

        setChanged();
        //notifyObservers();
        //notifyObservers("addPath");
        if (ViewValue == "GridView") {
            System.out.println("ImagesModel.java: GridView to be displayed");
            notifyObservers("GridView");
        }
        else if (ViewValue == "ListView") {
            System.out.println("ImagesModel.java: ListView to be displayed");
            notifyObservers("ListView");
        }
        System.out.println("ImagesModel: addPath(string) approached");

        for (int i=0; i<numPaths; i++) {
            System.out.println("-----" + (i+1) + "st path is: " + getPaths().get(i));
            System.out.println("-----" + (i+1) + "st path is: " + getNames().get(i));
            System.out.println("-----" + (i+1) + "st rate is: " + getRates().get(i));
        }
    }

    public int getNumPaths() { // Not expected to be used
        return numPaths;
    }

    public void setNumPaths(int numPaths) { // Not expected to be used
        this.numPaths = numPaths;
    }
}
