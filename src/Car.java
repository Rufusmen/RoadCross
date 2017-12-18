import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Car implements Runnable {
    private static final int min = 5,max =10;
    private Image sprite;
    private int speedx,speedy;
    private Colider colider;
    private int x,y;
    private int destination;
    private int start;
    private Board board;

    public int getStart() {
        return start;
    }

    @Override
    public void run() {
        while (x>-30&&x<610&&y>-30&&y<610){
            if(x>230&&x<350&&y>220&&y<350){
                //System.out.print(destination + " "+ start +"\n");
                try {
                    board.can_i(start);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                board.going=true;
                //System.out.print("jade\n");
                if((start==1&&destination==2)||(start==2&&destination==1)||(start==3&&destination==4)||(start==4&&destination==3)) {
                    while (x > 230 && x < 350 && y > 220 && y < 350) {
                        x+=speedx;
                        y+=speedy;
                        try {
                            Thread.sleep(40);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                else {
                    switch (start){
                        case 1:{
                            if(destination==4){
                                while (y<300){
                                    y+=speedy;
                                    try {
                                        Thread.sleep(40);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                sprite=Board.car;
                                y=300;
                                speedx = speedy;
                                speedy=0;
                                while (x<350){
                                    x+=speedx;
                                    try {
                                        Thread.sleep(40);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }else{
                                while (y<260){
                                    y+=speedy;
                                    try {
                                        Thread.sleep(40);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                sprite=Board.car;
                                y=260;
                                speedx = -speedy;
                                speedy=0;
                                while (x>230){
                                    x+=speedx;
                                    try {
                                        Thread.sleep(40);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            break;
                        }
                        case 2:{
                            if(destination==4){
                                while (y>260){
                                    y+=speedy;
                                    try {
                                        Thread.sleep(40);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                sprite=Board.car;
                                y=260;
                                speedx = speedy;
                                speedy=0;
                                while (x>230){
                                    x+=speedx;
                                    try {
                                        Thread.sleep(40);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }else{
                                while (y>300){
                                    y+=speedy;
                                    try {
                                        Thread.sleep(40);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                sprite=Board.car;
                                y=300;
                                speedx = -speedy;
                                speedy=0;
                                while (x<350){
                                    x+=speedx;
                                    try {
                                        Thread.sleep(40);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            break;
                        }
                        case 3:{
                            if(destination==1){
                                while (x>315){
                                    x+=speedx;
                                    try {
                                        Thread.sleep(40);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                sprite=Board.car;
                                x=315;
                                speedy = speedx;
                                speedx=0;
                                while (y>220){
                                    y+=speedy;
                                    try {
                                        Thread.sleep(40);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }else{
                                while (x>275){
                                    x+=speedx;
                                    try {
                                        Thread.sleep(40);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                sprite=Board.car;
                                x=275;
                                speedy = -speedx;
                                speedx=0;
                                while (y<350){
                                    y+=speedy;
                                    try {
                                        Thread.sleep(40);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            break;
                        }
                        case 4:{
                            if(destination==2){
                                while (x<315){
                                    x+=speedx;
                                    try {
                                        Thread.sleep(40);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                sprite=Board.car;
                                x=315;
                                speedy = -speedx;
                                speedx=0;
                                while (y>220){
                                    y+=speedy;
                                    try {
                                        Thread.sleep(40);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }else{
                                while (x<275){
                                    x+=speedx;
                                    try {
                                        Thread.sleep(40);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                sprite=Board.car;
                                x=275;
                                speedy = speedx;
                                speedx=0;
                                while (y<350){
                                    y+=speedy;
                                    try {
                                        Thread.sleep(40);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
                board.going=false;
                try {
                    board.can_i(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //System.out.print("juz\n");
            }
            boolean free=true;
            while(free) {
                for (int i = 0; i < Board.cars.size(); i++) {
                    if (Board.cars.get(i) == this) {
                        free = false;
                        break;
                    }
                    if (colider.intersects(Board.cars.get(i).colider)) {
                        speedy = Board.cars.get(i).speedy;
                        speedx = Board.cars.get(i).speedx;
                        try {
                            Thread.sleep(40);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
            }
            x+=speedx;
            y+=speedy;
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Board.remove(this);
    }


    public Car(int start,Board bor) {
        board = bor;
        destination = ThreadLocalRandom.current().nextInt(1,4);
        colider = new Colider(this);
        this.start=start;
        switch (start){
            case 1: {
                speedx=0;
                speedy=ThreadLocalRandom.current().nextInt(min,max+1);
                x = 275;
                y = -20;
                switch (destination){
                    case 1:
                        sprite = Board.car_o;
                        destination = 3;
                        break;
                    case 2:
                        sprite = Board.car;
                        destination = 2;
                        break;
                    case 3:
                        sprite = Board.car_p;
                        destination = 4;
                        break;
                }
                break;
            }
            case 2: {
                speedx = 0;
                speedy = -ThreadLocalRandom.current().nextInt(min, max + 1);
                x = 315;
                y = 600;
                switch (destination) {
                    case 1:
                        sprite = Board.car_l;
                        destination = 4;
                        break;
                    case 2:
                        sprite = Board.car;
                        destination = 1;
                        break;
                    case 3:
                        sprite = Board.car_r;
                        destination = 3;
                        break;
                }
                break;
            }
            case 3:{
                speedx = -ThreadLocalRandom.current().nextInt(min, max + 1);
                speedy = 0;
                x = 600;
                y = 260;
                switch (destination) {
                    case 1:
                        sprite = Board.car_o;
                        destination = 2;
                        break;
                    case 2:
                        sprite = Board.car;
                        destination = 4;
                        break;
                    case 3:
                        sprite = Board.car_l;
                        destination = 1;
                        break;
                }
                break;
            }
            case 4:{
                speedx = ThreadLocalRandom.current().nextInt(min, max + 1);
                speedy = 0;
                x = -20;
                y = 300;
                switch (destination) {
                    case 1:
                        sprite = Board.car_p;
                        destination = 1;
                        break;
                    case 2:
                        sprite = Board.car;
                        destination = 3;
                        break;
                    case 3:
                        sprite = Board.car_r;
                        destination = 2;
                        break;
                }
            }
        }
    }

    public void draw(Graphics g){
        g.drawImage(sprite, x, y,  null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
