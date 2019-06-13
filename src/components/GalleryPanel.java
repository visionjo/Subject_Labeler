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
 
    // adds a sample to the view
    public void add(Sample sample) {
        this.samples.add(sample);
        this.updateSamps();
        this.panel.validate();
        this.panel.repaint();
    }

    // updates the shown samples
    private void updateSamps() {
        this.panel.removeAll();
        for (Sample s : this.samples) {
            this.panel.add(s.getImage());
        }
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