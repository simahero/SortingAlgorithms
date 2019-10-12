package Main;

import Main.Algorithms.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.ArrayList;

public class Driver implements Runnable{

    private JFrame frame;
    private static Canvas canvas;
    boolean running = true;

    private Algorithms algorithms;


    public Driver() throws IOException {
        frame = new JFrame("Sorting Algorithms");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas = new Canvas());
        frame.setSize(920,800);
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
        while (running) {
            timer.sync();
            render();
            update(Entities.entitieslist);
            increase();
        }
    }

    public static void main(String[] args) throws IOException {
        Entities.init();
        Control.shuffle(Entities.entitieslist);
        new Driver();
    }

}

