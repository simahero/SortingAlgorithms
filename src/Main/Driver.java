package Main;

import Main.Algorithms.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.ArrayList;

public class Driver implements Runnable{

    //FRAME
    private JFrame frame;
    private static Canvas canvas;
    private static JPanel panel;
    //BUTTONS
    private JButton start;
    public static boolean bstart = false;
    private JButton shuffle;
    public static boolean bshuffle = false;
    private JComboBox choose;
    //DRIVER VARIABLES
    Control control = new Control();
    public static Algorithms algorithms;


    public Driver() {
        frame = new JFrame("Sorting Algorithms");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout());
        frame.add(canvas = new Canvas());
        canvas.setSize(800, 800);
        frame.add(panel = new JPanel());

        start = new JButton("SORT!");
        start.setActionCommand("sort");
        start.addActionListener(control);
        panel.add(start);

        shuffle = new JButton("SHUFFLE!");
        shuffle.setActionCommand("shuffle");
        shuffle.addActionListener(control);
        panel.add(shuffle);

        String[] algorithms = {"Bubble Sort!", "Insertion Sort!", "Selection Sort!"};
        choose = new JComboBox<>(algorithms);
        choose.setSelectedIndex(0);
        choose.addActionListener(control);
        panel.add(choose);

        panel.setBackground(Color.BLACK);
        frame.setSize(1200,800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        new Thread(this).start();

    }

    private void render() {
        BufferStrategy bs = canvas.getBufferStrategy();
        if (bs == null){
            canvas.createBufferStrategy(2);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 920, 800);
        for (int i = 0; i < Entities.entitieslist.size(); i++) {
            g.setColor(Entities.entitieslist.get(i).c);
            g.fillRect((100+i*Entities.w), 100, Entities.w, Entities.entitieslist.get(i).h);
        }
        g.dispose();
        bs.show();
    }

    public void initialize(){
        algorithms = new BubbleSort();
    }

    public void update(ArrayList<Entities> arr){
        algorithms.update(arr);
    }

    public void increase(){
        algorithms.increase();
    }

    @Override
    public void run() {
        BasicTimer timer = new BasicTimer(30);
        initialize();
        Algorithms.selectItem();
        while (true) {
            timer.sync();
            render();
            if (bstart) {
                update(Entities.entitieslist);
                increase();
            }
            if (bshuffle){
                for (int i = 0; i < 100; i++) {
                    control.shuffle(Entities.entitieslist);
                }
                bshuffle = false;
            }
        }
    }

    public static void main(String[] args) {
        Entities.init();
        Control.shuffle(Entities.entitieslist);
        new Driver();
    }

}

