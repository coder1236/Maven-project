//    uniCenta oPOS  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2018 uniCenta & previous Openbravo POS works
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

package com.openbravo.pos.admin;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.QBFCompareEnum;
import com.openbravo.data.user.EditorCreator;
import com.openbravo.data.user.ListProvider;
import com.openbravo.data.user.ListProviderCreator;
import com.openbravo.pos.forms.AppLocal;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author adrianromero
 */
public class JPeopleFinder extends javax.swing.JDialog implements EditorCreator {

    private PeopleInfo selectedPeople;
    private ListProvider lpr;

    /** Creates new form JPeopleFinder */
    private JPeopleFinder(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    }

    /**
     * Creates new form JPeopleFinder
     */
    private JPeopleFinder(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
    }

    /**
     *
     * @param parent
     * @param dlPeople
     * @return
     */
    public static JPeopleFinder getPeopleFinder(Component parent, DataLogicAdmin dlPeople) {
        Window window = getWindow(parent);

        JPeopleFinder myMsg;
        if (window instanceof Frame) {
            myMsg = new JPeopleFinder((Frame) window, true);
        } else {
            myMsg = new JPeopleFinder((Dialog) window, true);
        }
        myMsg.init(dlPeople);
        myMsg.applyComponentOrientation(parent.getComponentOrientation());
        return myMsg;
    }

    /**
     *
     * @return
     */
    public PeopleInfo getSelectedPeople() {
        return selectedPeople;
    }

    private void init(DataLogicAdmin dlPeople) {

        initComponents();

        jScrollPane1.getVerticalScrollBar().setPreferredSize(new Dimension(8, 8));
        m_jtxtName.addEditorKeys(m_jKeys);
        m_jtxtName.reset();
        lpr = new ListProviderCreator(dlPeople.getPeopleList(), this);
        jListPeople.setCellRenderer(new PeopleRenderer());

        getRootPane().setDefaultButton(jcmdOK);

        selectedPeople = null;
    }

    /**
     *
     * @param people
     */
    public void search(PeopleInfo people) {

        if (people == null 
                || people.getName() == null 
                || people.getName().equals("")) {
            m_jtxtName.reset();
            cleanSearch();
        } else {
            m_jtxtName.setText(people.getName());
            executeSearch();
        }
    }

    private void cleanSearch() {
        jListPeople.setModel(new MyListData(new ArrayList()));
    }

    /**
     * This method actions the User data search
     */
    public void executeSearch() {
        try {
            jListPeople.setModel(new MyListData(lpr.loadData()));
            if (jListPeople.getModel().getSize() > 0) {
                jListPeople.setSelectedIndex(0);
                }
        } catch (BasicException e) {
        }
    }

    /**
     *
     * @return creates object for search method
     * @throws BasicException
     */
    @Override
    public Object createValue() throws BasicException {

        Object[] afilter = new Object[12];

        if (m_jtxtName.getText() == null 
                || m_jtxtName.getText().equals("")) {
            afilter[0] = QBFCompareEnum.COMP_NONE;
            afilter[1] = null;
        } else {
            afilter[0] = QBFCompareEnum.COMP_RE;
            afilter[1] = "%" + m_jtxtName.getText() + "%";
        }

        return afilter;
    }

    private static Window getWindow(Component parent) {
        if (parent == null) {
            return new JFrame();
        } else if (parent instanceof Frame || parent instanceof Dialog) {
            return (Window) parent;
        } else {
            return getWindow(parent.getParent());
        }
    }

    private static class MyListData extends javax.swing.AbstractListModel {

        private final java.util.List m_data;

        public MyListData(java.util.List data) {
            m_data = data;
        }

        @Override
        public Object getElementAt(int index) {
            return m_data.get(index);
        }

        @Override
        public int getSize() {
            return m_data.size();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel(){
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
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLblName = new javax.swing.JLabel();
        m_jtxtName = new com.openbravo.editor.JEditorString();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPeople = new javax.swing.JList();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new com.openbravo.beans.JImageButton();
        jButton3 = new com.openbravo.beans.JImageButton();
        jPanel2 = new javax.swing.JPanel();
        m_jKeys = new com.openbravo.editor.JEditorKeys();
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jcmdCancel = new com.openbravo.beans.JImageButton();
        jcmdOK = new com.openbravo.beans.JImageButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(AppLocal.getIntString("form.usertitle")); // NOI18N
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(650, 300));

        jPanel9.setOpaque(false);
        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(450, 231));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel7.setOpaque(false);

        jLblName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblName.setText(AppLocal.getIntString("label.prodname")); // NOI18N
        jLblName.setMaximumSize(new java.awt.Dimension(60, 15));
        jLblName.setMinimumSize(new java.awt.Dimension(60, 15));
        jLblName.setPreferredSize(new java.awt.Dimension(110, 30));

        m_jtxtName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jtxtName.setOpaque(false);
        m_jtxtName.setPreferredSize(new java.awt.Dimension(250, 30));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(m_jtxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(m_jtxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        m_jtxtName.getAccessibleContext().setAccessibleName("");

        jPanel5.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.BorderLayout());

        jListPeople.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jListPeople.setFocusable(false);
        jListPeople.setRequestFocusEnabled(false);
        jListPeople.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListPeopleMouseClicked(evt);
            }
        });
        jListPeople.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListPeopleValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListPeople);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel6.setOpaque(false);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("pos_messages"); // NOI18N
        jButton1.setText(bundle.getString("button.reset")); // NOI18N
        jButton1.setToolTipText("Clear Filter");
        jButton1.setActionCommand("Reset ");
        jButton1.setFocusable(false);
        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setIconPrefix("undo-56");
        jButton1.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1);
        jButton1.getAccessibleContext().setAccessibleDescription("");

        jButton3.setText(bundle.getString("button.reset")); // NOI18N
        jButton3.setToolTipText("Execute Filter");
        jButton3.setFocusPainted(false);
        jButton3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton3.setIconPrefix("check-56");
        jButton3.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3);
        jButton3.getAccessibleContext().setAccessibleDescription("");

        jPanel4.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        m_jKeys.setOpaque(false);
        jPanel2.add(m_jKeys, java.awt.BorderLayout.NORTH);

        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel1.setOpaque(false);

        jcmdCancel.setText(AppLocal.getIntString("button.Cancel")); // NOI18N
        jcmdCancel.setFocusPainted(false);
        jcmdCancel.setFocusable(false);
        jcmdCancel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcmdCancel.setIconPrefix("cancel-56");
        jcmdCancel.setMargin(new java.awt.Insets(8, 16, 8, 16));
        jcmdCancel.setPreferredSize(new java.awt.Dimension(60, 60));
        jcmdCancel.setRequestFocusEnabled(false);
        jcmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmdCancelActionPerformed(evt);
            }
        });
        jPanel1.add(jcmdCancel);

        jcmdOK.setText(AppLocal.getIntString("button.OK")); // NOI18N
        jcmdOK.setEnabled(false);
        jcmdOK.setFocusPainted(false);
        jcmdOK.setFocusable(false);
        jcmdOK.setIconPrefix("check-56");
        jcmdOK.setMargin(new java.awt.Insets(8, 16, 8, 16));
        jcmdOK.setMaximumSize(new java.awt.Dimension(103, 44));
        jcmdOK.setMinimumSize(new java.awt.Dimension(103, 44));
        jcmdOK.setPreferredSize(new java.awt.Dimension(60, 60));
        jcmdOK.setRequestFocusEnabled(false);
        jcmdOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmdOKActionPerformed(evt);
            }
        });
        jPanel1.add(jcmdOK);

        jPanel8.add(jPanel1, java.awt.BorderLayout.LINE_END);

        jPanel2.add(jPanel8, java.awt.BorderLayout.SOUTH);

        jPanel9.add(jPanel2, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel9, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(758, 497));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void jcmdOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdOKActionPerformed

        selectedPeople = (PeopleInfo) jListPeople.getSelectedValue();
        dispose();

    }//GEN-LAST:event_jcmdOKActionPerformed

    private void jcmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdCancelActionPerformed
        
        dispose();

    }//GEN-LAST:event_jcmdCancelActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        executeSearch();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jListPeopleValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListPeopleValueChanged

        jcmdOK.setEnabled(jListPeople.getSelectedValue() != null);

    }//GEN-LAST:event_jListPeopleValueChanged

    private void jListPeopleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListPeopleMouseClicked

        if (evt.getClickCount() == 2) {
            selectedPeople = (PeopleInfo) jListPeople.getSelectedValue();
            dispose();
        }

    }//GEN-LAST:event_jListPeopleMouseClicked

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 
        m_jtxtName.reset();
        
        cleanSearch();
}//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.openbravo.beans.JImageButton jButton1;
    private com.openbravo.beans.JImageButton jButton3;
    private javax.swing.JLabel jLblName;
    private javax.swing.JList jListPeople;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private com.openbravo.beans.JImageButton jcmdCancel;
    private com.openbravo.beans.JImageButton jcmdOK;
    private com.openbravo.editor.JEditorKeys m_jKeys;
    private com.openbravo.editor.JEditorString m_jtxtName;
    // End of variables declaration//GEN-END:variables
}