package Main.Algorithms;

import Main.Control;
import Main.Driver;
import Main.Entities;
import java.util.ArrayList;

public abstract class Algorithms {

    public static void selectItem() {
        Driver.algorithms = null;
        if (Control.selectedItem.equals("Bubble Sort!")) {
            Driver.algorithms = new BubbleSort();
        } else if (Control.selectedItem.equals("Insertion Sort!")) {
            Driver.algorithms = new InsertionSort();
        } else if (Control.selectedItem.equals("Selection Sort!")){
            Driver.algorithms = new SelectionSort();
        }
    }

    public abstract void update(ArrayList<Entities> arr);

    public abstract void increase();

    public abstract void reset();
}
