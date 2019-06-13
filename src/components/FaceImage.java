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

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.imageio.ImageIO;
import views.Sample;

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
    HSLColor border_color;
    // Borders
    TitledBorder noFocus = BorderFactory.createTitledBorder(
            BorderFactory.createEmptyBorder());

    TitledBorder focused;

    FaceImage(Metadata meta) {
        this.meta = meta;

        this.loadImage();
        this.initComponents();

    }

    private void initComponents() {

        // set color to paint border
        float hue = this.HUE_ULIMIT * this.confidence;
        this.border_color = new HSLColor(hue);
        
        // create and add border to image icon to represent confidence
        this.focused = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(this.border_color.getRGB(), this.BORDER_THICKNESS));

        this.setIcon(new ImageIcon(this.face));

        // Set the border with the name of the sample
        this.setBorder(this.noFocus);

        // removes the "button" look
        this.setContentAreaFilled(false);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("clicked");
            }
        });

        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // add border
                FaceImage.this.setBorder(FaceImage.this.focused);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // remove border
                FaceImage.this.setBorder(FaceImage.this.noFocus);
            }

        });
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

}
