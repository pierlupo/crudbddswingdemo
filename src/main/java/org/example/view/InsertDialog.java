package org.example.view;

import org.example.dao.ContactDao;
import org.example.model.Contact;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class InsertDialog extends JDialog {

    private JPanel contentPanel;

    private JTextField txtName, txtNumber;

    public InsertDialog() {

        contentPanel = new JPanel();
        setTitle("Insertion Contact");
        setBounds(500, 500, 400, 250);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(10, 10,10,10));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        txtName = new JTextField();
        txtName.setBounds(80,20,80,20);
        contentPanel.add(txtName);
        txtName.setColumns(10);

        txtNumber = new JTextField();
        txtNumber.setBounds(80,50,80,20);
        contentPanel.add(txtNumber);
        txtNumber.setColumns(10);

        JLabel lblName = new JLabel("name: ");
        lblName.setBounds(10,20,50,15);
        contentPanel.add(lblName);

        JLabel lblNum = new JLabel("number: ");
        lblNum.setBounds(10,50,50,15);
        contentPanel.add(lblNum);

        JPanel jPanelButton = new JPanel();
        jPanelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        //this.add(Box.createHorizontalStrut(20));
        getContentPane().add(jPanelButton, BorderLayout.SOUTH);

        JButton buttonOk = new JButton("OK");



        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contact contact = new Contact();
                contact.setName(txtName.getText());
                contact.setNumber(txtNumber.getText());
                ContactDao contactDao = new ContactDao();
                int count = 0;
                try {
                    count = contactDao.addContact(contact);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                if(count>0){
                    JOptionPane
                            .showConfirmDialog(null, "Successfully added");
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
                dispose();
            }
        });

    }



    public static void main(String[] args) {

        InsertDialog dialog = new InsertDialog();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);

    }

}
