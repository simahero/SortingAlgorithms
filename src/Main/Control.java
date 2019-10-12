package Main;

import Main.Algorithms.Algorithms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class Control implements ActionListener {

    public static String selectedItem = "Bubble Sort!";

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JComboBox) {
            JComboBox cb = (JComboBox) e.getSource();
            selectedItem = (String) cb.getSelectedItem();
            Algorithms.selectItem();
        }
        if (e.getSource() instanceof JButton) {
            if (e.getActionCommand().equals("sort")) {
                Driver.bstart = true;
                Driver.bshuffle = false;
            }
            if (e.getActionCommand().equals("shuffle")) {
                Driver.bstart = false;
                Driver.bshuffle = true;
            }
        }
    }

    public static void shuffle(ArrayList<Entities> arr) {
        Collections.shuffle(arr);
    }

}
