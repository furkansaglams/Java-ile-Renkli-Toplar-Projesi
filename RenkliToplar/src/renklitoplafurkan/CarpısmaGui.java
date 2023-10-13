/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renklitoplafurkan;


import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

/**
 * @author Anak1n
 */

public class CarpısmaGui extends JPanel implements Runnable {
    Cizim cizim;


    ball[] b = new ball[100];

    boolean going = true;

    Thread animator;

    double deltaX;
    double deltaY;
    double deltaY1;
    double deltaX1;


    double distance;
    int Cap = 0;
    int trans;
    int RENK = 0;
    int adet = 0;
    int ONCEKİ=0;
    int yerindedurusunmu = 1;
    int i=0;

    public CarpısmaGui(int onceki,int hiz, int cap, int RENK, int yerindedur,int adet) {
        this.RENK = RENK;
        this.yerindedurusunmu = yerindedur;
        this.adet=adet;


for(int i=0;i<adet;i++)
        {
            Random r= new Random();
            int X=r.nextInt(1100);

            Random n= new Random();
            int Y=r.nextInt(700);
            b[i] = new ball(X, Y, cap, Color.red);
            b[i].setX(X);

            b[i].setY(Y);
            b[i].setxSpeed(hiz);
            b[i].setySpeed(hiz);
        }



        b[0] = new ball(100, 300, cap, Color.red);
        b[0].setX(100);
        b[0].setY(300);
        b[0].setxSpeed(hiz);
        b[0].setySpeed(hiz);
        animator = new Thread(this);
        animator.start();

    }

    @Override
    public void paintComponent(Graphics g) {



        super.paintComponent(g);
        for(int i=0;i<adet;i++)
        {
            b[i].draw(g);
        }
        switch (RENK) {
            case 1:
                setForeground(Color.BLACK);
                break;
            case 2:
                setForeground(Color.BLUE);
                break;
            case 3:
                setForeground(Color.red);
                break;
            case 4:
                setForeground(Color.GREEN);
                break;
        }





    }

    @Override
    public void run() {
        while (going) {

for(int i=0;i<adet;i++)
{
    b[i].move();
}


            checkCollision(trans, yerindedurusunmu,adet);




            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
            }
        }

    }

    public void checkCollision(int transmı, int yerindedursun,int adet) {

        if (transmı == 0) {
            for (int i = 0; i < adet-1; i++) {
                for (int j = i+ 1; j < adet; j++) {
                    deltaX = Math.abs(b[i].getX() - b[j].getX());
                    deltaY = Math.abs(b[i].getY() - b[j].getY());


                    distance = deltaX * deltaX + deltaY * deltaY;


                    if (distance < (b[i].getDiametar() / 2 + b[j].getDiametar() / 2) * (b[i].getDiametar() / 2 + b[j].getDiametar() / 2)) {



                        double newxSpeed1 = (b[i].getxSpeed() * (4 - 7) + (2 * 7 * b[j].getxSpeed())) / 11;

                        double newxSpeed2 = (b[j].getxSpeed() * (7 - 4) + (2 * 4 * b[i].getxSpeed())) / 11;

                        double newySpeed1 = (b[i].getySpeed() * (4 - 7) + (2 * 7 * b[j].getySpeed())) / 11;

                        double newySpeed2 = (b[j].getySpeed() * (7 - 4) + (2 * 4 * b[i].getySpeed())) / 11;


                        b[j].setxSpeed(newxSpeed2);
                        b[j].setySpeed(newySpeed2);
                        b[i].setxSpeed(newxSpeed1);
                        b[i].setySpeed(newySpeed1);
                    }
                }
            }
        }
                 else if (transmı == 3 & yerindedurusunmu == 1) {
                for (int i = 0; i < adet-1; i++) {
                    for (int j = i + 1; j < adet; j++) {
                        deltaX = Math.abs(b[i].getX() - b[j].getX());
                        deltaY = Math.abs(b[i].getY() - b[j].getY());
                        distance = deltaX * deltaX + deltaY * deltaY;


                        if (distance < (b[i].getDiametar() / 2 + b[j].getDiametar() / 2) * (b[i].getDiametar() / 2 + b[j].getDiametar() / 2)) {


                            double newxSpeed1 = 0;

                            double newxSpeed2 = 0;

                            double newySpeed1 = 0;

                            double newySpeed2 = 0;


                            b[j].setxSpeed(newxSpeed2);
                            b[j].setySpeed(newySpeed2);
                            b[i].setxSpeed(newxSpeed1);
                            b[i].setySpeed(newySpeed1);
                        }
                    }
                }
            }


       else if(transmı==4)
        {
            for (int i = 0; i < adet; i++) {


                for (int j = i + 1; j < adet; j++) {
                    deltaX = Math.abs(b[i].getX() - b[j].getX());
                    deltaY = Math.abs(b[i].getY() - b[j].getY());
                    distance = deltaX * deltaX + deltaY * deltaY;


                    if (distance < (b[i].getDiametar() / 2 + b[j].getDiametar() / 2) * (b[i].getDiametar() / 2 + b[j].getDiametar() / 2)) {
                        b[i].setDiametar(0);
                        b[i].setX(-10);
                        b[i].setY(-10);
                        b[j].setDiametar(0);
                        b[j].setY(-10);
                        b[j].setX(-10);
                    }


                }
            }
        }







        }
    }












