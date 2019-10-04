package Main.Algorithms;

import Main.Entities;

import java.util.ArrayList;


public class InsertionSort extends Algorithms {

    static int i = 1;
    static int j;
    static int n;


    public void update(ArrayList<Entities> arr) {
        int n = arr.size();
        int key = arr.get(i).getId();

        while (j >= 0 && arr.get(j).getId() > key) {
            arr.set(j + 1, arr.get(j));
            j = j - 1;
        }
        arr.set(j + 1, arr.get(i));
    }



    @Override
    public void increase() {
        if (i < n) {
            i++;
            j = i - 1;
        }
    }
}



