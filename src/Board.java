import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Board extends JPanel implements ActionListener{
    public boolean going=false;
    private Timer timer = new Timer(40,this);
    private BufferedImage bg ;
    public static  BufferedImage car,car_l,car_r,car_o,car_p;
    public static LinkedList<Car> cars;
    public Board() {
        super();
        cars = new LinkedList<>();
        try {
            bg = ImageIO.read(new File("C:\\Users\\Rufus\\IdeaProjects\\Java2017_2018\\RoadCross\\src\\cross.jpg"));
            car = ImageIO.read(new File("C:\\Users\\Rufus\\IdeaProjects\\Java2017_2018\\RoadCross\\src\\car.png"));
            car_l = ImageIO.read(new File("C:\\Users\\Rufus\\IdeaProjects\\Java2017_2018\\RoadCross\\src\\car_l.png"));
            car_o = ImageIO.read(new File("C:\\Users\\Rufus\\IdeaProjects\\Java2017_2018\\RoadCross\\src\\car_o.png"));
            car_p = ImageIO.read(new File("C:\\Users\\Rufus\\IdeaProjects\\Java2017_2018\\RoadCross\\src\\car_p.png"));
            car_r = ImageIO.read(new File("C:\\Users\\Rufus\\IdeaProjects\\Java2017_2018\\RoadCross\\src\\car_r.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setPreferredSize(new Dimension(600,600));
        timer.start();
    }

    public void paintComponent(Graphics g)
    {
        requestFocusInWindow();
        g.drawImage(bg, 0, 0, null);
        for (Car car1 : cars) {
            car1.draw(g);
        }
        repaint();
    }

    public void add_car(int i) {
        if(cars.size()>15){
            System.out.print("Too many cars\n");
            return;
        }
        cars.add(new Car(i,this));
        new Thread(cars.getLast()).start();
        //System.out.print(i + "\n");
    }

    public static void remove(Car car1){
        cars.remove(car1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
        }
    }

    public synchronized void can_i(int start) throws InterruptedException {
        notifyAll();
        if(start==0)return;
        //System.out.print(going);
        boolean jade = true;
        while (jade) {
            if(going){
                wait(40);
                continue;
            }
            jade = false;
            switch (start) {
                case 1: {
                    for (Car car1 : cars) {
                        if (car1.getX() > 230 && car1.getStart() == 4) {
                            wait(40);
                            jade=true;
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    for (Car car1 : cars) {
                        if (car1.getX() < 350 && car1.getStart() == 3) {
                            wait(40);
                            jade=true;
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    for (Car car1 : cars) {
                        if (car1.getY() > 230 && car1.getStart() == 1) {
                            wait(40);
                            jade=true;
                            break;
                        }
                    }
                    break;
                }
                case 4: {
                    for (Car car1 : cars) {
                        if (car1.getY() < 350 && car1.getStart() == 2) {
                            wait(40);
                            jade=true;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        notifyAll();
    }
}
