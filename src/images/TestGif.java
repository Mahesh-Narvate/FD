/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package images;

import GUI.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Mahesh
 */
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class TestGif extends JFrame {
    JPanel contentPane;
    JLabel imageLabel = new JLabel();
    JLabel headerLabel = new JLabel();

    public TestGif() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            contentPane = (JPanel) getContentPane();
            contentPane.setLayout(new BorderLayout());
            setSize(new Dimension(400, 300));
            setTitle("Progress Pannel!");
            // add the header label
            headerLabel.setFont(new java.awt.Font("Comic Sans MS", Font.BOLD, 16));
            headerLabel.setText("   Please wait process is going on!");
            contentPane.add(headerLabel, java.awt.BorderLayout.NORTH);
            // add the image label
            ImageIcon ii = new ImageIcon(this.getClass().getResource(
                    "sample.gif"));
            imageLabel.setIcon(ii);
            contentPane.add(imageLabel, java.awt.BorderLayout.CENTER);
            // show it
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
       TestGif tg= new TestGif();
       tg.setVisible(true);
       tg.setSize(800, 400);
    }

}
