/*
 * Class to store metadata for a single sample.
 */
package components;

/**
 *
 * @author josephrobinson
 */
public class Metadata {
    String impath;
    int cluster;
    float confidence;
    String reference;
    
     Metadata(String path, int cluster, float score, String ref) {
        this.impath = path;
        this.cluster = cluster;
        this.confidence = score;
        this.reference = ref;
     }
    public String getPath(){
        return this.impath + this.reference;
    }
    public String getReference(){
        return this.reference;
    }
    public int getCluster(){
        return this.cluster;
    }
    public float getConfidence(){
        return this.confidence;
    }
    public void setCluster(int cluster){
        this.cluster = cluster;
    }
}
