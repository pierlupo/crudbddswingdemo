package org.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class SelectDialog extends JDialog {

    private JPanel panel1;

    private JTable maTable;

     SelectDialog() {

         panel1 = new JPanel();
         DefaultTableModel maTable = new DefaultTableModel();


         setBounds(500, 500, 400, 250);

     }
}
