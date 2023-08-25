package org.example.view;

import org.example.dao.ContactDao;
import org.example.model.Contact;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UpdateDialog extends JDialog {

    private JPanel contentPanel;

    private JTextField txtName, txtNumber, idSearch;

    public UpdateDialog() {

        contentPanel = new JPanel();
        setTitle("Update Contact");
        setBounds(500, 500, 400, 250);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        idSearch = new JTextField();
        idSearch.setBounds(80, 10, 80, 20);
        contentPanel.add(idSearch);
        idSearch.setColumns(10);

        txtName = new JTextField();
        txtName.setBounds(80, 40, 80, 20);
        contentPanel.add(txtName);
        txtName.setColumns(10);

        txtNumber = new JTextField();
        txtNumber.setBounds(80, 70, 80, 20);
        contentPanel.add(txtNumber);
        txtNumber.setColumns(10);

        JLabel lblName = new JLabel("name: ");
        lblName.setBounds(10, 40, 50, 15);
        contentPanel.add(lblName);

        JLabel lblNum = new JLabel("number: ");
        lblNum.setBounds(10, 70, 50, 15);
        contentPanel.add(lblNum);

        JLabel lblSearch = new JLabel("search: ");
        lblSearch.setBounds(10, 10, 50, 15);
        contentPanel.add(lblSearch);

        JPanel jPanelButton = new JPanel();
        jPanelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(jPanelButton, BorderLayout.SOUTH);

        JButton buttonOk = new JButton("OK");


        buttonOk.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(idSearch.getText()));
                contact.setName(txtName.getText());
                contact.setNumber(txtNumber.getText());
                ContactDao contactDao = new ContactDao();
                try {
                    contactDao.updateContact(contact);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                if (contact.getId()>0) {
                    JOptionPane
                            .showConfirmDialog(null, "update successfull");
                } else {
                    JOptionPane
                            .showConfirmDialog(null, "Error");
                }
                dispose();
            }


        });

        jPanelButton.add(buttonOk);

        JButton buttonCancel = new JButton("Cancel");
        jPanelButton.add(buttonCancel);

        buttonCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Contact contact = null;
                ContactDao contactDao = new ContactDao();
                try {
                    contactDao.updateContact(contact);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
            }

        });

    }
}