package Main.Algorithms;

import Main.BasicTimer;
import Main.Entities;
import java.util.ArrayList;

public class InsertionSort extends Algorithms {

    static int i = 1;
    static int j;
    static int n;

    public void update(ArrayList<Entities> arr) {
        BasicTimer.changeFPS(30);
        j = i -1;
        n = arr.size();
        int key = arr.get(i).getId();

        while (j >= 0 && arr.get(j).getId() > key) {
            Entities temp = arr.get(j+1);
            arr.set(j+1, arr.get(j));
            arr.set(j, temp);
            j = j - 1;
        }
    }

    @Override
    public void increase() {
        if (i < n-1) {
            ++i;
        }
    }

    @Override
    public void reset() {
        i = 1;
        j = 0;
    }
}



