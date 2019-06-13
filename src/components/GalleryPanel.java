/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author josephrobinson
 */
public class GalleryPanel extends JPanel { 
// abstract view foe samples, either a grid of clustered images,
// or in an same person/different person fashion

    // subject (or class) label
    String label;
    
    // path to metadata
    String csvpath;
    
    // panel where the grid is placed
    JPanel panel = new JPanel();
    
    // directory for sample images
    String imagedir;
    
    // reference to samples in this view (FOR CHANGING CLUSTERS)
    ArrayList<Sample> samples = new ArrayList<>();
    
     // rows and columns for grid
    public int row, col;
    
    public GalleryPanel(String label, String csvpath, String imdir) {
        this.label = label;
        this.csvpath = csvpath;
        this.imagedir = imdir;
        load();
    }
    
    final void load(){
        this.samples = SampleHandler.load(this.csvpath, this.imagedir);
        
        for (Sample sample : this.samples){
            sample.setHorizontalAlignment();
            this.add(sample.face);
        }
    }
    
    

//
//
//    
//    // load the Images as BufferedImages, resizes them to 75x75 pixels, creates
//    // a sample from the images, and adds the samples to the panel
//    final void loadImgs() throws FileNotFoundException {
//        BufferedImage img = null;
//        Sample samp;
//        for (String f : this.fnames) {
//            try {
//                // read the image
//                img = ImageIO.read(new File(this.imagedir + f));
//
//                // add the resized image as a Sample to the JPanel
//                samp = new Sample(this.getScaledImage(img, 75, 75), f,
//                        this.cluster);
//                
//                panel.add(samp);
//                this.face_icons.add(samp);
//            }
//            catch (FileNotFoundException ef) {
//                System.out.println("File not found");
//            }
//            catch (IOException e) { }
//        }
//    }
//    
//    // returns the JPanel filled with Samples in a grid
//    public JPanel getPanel() {
//        return this.panel;
//    }
//    
//    public FaceImage getFirst() {
//        return this.face_icons.get(0);
//    }
//    
//    /**
//     * Resizes an image using a Graphics2D object backed by a BufferedImage.
//     * @param srcImg - source image to scale
//     * @param w - desired width
//     * @param h - desired height
//     * @return - the new resized image
//     */
//    private Image getScaledImage(Image srcImg, int w, int h){
//        BufferedImage resizedImg = new BufferedImage(w, h, 
//                BufferedImage.TYPE_INT_RGB);
//        Graphics2D g2 = resizedImg.createGraphics();
//        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
//                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//        g2.drawImage(srcImg, 0, 0, w, h, null);
//        g2.dispose();
//        return resizedImg;
//    }
//    
//    public boolean hasMember(Sample samp) {
//        boolean result = false;
//        for (Sample s : this.ref_sample) {
//            if (s.equals(samp)) {
//                result = true;
//            }
//        }
//        return result;
//    }
//    
    // adds a sample to the view
    public void add(Sample sample) {
        this.samples.add(sample);
        this.updateSamps();
        this.panel.validate();
        this.panel.repaint();
    }
//    
//    // removes a sample from the view
//    public void remove(Sample samp) {
//        this.ref_sample.remove(samp);
//        this.updateSamps();
//        this.panel.revalidate();
//        this.panel.repaint();
//    }
//    
    // updates the shown samples
    private void updateSamps() {
        this.panel.removeAll();
        for (Sample s : this.samples) {
            this.panel.add(s.getImage());
        }
//        this.panel.revalidate();
//        this.revalidate();
    }
}


class SampleHandler {
          
    public static ArrayList load(String fname, String imdir){ 

        ArrayList<Sample> samples = new ArrayList(); 
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {

            br = new BufferedReader(new FileReader(fname));
            line = br.readLine();                       // skip heading
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] content = line.split(cvsSplitBy);
                int cid = Integer.parseInt(content[1]);
                float score = Float.parseFloat(content[2]);
                Sample sample = new Sample(imdir, cid, score , content[0]); 
                samples.add(sample);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }   
        return samples;
    }
}