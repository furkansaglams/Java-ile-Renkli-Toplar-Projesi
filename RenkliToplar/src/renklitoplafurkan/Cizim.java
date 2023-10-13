/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renklitoplafurkan;




import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.ImageObserver;
import java.lang.reflect.Array;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import javax.swing.border.Border;

public class Cizim extends JFrame implements ActionListener {
    int x;
    int y;
    int hizx = 1;
    int hizy = 1;
    int i = 0;
    int j = 0;
    int hizArt = 0;
    int hizAzl = 0;


    JPanel TEMELPANEL, SOLPANEL, SAGPANEL, TEXTPANEL, PANEL1, PANEL2, PANEL3;

    JButton b1 = new JButton("EKLE");
    JButton b2 = new JButton("temizle");
    JButton b3 = new JButton("+");
    JButton b4 = new JButton("-");
    JButton b5 = new JButton("+");
    JButton b6 = new JButton("-");
    JButton b7 = new JButton("yok olsun");
    JButton b8 = new JButton("yerinde dursun");
    JButton b9 = new JButton("hareket yönü değişsin");
    JButton b10 = new JButton("Transpara geçiş");
    JButton b11 = new JButton("FarklıRenklerYOAynıRenklerTG");
    JButton b12 = new JButton("FarklıRenklerYDAynıRenklerTG");
    JButton b13 = new JButton("FarklıRenklerHDAynıRenklerTG");
    JButton b14 = new JButton("FarklıRenklerYOCapıBuyukOlanYutarakBUYUSUNAynıRenkTG");
    JButton b15 = new JButton("Renk");
    JButton b16 = new JButton("Adedi");
    JButton b17 = new JButton("Hizi");
    JButton b18 = new JButton("Capi");


    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
    JTextField t4 = new JTextField();
    JTextField t5 = new JTextField();
    JTextField t6 = new JTextField();


    Cizim() {

        super("RENKLİ TOPLAR");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 730);
        setResizable(false);
        setLocationRelativeTo(null);


        TEMELPANEL = new JPanel();
        TEMELPANEL.setLayout(new GridLayout(0, 2));
        TEMELPANEL.setBackground(Color.WHITE);
        this.add(TEMELPANEL);
        TEMELPANEL.setLayout(new BorderLayout());


        SOLPANEL = new JPanel();
        SOLPANEL.setLayout(new GridLayout(3, 0));

        SOLPANEL.setBackground(Color.ORANGE);
        SOLPANEL.setSize(400, 700);
        TEMELPANEL.add(SOLPANEL);
        SOLPANEL.setBorder(BorderFactory.createLineBorder(Color.BLUE));


        SAGPANEL = new JPanel();
        SAGPANEL.setSize(400, 700);
        SAGPANEL.setBackground(Color.WHITE);
        TEMELPANEL.add(SAGPANEL);
        SAGPANEL.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        //SOL PANELE YAPILAN ARAYÜZ KODLARI

        JLabel l = new JLabel();
        l.setText("");
        l.setForeground(Color.ORANGE);
        l.setSize(50, 50);

        JLabel l1 = new JLabel();
        l1.setText("MASAYA TOP EKLEME ");
        l1.setForeground(Color.ORANGE);
        l1.setSize(50, 50);


        JLabel l2 = new JLabel();
        l2.setText("Renk: ");
        l2.setBackground(Color.BLACK);
        l2.setSize(50, 50);


        JLabel l3 = new JLabel();
        l3.setText("Adedi: ");
        l3.setBackground(Color.BLACK);
        l3.setSize(20, 20);

        JLabel l4 = new JLabel();
        l4.setText("Hizi: ");
        l4.setBackground(Color.BLACK);
        l4.setSize(50, 50);

        JLabel l5 = new JLabel();
        l5.setText("Hareket Turu: ");
        l5.setBackground(Color.BLACK);
        l5.setSize(50, 50);

        JLabel l6 = new JLabel();
        l6.setText("Capi: ");
        l6.setBackground(Color.BLACK);
        l6.setSize(50, 50);


        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b9.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);


        PANEL1 = new JPanel();
        PANEL1.setLayout(new GridLayout(7, 2));
        PANEL1.setBackground(Color.BLUE);
        PANEL1.setSize(200, 300);
        SOLPANEL.add(PANEL1);


        PANEL1.add(l1);
        PANEL1.add(l);
        PANEL1.add(l2);
        PANEL1.add(t2);
        PANEL1.add(l3);
        PANEL1.add(t3);
        PANEL1.add(l4);
        PANEL1.add(t4);
        PANEL1.add(l5);
        PANEL1.add(t5);
        PANEL1.add(l6);
        PANEL1.add(t6);


        PANEL1.add(b1);
        PANEL1.add(b2);


        PANEL1.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        PANEL2 = new JPanel();
        PANEL2.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel l7 = new JLabel();
        l7.setText("ÇAP");
        l7.setLayout(new GridLayout(2, 0));


        JLabel l8 = new JLabel();
        l8.setText("hız");


        PANEL2.setBackground(Color.ORANGE);
        PANEL2.setSize(200, 300);
        SOLPANEL.add(PANEL2);
        PANEL2.add(b3);
        PANEL2.add(l7);
        PANEL2.add(b4);

        PANEL2.add(b5);
        PANEL2.add(l8);
        PANEL2.add(b6);

        PANEL2.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        PANEL3 = new JPanel();
        PANEL3.setLayout(new FlowLayout(FlowLayout.CENTER));
        PANEL3.setBackground(Color.ORANGE);
        PANEL3.setSize(200, 400);

        PANEL3.add(b7);
        PANEL3.add(b8);
        PANEL3.add(b9);
        PANEL3.add(b10);

        PANEL3.add(b7);
        PANEL3.add(b8);
        PANEL3.add(b9);
        PANEL3.add(b10);

        PANEL3.add(b11);
        PANEL3.add(b12);
        PANEL3.add(b13);
        PANEL3.add(b14);


        SOLPANEL.add(PANEL3);
        PANEL3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {


        int renk = Integer.parseInt(t2.getText());
        int hizim = Integer.parseInt(t4.getText());
        int adedim = Integer.parseInt(t3.getText());
        int capım = Integer.parseInt(t6.getText());
        int Hareket = Integer.parseInt(t5.getText());

        if (e.getSource() == b1) {

            while (adedim > 0) {
                CircleComponent ball = new CircleComponent(capım, hizim, renk, 0, Hareket);

                ball.setBounds(500, 100, 1000, 700);


                SAGPANEL.add(ball);
                TEMELPANEL.repaint();
                adedim--;
            }


        }
        if (e.getSource() == b10) {
            CarpısmaGui balls = new CarpısmaGui(Hareket,hizim, capım, renk,0,adedim);

            balls.setBounds(400, 0, 1000, 700);
            balls.trans = 2;



            SAGPANEL.add(balls);
            TEMELPANEL.repaint();
        }


        if (e.getSource() == b9) {
            SAGPANEL.removeAll();
            CarpısmaGui balls = new CarpısmaGui(Hareket,hizim, capım, renk,0,adedim);

            balls.setBounds(400, 0, 1000, 700);


            balls.trans = 0;
            SAGPANEL.add(balls);
            TEMELPANEL.repaint();
        }
        if (e.getSource() == b8) {
            CarpısmaGui balls = new CarpısmaGui(Hareket,hizim, capım, renk,1,adedim);
            balls.setBounds(400, 0, 1000, 700);
            balls.trans = 3;
            balls.yerindedurusunmu = 1;


            SAGPANEL.add(balls);
            TEMELPANEL.repaint();
        }
        else if (e.getSource() == b7) {
            CarpısmaGui balls = new CarpısmaGui(Hareket,hizim, capım, renk,0,adedim);
            balls.setBounds(400, 0, 1000, 700);
            balls.trans = 4;
            balls.yerindedurusunmu = 0;


            SAGPANEL.add(balls);
            TEMELPANEL.repaint();
        }
        else if (e.getSource() == b2) {
            SAGPANEL.removeAll();
             i = 0;
              j = 0;
             hizArt = 0;
             hizAzl = 0;
            TEMELPANEL.repaint();
        } else if (e.getSource() == b4) {
            SAGPANEL.removeAll();
            j += 2;


            while (adedim > 0) {


                System.out.println("geldm");
                CircleComponent ball = new CircleComponent(capım+i - j, hizim, renk, 0, Hareket);

                ball.setBounds(410, 0, 1180, 700);


                SAGPANEL.add(ball);
                TEMELPANEL.repaint();
                adedim--;
            }
        } else if (e.getSource() == b5) {
            SAGPANEL.removeAll();

            hizArt += 5;

            while (adedim > 0) {


                System.out.println("geldm");
                CircleComponent ball = new CircleComponent(capım+i - j, hizim + hizArt-hizAzl, renk, 0, Hareket);

                ball.setBounds(410, 0, 1180, 700);


                SAGPANEL.add(ball);
                TEMELPANEL.repaint();
                adedim--;
            }
        } else if (e.getSource() == b6) {
            SAGPANEL.removeAll();


            while (adedim > 0) {

                hizAzl += 5;
                
                System.out.println("geldm");
                CircleComponent ball = new CircleComponent(capım+i - j, hizim +hizArt-hizAzl, renk, 0, Hareket);

                ball.setBounds(410, 0, 1180, 700);


                SAGPANEL.add(ball);
                TEMELPANEL.repaint();
                adedim--;
            }
        } else if (e.getSource() == b3) {
            SAGPANEL.removeAll();

            i += 10;
            while (adedim > 0) {


                CircleComponent ball = new CircleComponent(capım + i-j, hizim, renk, 0, Hareket);

                ball.setBounds(410, 0, 1180, 700);


                SAGPANEL.add(ball);
                TEMELPANEL.repaint();
                adedim--;
            }

        }

    }
}


