/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renklitoplafurkan;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;


class CircleComponent extends JPanel {
   // Container box's width and height

   private static final int BOX_WIDTH =700;
   private static final int BOX_HEIGHT = 600;
   Ellipse2D.Double circle;

   // Ball's properties
   private float ballRadius = 100; // Ball's radius
   private float ballX = ballRadius + 50; // Ball's center (x, y)
   private float ballY = ballRadius + 20;
   private float ballSpeedX = 3;   // Ball's speed for x and y
   private float ballSpeedY = 2;
   int renk=1;
   int artır=0;
   int hız=0;

   private static final int UPDATE_RATE = 30; // Number of refresh per second

   /**
    * Constructor to create the UI components and init game objects.
    */
   public CircleComponent(int cap, int hız, int renk, int Artır, int hareket) {

       this.hız=hız;;
       Random r= new Random();
       ballX=r.nextInt(500);

       Random n= new Random();
       ballY=r.nextInt(500);

       ballRadius=cap;
       ballSpeedY= hız;



               ballSpeedX=hız;
       this.renk=renk;



       setOpaque(false);
       circle=new Ellipse2D.Double((int) (ballX - ballRadius), (int) (ballY - ballRadius),
               (int) (2 * ballRadius), (int) (2 * ballRadius));

       // Start the ball bouncing (in its own thread)
       Thread gameThread = new Thread() {
           public void run() {
               while (true) {
                   double w;
                   w=(2*3.14);
                   double degerx,degery;

                   if(hareket==1)
                   {
                       int i=0;
                       i++;
                       
                       if(i%2==0)
                       {
                           
                               degerx=ballRadius*(Math.sin(w))+ballRadius*Math.tan(w);
                           degery=ballRadius*(Math.cos(w))+ballRadius;
                               if(hız==0)
                               {
                                   degerx=0;
                                   degery=0;
                               }

                           
                           
                       }
                       else {
                           degerx=ballRadius*(Math.cos(w));
                           degery=ballRadius*(Math.sin(w))+ballRadius*Math.tan(w);
                           
                           if(hız==0)
                               {
                                   degerx=0;
                                   degery=0;
                               }

                       }
                       ballX = (float) (ballX+ ballSpeedX+degerx);
                       ballY = (float) (ballY+ ballSpeedY+degery);
                   }
                   else{
                       ballX += ballSpeedX;
                       ballY  += ballSpeedY;
                   }





// Execute one update step
                   // Calculate the ball's new position
                   
                   // Check if the ball moves over the bounds
                   // If so, adjust the position and speed.
                   if (ballX - ballRadius < 0) {
                       ballSpeedX = -ballSpeedX; // Reflect along normal
                       ballX = ballRadius; // Re-position the ball at the edge
                   } else if (ballX + ballRadius > BOX_WIDTH) {
                       ballSpeedX = -ballSpeedX;
                       ballX = BOX_WIDTH - ballRadius;
                   }
                   // May cross both x and y bounds
                   if (ballY - ballRadius < 0) {
                       ballSpeedY = -ballSpeedY;
                       ballY = ballRadius;
                   } else if (ballY + ballRadius > BOX_HEIGHT) {
                       ballSpeedY = -ballSpeedY;
                       ballY = BOX_HEIGHT - ballRadius;
                   }
                   // Refresh the display
                   repaint(); // Callback paintComponent()
                   // Delay for timing control and give other threads a chance
                   try {
                       Thread.sleep(1000 / UPDATE_RATE);  // milliseconds
                   } catch (InterruptedException ex) {
                   }
               }
           }
       };
       if(artır==0)
       {
           gameThread.start();
       }

       // Callback run()
   }

   public Dimension getPreferredSize()
   {
       Rectangle bounds = circle.getBounds();
       return new Dimension(bounds.width, bounds.height);
   }

   /**
    * Custom rendering codes for drawing the JPanel
    */



   @Override
   public void paintComponent(Graphics g) {
       super.paintComponent(g);
       Graphics2D g2 = (Graphics2D) g;
       System.out.println(ballX);
       System.out.println(ballRadius);
       circle=new Ellipse2D.Double((int) (ballX - ballRadius), (int) (ballY - ballRadius),
               (int) (2 * ballRadius), (int) (2 * ballRadius));


       // Draw the ball
       switch (renk) {
           case 1:
               g2.setColor(Color.BLACK);
               break;
           case 2:
               g2.setColor(Color.BLUE);
               break;
           case 3:
               g2.setColor(Color.red);
               break;
           case 4:
               g2.setColor(Color.GREEN);
               break;
       }




       g2.fill(circle);


   }
}
