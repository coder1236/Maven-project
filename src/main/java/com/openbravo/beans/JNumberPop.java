//    uniCenta oPOS  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2018 uniCenta - joint with Jacinto Rodriguez
//    https://unicenta.com
//
//    This file is part of uniCenta oPOS
//
//    uniCenta oPOS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//   uniCenta oPOS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with uniCenta oPOS.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.beans;

import com.openbravo.basic.BasicException;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;

/**
 * Dec 2017
 * @author  Jack Gerarrd uniCenta
 */
@Slf4j
public class JNumberPop extends javax.swing.JDialog {
    
    private static LocaleResources m_resources;
    
    private Integer m_value;
    
    /** Creates new form JNumberDialog
     * @param parent
     * @param modal */
    public JNumberPop(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        init();
    }
    
    /** Creates new form JNumberDialog
     * @param parent
     * @param modal */
    public JNumberPop(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        init();
    }
    
    private void init() {
        
        if (m_resources == null) {
            m_resources = new LocaleResources();
            m_resources.addBundleName("beans_messages");
        }
        
        initComponents();        
        getRootPane().setDefaultButton(jcmdOK);   
        
        m_jnumber.addEditorKeys(m_jKeys);
        m_jnumber.reset();
        m_jnumber.setValueInteger(1);
        m_jnumber.activate();
        m_jnumber.setVisible(false);
        
        m_jPanelTitle.setBorder(RoundedBorder.createGradientBorder());

        m_value = null;
    }
    
    private void setTitle(String title, String message, Icon icon) {
        setTitle(title);
        m_lblMessage.setText(message);
        m_lblMessage.setIcon(icon);
    }
    
    public static Integer showEditNumber(Component parent, String title) {
        return showEditNumber(parent, title, null, null);
    }
    public static Integer showEditNumber(Component parent, String title, String message) {
        return showEditNumber(parent, title, message, null);
    }
    public static Integer showEditNumber(Component parent, String title, String message, Icon icon) {
        
        Window window = SwingUtilities.windowForComponent(parent);
        
        JNumberPop myMsg;
        if (window instanceof Frame) { 
            myMsg = new JNumberPop((Frame) window, true);
        } else {
            myMsg = new JNumberPop((Dialog) window, true);
        }
        
        myMsg.setTitle(title, message, icon);
        myMsg.setVisible(true);
        return myMsg.m_value;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel() {
            protected void paintComponent(Graphics g)
            {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth();
                int h = getHeight();
                Color color1 = new Color(120, 120, 120);
                Color color2 = new Color(40,40,40);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
                super.paintComponent(g);
            }
        };
        jPanel2 = new javax.swing.JPanel();
        jPanelGrid = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        m_jKeys = new com.openbravo.editor.JEditorKeys();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        m_jnumber = new com.openbravo.editor.JEditorDoublePositive();
        jcmdOK = new com.openbravo.beans.JImageButton();
        m_jPanelTitle = new javax.swing.JPanel();
        m_lblMessage = new javax.swing.JLabel();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(30, 30, 30));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanelGrid.setOpaque(false);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        m_jKeys.setOpaque(false);
        m_jKeys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jKeysActionPerformed(evt);
            }
        });
        jPanel3.add(m_jKeys);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(290, 85));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(220, 50));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        m_jnumber.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jnumber.setOpaque(false);
        jPanel1.add(m_jnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 50));

        jPanel4.add(jPanel1, java.awt.BorderLayout.CENTER);

        jcmdOK.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcmdOK.setIconPrefix("check-56");
        jcmdOK.setMargin(new java.awt.Insets(8, 16, 8, 16));
        jcmdOK.setPreferredSize(new java.awt.Dimension(60, 60));
        jcmdOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmdOKActionPerformed(evt);
            }
        });
        jPanel4.add(jcmdOK, java.awt.BorderLayout.LINE_END);

        jPanel3.add(jPanel4);

        jPanelGrid.add(jPanel3);

        jPanel2.add(jPanelGrid, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel2, java.awt.BorderLayout.CENTER);

        m_jPanelTitle.setOpaque(false);
        m_jPanelTitle.setLayout(new java.awt.BorderLayout());

        m_lblMessage.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jPanelTitle.add(m_lblMessage, java.awt.BorderLayout.CENTER);

        jPanel5.add(m_jPanelTitle, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(339, 430));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jcmdOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdOKActionPerformed


        try {
            m_value = m_jnumber.getValueInteger();
        } catch (BasicException ex) {
            log.error(ex.getMessage());
        }
        setVisible(false);
        dispose();

        
    }//GEN-LAST:event_jcmdOKActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        setVisible(false);
        dispose();
        
    }//GEN-LAST:event_formWindowClosing

    private void m_jKeysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jKeysActionPerformed

    }//GEN-LAST:event_m_jKeysActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelGrid;
    private com.openbravo.beans.JImageButton jcmdOK;
    private com.openbravo.editor.JEditorKeys m_jKeys;
    private javax.swing.JPanel m_jPanelTitle;
    private com.openbravo.editor.JEditorDoublePositive m_jnumber;
    private javax.swing.JLabel m_lblMessage;
    // End of variables declaration//GEN-END:variables
    
}