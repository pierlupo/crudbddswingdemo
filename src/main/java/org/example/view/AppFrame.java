package org.example.view;

import lombok.Data;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@Data
public class AppFrame extends JDialog {

    private JPanel contentPanel;

    private JButton insertButton, updateButton, deleteButton, selectButton;

    public AppFrame() {

        contentPanel = new JPanel();
        setTitle("Main Frame");
        setBounds(500, 500, 400, 250);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(10, 10,10,10));
        getContentPane().add(contentPanel, BorderLayout.NORTH);
        contentPanel.setLayout(null);


        JPanel jPanelButton = new JPanel();
        JPanel jPanelSelectButton = new JPanel();
        getContentPane().add(jPanelButton, BorderLayout.NORTH);
        getContentPane().add(jPanelSelectButton, BorderLayout.CENTER);


        insertButton = new JButton("Insert");
        jPanelButton.add(insertButton);

        insertButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    InsertDialog dialog = new InsertDialog();
                    dialog.setModalityType(ModalityType.APPLICATION_MODAL);
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });

        updateButton = new JButton("update");
        jPanelButton.add(updateButton);

        updateButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UpdateDialog dialog = new UpdateDialog();
                    dialog.setModalityType(ModalityType.APPLICATION_MODAL);
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        deleteButton = new JButton("delete");
        jPanelButton.add(deleteButton);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DeleteDialog dialog = new DeleteDialog();
                    dialog.setModalityType(ModalityType.APPLICATION_MODAL);
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        selectButton = new JButton("select");
        jPanelSelectButton.add(selectButton);

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SelectDialog dialog = new SelectDialog();
                    dialog.setModalityType(ModalityType.APPLICATION_MODAL);
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    AppFrame dialog = new AppFrame();
//                    dialog.setTitle("Main Frame");
//                    dialog.setLocationRelativeTo(null);
//                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//                    dialog.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
}
