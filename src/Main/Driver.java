package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;

public class Driver implements Runnable{

    private JFrame frame;
    private static Canvas canvas;
    static int i;
    static int j;
    boolean running = true;



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
        /*
        for (int i = 0; i < Entities.entitieslist.size(); i++){
            g.setColor(Entities.entitieslist.get(i).c);
            g.fillRect((100+i*Entities.w), 100, Entities.w, Entities.h);
        }

         */
        g.dispose();
        bs.show();
    }

    public static void updare(){
        if (Entities.entitieslist.get(i).getId() < Entities.entitieslist.get(j).getId()){
            Entities temp1 = Entities.entitieslist.get(i);
            Entities.entitieslist.set(i, Entities.entitieslist.get(j));
            Entities.entitieslist.set(j, temp1);
        }

    }


    @Override
    public void run() {
        BasicTimer timer = new BasicTimer(240);
        while (running) {
            timer.sync();
            render();
            updare();
            j++;
            if (j == 100-1){
                i++;
                j = i;
            }
            if (i == 100-1){
                running = false;
            }

        }
    }


    public static void main(String[] args) throws IOException {
        Entities.init();
        Control.shuffle(Entities.entitieslist);
        new Driver();
    }

}

