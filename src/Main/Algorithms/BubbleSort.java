package Main.Algorithms;

import Main.Entities;

import java.util.ArrayList;


public class BubbleSort extends Algorithms {
    @Override
    public void update(ArrayList<Entities> arr, int i, int j) {
        if (arr.get(j).getId() < arr.get(j+1).getId()){
            Entities temp = arr.get(j);
            arr.set(j, arr.get(j+1));
            arr.set(j+1, temp);
        }

    }
}

