/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package S0xxXepHinh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author sonvu
 */
public class ButtonXH extends JButton {

    int positionX, positionY, number;

    public ButtonXH(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

}

class QLButton extends JButton implements ActionListener {

    ButtonXH a[][];
    int length = 0;

    public QLButton(int size) {
        a = new ButtonXH[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                a[i][j] = new ButtonXH(i, j);
                a[i][j].number = (i) * size + (j + 1);
                a[i][j].setText(a[i][j].number + "");
                a[i][j].addActionListener((ActionListener) this);
            }
        }
        a[size - 1][size - 1].setText("");
        length = size;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int x = 0, y = 0;
        int x2 = 0, y2 = 0;
        String name = e.getActionCommand();
        if (name.equalsIgnoreCase("")) {
            return;
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (a[i][j].getText().equals(name)) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (a[i][j].getText().equals("")) {
                    x2 = i;
                    y2 = j;
                    break;
                }
            }
        }
        if (check(x, y, x2, y2)) {
            String temp = a[x][y].getText();
            a[x][y].setText(a[x2][y2].getText());
            a[x2][y2].setText(temp);
            XepHinh.count++;
            XepHinh.changeCount();

        } 

        if (end()) {
            XepHinh.cTime.suspend();
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    a[i][j].setEnabled(false);
                }
            }
            JOptionPane.showMessageDialog(null, "Win roi babe ~~~~!!!!!!!!");
        }

    }

    public void tron(int n) {
        int x = 0, y = 0;
        int x2 = 0, y2 = 0;
        String name;
        if (n == 0) {
            return;
        } else {
            name = n + "";
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (a[i][j].getText().equals(name)) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (a[i][j].getText().equals("")) {
                    x2 = i;
                    y2 = j;
                    break;
                }
            }
        }
        if (check(x, y, x2, y2)) {
            String temp = a[x][y].getText();
            a[x][y].setText(a[x2][y2].getText());
            a[x2][y2].setText(temp);
        } else {
        }
    }

    boolean check(int x, int y, int x2, int y2) {
        if (x == x2 && y == y2 - 1) {
            return true;
        }
        if (x == x2 && y == y2 + 1) {
            return true;
        }
        if (x == x2 + 1 && y == y2) {
            return true;
        }
        if (x == x2 - 1 && y == y2) {
            return true;
        }
        return false;
    }

    boolean end() {
        for (int i = 0; i < length * length - 1; i++) {
            if (!a[i / length][i % length].getText().equals((i + 1) + "")) {
                return false;
            }
        }
        return true;
    }
}
