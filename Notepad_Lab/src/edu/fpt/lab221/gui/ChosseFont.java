/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fpt.lab221.gui;

import edu.fpt.lab221.gui.Main;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import javax.swing.DefaultListModel;

/**
 *
 * @
 */
public class ChosseFont extends javax.swing.JDialog {

    /**
     * Creates new form Font
     */
    public ChosseFont(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        AddListFont();
        AddListSize();
        setSampleText();
        
    }

    void setSampleText() {
        Font f = ((Main) this.getParent()).getJtxtNotepad().getFont();
        jlbSample.setFont(f);

        jtfFont.setText(f.getFontName());
        jListFont.setSelectedValue(f.getFontName(), true);
        
        
        jtfStyle.setText(String.valueOf(f.getStyle()));
        jListStyle.setSelectedIndex(f.getStyle());
        
        jtfSize.setText(Integer.toString(f.getSize()));
        jListSize.setSelectedValue(f.getSize(), true);
    }
    
    private void AddListSize() {
        DefaultListModel model = new DefaultListModel();
        for (int i = 8; i < 50; i += 2) {
            model.addElement(i);
        }
        jListSize.setModel(model);
    }

    private void AddListFont() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String fontNames[] = ge.getAvailableFontFamilyNames();
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < fontNames.length; i++) {
            model.addElement(fontNames[i]);
        }
        jListFont.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfFont = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfStyle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfSize = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListFont = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListStyle = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListSize = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jlbSample = new javax.swing.JLabel();
        jbtCancel = new javax.swing.JButton();
        jbtOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Font:");

        jtfFont.setEnabled(false);

        jLabel2.setText("Font style:");

        jtfStyle.setEnabled(false);

        jLabel3.setText("Size:");

        jListFont.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListFont.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListFontValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListFont);

        jListStyle.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Normal", "Bold", "Italic", "Bold Italic" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListStyle.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListStyleValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jListStyle);

        jListSize.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListSize.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListSizeValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jListSize);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Sample"));

        jlbSample.setText("AaBbCcYyZz");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbSample)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbSample)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtCancel.setText("Cancel");
        jbtCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelActionPerformed(evt);
            }
        });

        jbtOK.setText("OK");
        jbtOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfFont))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jtfStyle)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jtfSize, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jbtOK, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtCancel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfFont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfStyle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jbtOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtOKActionPerformed
        ((Main) this.getParent()).getJtxtNotepad().setFont(jlbSample.getFont());
        dispose();
    }//GEN-LAST:event_jbtOKActionPerformed

    //LIST FONT
    private void jListFontValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListFontValueChanged
        // TODO add your handling code here:
        Font current = jlbSample.getFont();
        String fontName = jListFont.getSelectedValue().toString();
        int fontStyle = current.getStyle();
        int fontSize = current.getSize();
        jtfFont.setText(fontName);
        Font f = new Font(fontName, fontStyle, fontSize);
        jlbSample.setFont(f);
    }//GEN-LAST:event_jListFontValueChanged

    //LIST STYLE
    private void jListStyleValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListStyleValueChanged
        Font current = jlbSample.getFont();
        String fontName = current.getFontName();
        int fontStyle = jListStyle.getSelectedIndex();
        int fontSize = current.getSize();
        jtfStyle.setText(jListStyle.getSelectedValue().toString());
        Font f = new Font(fontName, fontStyle, fontSize);
        jlbSample.setFont(f);
    }//GEN-LAST:event_jListStyleValueChanged

    //LIST SIZE
    private void jListSizeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListSizeValueChanged
        Font current = jlbSample.getFont();
        String fontName = current.getFontName();
        int fontStyle = current.getStyle();
        int fontSize = (int) jListSize.getSelectedValue();
        jtfSize.setText(jListSize.getSelectedValue().toString());
        Font f = new Font(fontName, fontStyle, fontSize);
        jlbSample.setFont(f);
    }//GEN-LAST:event_jListSizeValueChanged

    //CANCEL
    private void jbtCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelActionPerformed
        dispose();
    }//GEN-LAST:event_jbtCancelActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jListFont;
    private javax.swing.JList jListSize;
    private javax.swing.JList jListStyle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtCancel;
    private javax.swing.JButton jbtOK;
    private javax.swing.JLabel jlbSample;
    private javax.swing.JTextField jtfFont;
    private javax.swing.JTextField jtfSize;
    private javax.swing.JTextField jtfStyle;
    // End of variables declaration//GEN-END:variables
}
