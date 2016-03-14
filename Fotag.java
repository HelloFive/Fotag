import Model.ImagesModel;
import View.LayoutFrame;
import View.NestedLayout;

import java.util.ArrayList;

/**
 * Created by SPARK on 2016-03-08.
 */
public class Fotag {

//    private ImagesModel imagesModel = new ImagesModel(new ArrayList<String>(), 0);

    public static void main(String args[]) {

        ImagesModel imagesModel = new ImagesModel(new ArrayList<String>(), 0);

        new LayoutFrame("Fotag!", new NestedLayout(imagesModel), imagesModel);
    }
}
