package Main.Algorithms;

import Main.Entities;
import java.util.ArrayList;

public class QuickSort extends Algorithms {

    int low = 0;
    int high = 100;


    @Override
    public void update(ArrayList<Entities> arr) {
        if (low < high) {

        }
    }


    @Override
    public void increase() {

    }

    Entities partition(ArrayList<Entities> arr, int low, int high) {
        Entities pivot = arr.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr.get(j).getId() < pivot.getId()) {
                i++;

                Entities temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        Entities temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return arr.get(i + 1);
    }
}
