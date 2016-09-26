/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.lab221.business;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;

/**
 *
 * @author SonVu
 */
public class Bussiness {
    JFrame frame;
    JDialog dialog;
    JFileChooser jfc = new JFileChooser();
    boolean findDown = true;

    public Bussiness() {
    }

    public Bussiness(JFrame frame) {
        this.frame = frame;
    }

   public Bussiness(JDialog dialog) {
       this.dialog = dialog;
   }

    
    
    
    
    
    //OPEN FILE
    public void openFile(JTextArea txtArea) {
        FileNameExtensionFilter extension = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        jfc.setFileFilter(extension);
        int choice = jfc.showOpenDialog(frame);
        if (choice == JFileChooser.APPROVE_OPTION) {
            //File filechoosed = jfc.getSelectedFile();
            try {
                String path = jfc.getSelectedFile().getAbsolutePath();
                frame.setTitle(jfc.getSelectedFile().getName());
                txtArea.setText("");
                Scanner sc = new Scanner(new FileInputStream(path), "UTF-8");
                while (sc.hasNextLine()) {
                    txtArea.append(sc.nextLine() + "\n");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, ex);
            }
        }
    }
    
    //SAVE_FILE_AS
    public void saveFileAs(JTextArea txtArea) {
        FileNameExtensionFilter extension = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        jfc.setFileFilter(extension);
        int choice = jfc.showSaveDialog(frame);
        if (choice == JFileChooser.APPROVE_OPTION) {
            File filechoosed = jfc.getSelectedFile();
            try {
                //set Name of frame
                frame.setTitle(filechoosed.getName());
                //Read file and add to textarea
                FileWriter fwrite = new FileWriter(filechoosed);
                BufferedWriter bw = new BufferedWriter(fwrite);
                txtArea.write(bw);
                bw.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
    
    
    //SAVE_FILE
    public void saveFile(JTextArea txtArea) {
        File filechoosed = jfc.getSelectedFile();
        try {
            frame.setTitle(filechoosed.getName());
            FileWriter fw = new FileWriter(filechoosed);
            BufferedWriter bw = new BufferedWriter(fw);
            txtArea.write(bw);
            bw.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, ex);
        }
    }
    
    
    
    
    //FIND & HIGHLIGHT
    public void find(JTextArea txtArea, String search) {
        try {
            Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.red);

            Document doc = txtArea.getDocument();
            String text = doc.getText(0, doc.getLength());

            int pos = 0;

            while ((pos = text.toUpperCase().indexOf(search.toUpperCase(), pos)) >= 0) {
                //jtContent.select(pos, pos + search.length());
                txtArea.getHighlighter().addHighlight(pos, pos + search.length(), painter);
                pos += search.length();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, ex);
        }
    }
    
    //REMOVE HIGHLIGHT
    public void removeHighlight(JTextArea txtArea) {
        Highlighter hilite = txtArea.getHighlighter();

        Highlighter.Highlight[] hilites = hilite.getHighlights();

        for (int i = 0; i < hilites.length; i++) {
            hilite.removeHighlight(hilites[i]);
        }
    }
    
    
    //FIND NEXT
    public void FindText(JTextArea txtNotepad, String findStr) {
        String t = txtNotepad.getText();
        int posStart = txtNotepad.getCaretPosition();
        int pos;
        if (findDown) {
            pos = t.toUpperCase().indexOf(findStr.toUpperCase(), posStart);
            if (pos == -1) {
                JOptionPane.showMessageDialog(frame, "Not found!");
                txtNotepad.setCaretPosition(posStart);
            } else {
                txtNotepad.select(pos, pos + findStr.length());
            }
        } 
//        else {
//            if (txtNotepad.getSelectedText() != null) {
//                posStart -= txtNotepad.getSelectedText().length();
//            }
//            t = t.substring(0, posStart);
//            pos = t.lastIndexOf(findStr);
//            if (pos == -1) {
//                JOptionPane.showMessageDialog(frame, "Not found!");
//                txtNotepad.setCaretPosition(posStart);
//            } else {
//                txtNotepad.select(pos, pos + findStr.length());
//            }
//        }
    }
    
    //REPLACE_TEXT
    public void ReplaceText(JTextArea txtNotepad, String content, String findStr) {
        if (txtNotepad.getSelectedText() != null) {
            txtNotepad.replaceSelection(content);
        }
        String t = txtNotepad.getText();
        int posStart = txtNotepad.getCaretPosition();
        int pos = t.toUpperCase().indexOf(findStr.toUpperCase(), posStart);
        if (pos == -1) {
            posStart = 0;
            pos = t.toUpperCase().indexOf(findStr.toUpperCase(), posStart);
            if (pos == -1) {
                JOptionPane.showMessageDialog(frame, "Not found!");
                return;
            }
        }
        txtNotepad.select(pos, pos + findStr.length());
    }
    
    
    //REPLACE ALL
    public void ReplaceAll(JTextArea txtNotepad, String content, String findStr) {
        String t = txtNotepad.getText();
        t = t.replaceAll(findStr, content);
        txtNotepad.setText(t);
    }
    
    
    
    
}
