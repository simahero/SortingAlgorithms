package Main.Algorithms;

import Main.Entities;

import java.util.ArrayList;

public class SelectionSort extends Algorithms {

    static int n;
    static int i;
    static int j;

    @Override
    public void update(ArrayList<Entities> arr) {
        n = arr.size();
        int min_index = arr.get(i).getId();

        if (arr.get(j).getId() < arr.get(min_index).getId()) {
            min_index = arr.get(j).getId();
        }

        Entities temp = arr.get(min_index);
        arr.set(min_index, arr.get(i));
        arr.set(i, temp);
    }


        @Override
        public void increase () {
            if (j < n) {
                j++;
            }
            if (j == n - 1) {
                i++;
                j = i+1;
            }
        }
    }
