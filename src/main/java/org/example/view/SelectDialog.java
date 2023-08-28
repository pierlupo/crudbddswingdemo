package org.example.view;
import org.example.dao.ContactDao;
import org.example.model.Contact;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;


public class SelectDialog extends JDialog {

    private JFrame jFrame;

    private JPanel contentPanel, jPanelButton;

    private JTable jTable;

    private JButton buttonOk, buttonCancel;

    private String[] columnNames = {"Id","Name","Number"};

    private DefaultTableModel model;

    SelectDialog() throws SQLException {

        contentPanel = new JPanel();

        Contact contact = new Contact();

        ContactDao contactDao = new ContactDao();

        jFrame = new JFrame();
        jFrame.setTitle("Contact table");

        model = new DefaultTableModel(null, columnNames);

        List<Contact> data = contactDao.getAllContacts(contact);

        data.forEach(c ->{
            model.addRow(new Object[]{c.getId(),c.getName(),c.getNumber()});
        });

        contactDao.loadData(model);

        jTable = new JTable(model);
        jTable.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jTable);
        jFrame.add(sp);
        jFrame.setSize(500, 400);
        jFrame.setVisible(true);

        jPanelButton = new JPanel();
        jPanelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(jPanelButton, BorderLayout.SOUTH);

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
