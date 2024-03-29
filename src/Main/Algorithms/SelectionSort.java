package Main.Algorithms;

import Main.BasicTimer;
import Main.Entities;
import java.util.ArrayList;

public class SelectionSort extends Algorithms {

    static int n;
    static int i = 0;
    static int j;

    @Override
    public void update(ArrayList<Entities> arr) {
        BasicTimer.changeFPS(3000);
        n = arr.size();
        int min_index = arr.get(i).getId();

        if (j < 0 || j >= n) {
            return;
        } else {
            if (arr.get(j).getId() < arr.get(min_index).getId()) {
                min_index = arr.get(j).getId();
            }
        }

        Entities temp = arr.get(min_index);
        arr.set(min_index, arr.get(i));
        arr.set(i, temp);
    }

    @Override
    public void increase() {
        if (j < n) {
            j++;
        }
        if (j == n - 1) {
            i++;
            j = i + 1;
        }
    }

    @Override
    public void reset() {

    }

}
