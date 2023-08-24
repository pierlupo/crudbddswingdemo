package org.example.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteDialog extends JDialog {

    private JPanel contentPanel;

    private JTextField  idSearch;

    private JButton buttonOk, buttonCancel;


    public DeleteDialog() {

        contentPanel = new JPanel();
        setTitle("Update Contact");
        setBounds(500, 500, 400, 250);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        idSearch = new JTextField();
        idSearch.setBounds(80, 20, 80, 20);
        contentPanel.add(idSearch);
        idSearch.setColumns(10);

        JLabel lblSearch = new JLabel("search: ");
        lblSearch.setBounds(10, 20, 50, 15);
        contentPanel.add(lblSearch);
        JPanel jPanelButton = new JPanel();

        jPanelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(jPanelButton, BorderLayout.SOUTH);

        buttonOk = new JButton("OK");
        jPanelButton.add(buttonOk);

        buttonCancel = new JButton("Cancel");
        jPanelButton.add(buttonCancel);

        buttonCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });



    }
}
