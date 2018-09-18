package com.genuinecoder;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.swing.FontIcon;

/**
 * @author Villan
 */
public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        setTitle("Genuine Coder");
        prepareIcons();
        pack();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        root = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        root.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rootMouseClicked(evt);
            }
        });
        root.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(root, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(root, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rootMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rootMouseClicked
        FontIcon fontIcon = FontIcon.of(MaterialDesign.MDI_YOUTUBE_PLAY);
        fontIcon.setIconSize(50);
        fontIcon.setIconColor(Color.RED);
        JOptionPane.showConfirmDialog(rootPane, "Upload to YouTube?", "Upload video", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, fontIcon);
    }//GEN-LAST:event_rootMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    private void prepareIcons() {
        addIcon(MaterialDesign.MDI_ACCOUNT);
        addIcon(MaterialDesign.MDI_ACCOUNT_ALERT);
        addIcon(MaterialDesign.MDI_ACCOUNT_BOX);
        addIcon(MaterialDesign.MDI_ACCOUNT_CHECK);
        addIcon(MaterialDesign.MDI_ACCOUNT_CIRCLE);
        addIcon(MaterialDesign.MDI_ACCOUNT_MULTIPLE);
        addIcon(MaterialDesign.MDI_ACCOUNT_STAR_VARIANT);
        addIcon(MaterialDesign.MDI_AIRPLANE_OFF);
        addIcon(MaterialDesign.MDI_ZIP_BOX);
        addIcon(MaterialDesign.MDI_YOUTUBE_PLAY);
        addIcon(MaterialDesign.MDI_YELP);
        addIcon(MaterialDesign.MDI_XBOX_CONTROLLER);
        addIcon(MaterialDesign.MDI_WINDOW_OPEN);
        addIcon(MaterialDesign.MDI_WEATHER_WINDY_VARIANT);
        addIcon(MaterialDesign.MDI_VIEW_CAROUSEL);
        addIcon(MaterialDesign.MDI_SALE);
        addIcon(MaterialDesign.MDI_SATELLITE);
        addIcon(MaterialDesign.MDI_SAXOPHONE);
        addIcon(MaterialDesign.MDI_SCALE_BALANCE);
        addIcon(MaterialDesign.MDI_SCHOOL);
        addIcon(MaterialDesign.MDI_ACCOUNT_MINUS);
        addIcon(MaterialDesign.MDI_JEEPNEY);
        addIcon(MaterialDesign.MDI_LAMBDA);
        addIcon(MaterialDesign.MDI_KETTLE);
    }

    private void addIcon(MaterialDesign icon) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#FAFAFA"));
        panel.setBorder(new LineBorder(Color.GRAY));
        panel.setLayout(new GridLayout());
        panel.setSize(300, 300);

        FontIcon fontIcon = FontIcon.of(icon);
        fontIcon.setIconSize(150);
        fontIcon.setIconColor(Color.decode(getRandomColor()));

        JLabel label = new JLabel();
        label.setIcon(fontIcon);
        panel.add(label);
        root.add(panel);
    }

    private String getRandomColor() {
        String[] colors = {"#d32f2f", "#C2185B", "#7B1FA2", "#512DA8", "#303F9F", "#1976D2", "#0288D1", "#0097A7", "#00796B"};
        int index = new Random().nextInt(colors.length);
        return colors[index];
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel root;
    // End of variables declaration//GEN-END:variables

}
