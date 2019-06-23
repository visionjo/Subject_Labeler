/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.main;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import old.Configurations;
import components.GalleryPanel;
import views.About;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import views.ImageGallery;
import views.Sample;
import java.io.FileFilter;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FilenameFilter;


/**
 *
 * @author jrobby
 */
public class Main_Frame extends javax.swing.JFrame {

    // <editor-fold defaultstate="collapsed" desc="Global Vars">
    Configurations configs;
    public HashMap<Integer, String> face_lut;
    public HashMap<Integer, String> fid_lut;
    public HashMap<Integer, ArrayList<String>> cluster_lut;
    String c_subject; // current subjects
    String file_csv;
    ImageGallery ig;
    GalleryPanel panel;
    JFrame frame;
    //</editor-fold>

    /**
     * Main_Frame(): Creates new form Main_Frame
     */
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public Main_Frame() {
        configs = new Configurations();
        initComponents();
//        get_luts();s

//        sample_ids_lut = new Sample_LUT(configs.f_sample_lut, configs.do_debug);
//        sample_ids_lut.readLUT();
        this.setName("Main_Frame");

    }
    //</editor-fold>


    private void set_window_state() {
        // Set the appropriate state of all components of main GUI (ie this)
        if (cb_classes.getItemCount() > 0) {
            b_go.setEnabled(true);
        } else {
            b_go.setEnabled(false);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_south = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        b_finalize = new javax.swing.JButton();
        b_load = new javax.swing.JButton();
        tf_rootdir = new javax.swing.JTextField();
        cb_classes = new javax.swing.JComboBox<>();
        b_go = new javax.swing.JButton();
        b_next = new javax.swing.JButton();
        b_prev = new javax.swing.JButton();
        tf_csvfile = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mn_file = new javax.swing.JMenu();
        mnu_load_database = new javax.swing.JMenuItem();
        mnu_close = new javax.swing.JMenuItem();
        mnu_quit = new javax.swing.JMenuItem();
        mn_help = new javax.swing.JMenu();
        mnu_about = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("File Settings"));

        b_finalize.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        b_finalize.setText("Done");
        b_finalize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_finalizeActionPerformed(evt);
            }
        });

        b_load.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        b_load.setText("Load");
        b_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_loadActionPerformed(evt);
            }
        });

        tf_rootdir.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        tf_rootdir.setText("test/images/subject1/");
        tf_rootdir.setToolTipText("");
        tf_rootdir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_rootdirActionPerformed(evt);
            }
        });

        cb_classes.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        b_go.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        b_go.setText("Go!");
        b_go.setToolTipText("Press to load clustered faces for FID selected in dropdown menu.");
        b_go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_go_pressed(evt);
            }
        });

        b_next.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        b_next.setText("Next");
        b_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_nextActionPerformed(evt);
            }
        });

        b_prev.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        b_prev.setText("Prev");
        b_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_prevActionPerformed(evt);
            }
        });

        tf_csvfile.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        tf_csvfile.setText("test/cluster_assignments.csv");
        tf_csvfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_csvfileActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/josephrobinson/WORK/Subject_Labeler/resources/ismConnect-logo.png")); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_prev)
                .addGap(30, 30, 30)
                .addComponent(cb_classes, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(b_next)
                .addGap(42, 42, 42)
                .addComponent(b_finalize, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tf_rootdir, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_csvfile, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b_load, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_go, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tf_csvfile, tf_rootdir});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {b_go, b_load});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {b_next, b_prev});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_load, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_csvfile, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_rootdir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_go, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_classes, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_next, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_prev, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_finalize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tf_csvfile, tf_rootdir});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {b_go, b_load});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {b_next, b_prev});

        javax.swing.GroupLayout p_southLayout = new javax.swing.GroupLayout(p_south);
        p_south.setLayout(p_southLayout);
        p_southLayout.setHorizontalGroup(
            p_southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_southLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        p_southLayout.setVerticalGroup(
            p_southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_southLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        mn_file.setText("File");

        mnu_load_database.setText("Load Database");
        mn_file.add(mnu_load_database);

        mnu_close.setText("Close Database");
        mn_file.add(mnu_close);

        mnu_quit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        mnu_quit.setText("Quit");
        mnu_quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_quitActionPerformed(evt);
            }
        });
        mn_file.add(mnu_quit);

        jMenuBar1.add(mn_file);

        mn_help.setText("Help");

        mnu_about.setText("About");
        mnu_about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_aboutActionPerformed(evt);
            }
        });
        mn_help.add(mnu_about);

        jMenuBar1.add(mn_help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_south, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(p_south, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnu_quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_quitActionPerformed

        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_mnu_quitActionPerformed

    private void mnu_aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_aboutActionPerformed

        About ab = new About();
        ab.setAlwaysOnTop(true);
        ab.setVisible(true);
    }//GEN-LAST:event_mnu_aboutActionPerformed

    private void b_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_prevActionPerformed
        try {
            this.cb_classes.setSelectedIndex(this.cb_classes.getSelectedIndex() - 1);
            if (cb_classes.getSelectedIndex() > 1) {
                this.file_csv = System.getProperty("user.dir") + "/info/" + "cluster_ids_"
                        + cb_classes.getItemAt(cb_classes.getSelectedIndex()) + ".csv";
                System.out.println(file_csv);
            }
        } catch (IllegalArgumentException e) {
        }
    }//GEN-LAST:event_b_prevActionPerformed

    private void b_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_nextActionPerformed
        try {
            this.cb_classes.setSelectedIndex(this.cb_classes.getSelectedIndex() + 1);
            if (cb_classes.getSelectedIndex() > -1) {
                this.file_csv = System.getProperty("user.dir") + "/info/" + "cluster_ids_"
                        + cb_classes.getItemAt(cb_classes.getSelectedIndex()) + ".csv";
                System.out.println(file_csv);
            }
        } catch (IllegalArgumentException e) {
        }
    }//GEN-LAST:event_b_nextActionPerformed

    public List<String> findFoldersInDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        FileFilter directoryFileFilter = new FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory();
            }
        };

        File[] directoryListAsFile = directory.listFiles(directoryFileFilter);
        List<String> foldersInDirectory = new ArrayList<String>(directoryListAsFile.length);
        for (File directoryAsFile : directoryListAsFile) {
            foldersInDirectory.add(directoryAsFile.getName());
        }

        return foldersInDirectory;
    }

    public void addClasses2ComboBox(List<String> classes) {

        for (int i = 0; i < classes.size(); i++) {
//            if(configs.do_debug)
//                System.out.println(classes.get(i));
            cb_classes.addItem(classes.get(i));
        }
    }

    private void b_go_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_go_pressed
        // Get subdirectories in root directory and add to comboBox
        // get list, assume subdirectories are class names/ labels
        String directory = tf_rootdir.getText();
        List<String> folders = findFoldersInDirectory(directory);

//        if (folders.isEmpty()) {
//            //custom title, error icon
//            JOptionPane.showMessageDialog(new JFrame(),
//                    "No subdirectories found.",
//                    "Loading Error",
//                    JOptionPane.ERROR_MESSAGE);
//            return;
//        }
        // sort and add to comboBox
        Collections.sort(folders);
        addClasses2ComboBox(folders);
        initGallery();

    }//GEN-LAST:event_b_go_pressed

    private void b_finalizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_finalizeActionPerformed
        String outpath = System.getProperty("user.dir") + "/data/" + c_subject
                + "_cluster_out.csv";
        try {
            JFrame frame = new JFrame();
            frame.setPreferredSize(new Dimension(200, 200));
            this.ig.finalize(outpath);
            JOptionPane.showMessageDialog(frame, "Family: " + c_subject + " clusters finalized!");
        } catch (IOException e) {
        }
    }//GEN-LAST:event_b_finalizeActionPerformed

    private void b_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_loadActionPerformed

        String csvfile = tf_csvfile.getText();
        File cfile = new File(csvfile);
        if (!cfile.isFile()) {

            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
            fc.setDialogTitle("Import Cluster CSV File:");
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            if (fc.showOpenDialog(b_load) == JFileChooser.APPROVE_OPTION) {
                //
            }
            cfile = fc.getSelectedFile();
        }
        file_csv = cfile.toString();
        System.out.println(file_csv);
        System.out.println(System.getProperty("user.dir"));
    }//GEN-LAST:event_b_loadActionPerformed

    private void tf_rootdirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rootdirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_rootdirActionPerformed

    private void tf_csvfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_csvfileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_csvfileActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//                PropertyConfigurator.configure("log4j.properties");
//        LOGGER.info("Start GUI");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Frame().setVisible(true);
            }
        });
    }

    // class id for images

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_finalize;
    private javax.swing.JButton b_go;
    private javax.swing.JButton b_load;
    private javax.swing.JButton b_next;
    private javax.swing.JButton b_prev;
    private javax.swing.JComboBox<String> cb_classes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenu mn_file;
    private javax.swing.JMenu mn_help;
    private javax.swing.JMenuItem mnu_about;
    private javax.swing.JMenuItem mnu_close;
    private javax.swing.JMenuItem mnu_load_database;
    private javax.swing.JMenuItem mnu_quit;
    private javax.swing.JPanel p_south;
    private javax.swing.JTextField tf_csvfile;
    private javax.swing.JTextField tf_rootdir;
    // End of variables declaration//GEN-END:variables

    // array of supported extensions (use a List if you prefer)
    static final String[] EXTENSIONS = new String[]{
        "gif", "png", "bmp", "jpg", "jpeg" // and other formats you need
    };
    // filter to identify images based on their extensions
    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };

    public ArrayList getDirectoryContents(String dir) {

        File[] files = (new File(dir)).listFiles(IMAGE_FILTER);
        ArrayList fnames;
        fnames = new ArrayList();
        for (File file : files) {
            if (configs.do_debug) {
                System.out.println(file);
            }
            fnames.add(file.getName());
        }
        return fnames;
    }

    public void initGallery() {
        this.c_subject = cb_classes.getItemAt(cb_classes.getSelectedIndex());

        this.panel = new GalleryPanel(this.c_subject, this.tf_csvfile.getText(), 
                tf_rootdir.getText() + File.separator);

        this.frame = new JFrame();
        this.frame.add(this.panel);
        this.frame.pack();
        this.frame.setVisible(true);
    }

    // set default focus to first sample in unknown panel
    public void setDefaultFocus(Sample samp) {
        this.ig.setDefaultFocus(samp);
    }
}
