/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import javax.swing.JButton;

import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.imageio.ImageIO;
import views.Sample;
import java.awt.Graphics;

/**
 * Image with button functionality
 *
 * @author josephrobinson
 */
public class FaceImage extends JButton {

    // this value determines the range of colors that span for the border of the
    // image-- based on hue angle, red is 0 and 180 is green (0=red, 1=green)    
    static final float HUE_ULIMIT = 180.0f;
    static final int BORDER_THICKNESS = 3;
    static final int IMWIDTH = 100;
    static final int IMHEIGHT = 100;

    Image face;     // face image

    // image metadatas
    Metadata meta;
    // sample name
    String impath;

    // the cluster in its fid
    int cluster_id;

    // the cluster in its fid
    float confidence;

    // is image loaded in memory (i.e., stored in var face)
    boolean isloaded = false;
    Color border_color;
    // Borders
    TitledBorder noFocus = BorderFactory.createTitledBorder(
            BorderFactory.createEmptyBorder());

    TitledBorder focused;

    FaceImage(Metadata meta) {
        this.meta = meta;
        if (this.meta.getCluster() == 1) {
            this.border_color = Color.GREEN;
        } else {
            this.border_color = Color.RED;
            //            outline = this.border_color.getRGB();
        }
        this.loadImage();
        this.initComponents();
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // display/center the jdialog when the button is pressed
                int ncluster = Math.abs(FaceImage.this.meta.getCluster() - 1);
                FaceImage.this.meta.setCluster(ncluster);
                FaceImage.this.initComponents();
            }
        });

    }

    private void initComponents() {

        // set color to paint border
        float hue = this.HUE_ULIMIT * this.confidence;
        //        this.border_color = new HSLColor(hue);
        Color outline;

        // create and add border to image icon to represent confidence
        this.paintComponent(this.face.getGraphics());

        this.setIcon(new ImageIcon(this.face));

        // Set the border with the name of the sample
        this.setBorder(this.focused);

        // removes the "button" look
        this.setContentAreaFilled(false);

    }

    private void scaleImage() {
        /**
         * Resizes an image using a Graphics2D object backed by a BufferedImage.
         */
        if (!this.isloaded) {
            return;
        }

        BufferedImage resizedImg = new BufferedImage(this.IMWIDTH, this.IMHEIGHT,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(this.face, 0, 0, this.IMWIDTH, this.IMHEIGHT, null);
        g2.dispose();
        this.face = resizedImg;
    }

    private final void loadImage() {
        /**
         * Load image and rescale to proper size
         */
        BufferedImage img = null;
        Sample samp;
        try {
            // read the image
            img = ImageIO.read(new File(this.meta.getPath()));
            this.face = img;
            this.isloaded = true;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            this.isloaded = false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            this.isloaded = false;
        }
        this.scaleImage();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBorder(g);

        drawWhiteSpace(g);

//        g.drawString(Integer.toString(this.cluster_id) , 100, 100);
    }
    //drawWhiteSpace method will draw a white rectangle which start at the bottom-left corner -6 pixel, and go to the bottom rightcorner

    private void drawWhiteSpace(Graphics g) {
        int x1 = this.getSize().width - 15;
        int y1 = this.getSize().height - 15;
        int x2 = this.getSize().width;
        int y2 = this.getSize().height;
        g.setColor(Color.WHITE);
        g.fillRect(x1, y1, x2, y2);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Monospaced", Font.PLAIN, 10));
        g.drawString(Integer.toString(this.meta.getCluster()), (int) (x2 - 10), (int) (y2 - 3));
        g.setColor(Color.BLACK);
//        g.dispose();
    }

    //however the border was not fine, so i had to remove it and to draw it myself by drawing it from the top-left corner to the top-right corner of the white space
    private void drawBorder(Graphics g) {
        int x1 = 0;
        int y1 = 0;
        int x2 = this.getSize().width - this.BORDER_THICKNESS;
        int y2 = this.getSize().height - this.BORDER_THICKNESS;
        g.setColor(this.border_color);
        for (int i = 1; i <= this.BORDER_THICKNESS; i++) {
            g.drawRect(x1 + i, y1 + i, x2, y2 + i);
            g.drawRect(x1 + i, y1 + i, x2 + i, y2);
            g.drawRect(x1 + i, y1 + i, x2 + i, y2 + i);
        }
    }
}
