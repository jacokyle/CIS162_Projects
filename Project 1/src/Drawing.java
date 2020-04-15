import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
/**
 * This program displays my business card project.
 *
 * Kyle Jacobson
 * Version 1.0
 */
public class Drawing extends JPanel{
    public static void main(String[] a) {
        JFrame f = new JFrame();
        f.setContentPane(new Drawing());
        f.setSize(500, 300);
        f.setVisible(true);
    }

    int logosway = 40;
    int logoheave = -5;
    int picsway = 70;
    int picheave = 0;

    public void paintComponent(Graphics g){
        // this statement required
        super.paintComponent(g);

        // defines the background color (default is white)
        setBackground(Color.WHITE);

        // displays words for the company
        Font myFont = new Font ("arial", Font.BOLD, 18);
        g.setFont(myFont);
        g.setColor(Color.BLACK);
        g.drawString("DIGITAL CONCEPTIONS INC.", 15, 30);

        // displays words for the slogan
        Font myFont2 = new Font ("arial", Font.ITALIC, 14);
        g.setFont(myFont2);
        g.setColor(Color.BLACK);
        g.drawString("Conceptualizing your digital needs.", 35, 45);

        // draws a red rectangle for right side of business card
        g.setColor(Color.RED);
        g.fillRect(270, 10, 190, 250);

        // draws a black outline for right side of business card
        g.setColor(Color.BLACK);
        g.drawRect(270, 10, 190, 250);

        // displays words for your name
        Font myFont6 = new Font ("arial", Font.BOLD, 20);
        g.setFont(myFont6);
        g.setColor(Color.WHITE);
        g.drawString("Kyle D. Jacobson", 284, 255);

        // draws a solid and empty rectangle for the border
        g.setColor(Color.BLACK);
        g.drawRect(10, 10, 450, 250);

        // displays a picture of yourself
        BufferedImage photo = null;
        try {
            File file = new File("MyPhoto.jpg");
            photo = ImageIO.read(file);
        } catch (IOException e){
            g.drawString("Problem reading the file", 100, 100);
        }
        g.drawImage(photo, 220 + picsway, 45 + picheave, 150, 153, null);

        // creates a white box that outlines the picture
        g.setColor(Color.WHITE);
        g.drawRect(220 + picsway, 45 + picheave, 150, 153);

        // draws a big red oval for logo
        g.setColor(Color.RED);
        g.fillOval(50 + logosway, 90 + logoheave, 100, 100);

        // draws a big white oval inside big red oval for logo
        g.setColor(Color.WHITE);
        g.fillOval(60 + logosway, 100 + logoheave, 80, 80);

        // draws a black oval inside big white oval for logo
        g.setColor(Color.BLACK);
        g.fillOval(70 + logosway, 110 + logoheave, 60, 60);

        // draws a white oval for logo gap
        g.setColor(Color.WHITE);
        g.fillOval(25 + logosway, 60 + logoheave, 65, 65);

        // draws a small red oval for logo
        g.setColor(Color.RED);
        g.fillOval(25 + logosway, 60 + logoheave, 60, 60);

        // draws a small white oval inside small red oval for logo
        g.setColor(Color.WHITE);
        g.fillOval(32 + logosway, 67 + logoheave, 45, 45);

        // draws a small black oval inside small white oval for logo
        g.setColor(Color.BLACK);
        g.fillOval(40 + logosway, 75 + logoheave, 30, 30);

        // displays words for phone number
        Font myFont3 = new Font ("arial", Font.ITALIC, 15);
        g.setFont(myFont3);
        g.setColor(Color.BLACK);
        g.drawString("Phone: 800-437-9980", 15, 215);

        // displays words for email address
        Font myFont4 = new Font ("arial", Font.ITALIC, 15);
        g.setFont(myFont4);
        g.setColor(Color.BLACK);
        g.drawString("Email: jacokyle@mail.gvsu.edu", 15, 235);

        // displays words for address
        Font myFont5 = new Font ("arial", Font.ITALIC, 15);
        g.setFont(myFont5);
        g.setColor(Color.BLACK);
        g.drawString("Address: 124 Conch St, Waterville, MI", 15, 255);
    }
}
