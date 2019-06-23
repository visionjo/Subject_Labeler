/*
 * Class for sample, label pairs.
 */
package components;

import javax.swing.JLabel;

/**
 *
 * @author josephrobinsonz
 */
public class Sample {
    FaceImage face;
    Metadata meta;
    
    Sample(String path, int cluster, float score, String ref){
        
        this.meta = new Metadata(path, cluster, score, ref);
        this.face = new FaceImage(this.meta);
    }
    public Metadata getMeta(){
        return this.meta;
    }
    public FaceImage getImage(){
        return this.face;
    }
    public void setHorizontalAlignment(){
        this.face.setHorizontalAlignment(JLabel.CENTER);
    }
}
