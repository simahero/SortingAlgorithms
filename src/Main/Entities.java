package Main;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

import static java.awt.Color.HSBtoRGB;

public class Entities {

    static int w = 7;
    int h;
    int id;
    Color c;

    static ArrayList<Entities> entitieslist = new ArrayList<Entities>();

    public Entities(int h, int id, float r) {
        this.h = h;
        this.id = id;
        this.c = new Color(HSBtoRGB(r, 1, 1));
    }

    public static void init() {
        for (int i = 0; i < 100; i++) {
            if (i < 50) {
                entitieslist.add(new Entities(i*12, i, i / 100f));
            } else {
                entitieslist.add(new Entities(((100-i)*12), i, i/100f));
            }
        }
    }


    public int getId() {
        return id;
    }


    public static Comparator<Entities> mycomporator = new Comparator<Entities>() {
        public int compare(Entities o1, Entities o2){
            int id1 = o1.getId();
            int id2 = o2.getId();

            return id1 - id2;
        }

    };


}
