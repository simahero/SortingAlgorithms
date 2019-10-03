package Main;

import java.util.ArrayList;
import java.util.Collections;

public class Control {

    public static void shuffle(ArrayList<Entities> arr) {
        Collections.shuffle(arr);
    }

    public static void sort(ArrayList<Entities> arr, ArrayList<Integer> order) {
        for (int i = 0; i < order.size() && i < arr.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (order.get(i) < order.get(j)) {
                    int temp = order.get(i);
                    order.set(i, order.get(j));
                    order.set(j, temp);
                    Entities temp1 = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp1);
                }

            }
        }

    }

}
