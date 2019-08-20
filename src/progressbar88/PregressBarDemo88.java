/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progressbar88;

import com.sun.istack.internal.logging.Logger;
import java.util.logging.Level;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author image
 */
public class PregressBarDemo88 extends javax.swing.JFrame {

    /**
     * Creates new form PregressBarDemo88
     */
    public PregressBarDemo88() {
        initComponents();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int num = 1; num <= 100; num++) {
                    try {
                        jp_progress.UpdateProgress(num);
                        jp_progress.repaint();
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PregressBarDemo88.class).log(Level.SEVERE, null, ex);

                    }

                }

            }
        }).start();

    }

    public  PregressBarDemo88(long eta, String Cloud_name) {
        initComponents();
        if (!Cloud_name.contains("list")) {
            jlblPutCloudname.setText("Data uploading on " + Cloud_name + " cloud ");
        } else {
            jlblPutCloudname.setText(Cloud_name);
        }
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int num = 1; num <= eta; num++) {
                    try {
                        jp_progress.UpdateProgress(num);
                        jp_progress.repaint();
                        Thread.sleep(50);
                        if (num == eta) {
                            dispose();
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PregressBarDemo88.class).log(Level.SEVERE, null, ex);

                    }

                }

            }
        }).start();
    }

    public PregressBarDemo88(long eta) {
        initComponents();
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int num = 1; num <= eta; num++) {
                    try {
                        jp_progress.UpdateProgress(num);
                        jp_progress.repaint();
                        Thread.sleep(50);
                        if (num == eta) {
                            dispose();
                        }

                    } catch (InterruptedException ex) {
                        Logger.getLogger(PregressBarDemo88.class).log(Level.SEVERE, null, ex);

                    }

                }

            }
        }).start();
        this.dispose();
        

    }

    public static void main(String[] args) {
        // TODO code application logic here
        PregressBarDemo88 pb = new PregressBarDemo88();
        pb.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_progress = new progressbar88.CustomPanel();
        jlblPutCloudname = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jp_progressLayout = new javax.swing.GroupLayout(jp_progress);
        jp_progress.setLayout(jp_progressLayout);
        jp_progressLayout.setHorizontalGroup(
            jp_progressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
        );
        jp_progressLayout.setVerticalGroup(
            jp_progressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        jlblPutCloudname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblPutCloudname.setForeground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jp_progress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlblPutCloudname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblPutCloudname, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jp_progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlblPutCloudname;
    private progressbar88.CustomPanel jp_progress;
    // End of variables declaration//GEN-END:variables
}
