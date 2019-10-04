package Main.Algorithms;

import Main.Entities;

import java.util.ArrayList;


public class BubbleSort extends Algorithms {

    static int n;
    static int i;
    static int j;

    @Override
    public void update(ArrayList<Entities> arr) {
        n = arr.size();
        if (arr.get(j).getId() < arr.get(j+1).getId()){
            Entities temp = arr.get(j);
            arr.set(j, arr.get(j+1));
            arr.set(j+1, temp);
        }

    }

    @Override
    public void increase() {
        if (j < n){
            j++;
        }
        if (j == n-1){
            j = 0;
            i++;
        }
    }
}

