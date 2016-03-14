package Model;

import java.util.Observable;

/**
 * Created by SPARK on 2016-03-08.
 */
public class SelectView extends Observable {


//    private int gridView = 1;
//    // gridView = 0; --> ListView


    private boolean isGridView = true;
    private boolean isListView = false;

    public SelectView(boolean isGridView, boolean isListView) {
        this.isGridView = isGridView;
        this.isListView = isListView;
    }



    public void SetView (String viewType) {
        if (viewType == "GridView") {
//        if (Object.equals(viewType, "GridView")) {
            isGridView = true;
            isListView = false;
        } else if (viewType == "ListView") {
//        } else if (Object.equals(viewType, "ListView")) {
            isGridView = false;
            isListView = true;
        } else System.out.println("--------*** WARNING: THIS SHOULD NEVER APPEAR ***--------");
        setChanged();
        notifyObservers();

        if (isGridView == true) System.out.println("GridView Selected");
        else if (isListView == true) System.out.println("ListView Selected");
        else System.out.println("--------*** WARNING: THIS SHOULD NEVER APPEAR ***--------");
    }


// Not to be used!
    public boolean isGridView() {
        return isGridView;
    }

    public void setGridView(boolean gridView) {
        isGridView = gridView;
    }

    public boolean isListView() {
        return isListView;
    }

    public void setListView(boolean listView) {
        isListView = listView;
    }
}
