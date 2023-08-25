package org.example.view;

import org.example.dao.ContactDao;
import org.example.model.Contact;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;


public class SelectDialog extends JDialog {
    private JFrame jFrame;

    JTable jTable;

//    private static String[] columnNames = {"Id","Name","Number"};
//    private DefaultTableModel model = new DefaultTableModel(null, columnNames);

    SelectDialog() throws SQLException {

        jFrame = new JFrame();

        jFrame.setTitle("Contact table");

        Contact contact = new Contact();
        ContactDao contactDao = new ContactDao();

        String[][] data = {
                {"1","toto", "123"},
                {"2","titi", "456"}
        };

//        List<Contact> data = contactDao.getAllContacts(contact);

         String[] columnNames = {"id","Name", "Number"};

//        DefaultTableModel contactTable = new DefaultTableModel();
//        contactTable.addColumn("ID");
//        contactTable.addColumn("Name");
//        contactTable.addColumn("Number");
//
//        jTable = new JTable(contactTable, (TableColumnModel) data);

//        data.forEach(c ->{
//            model.addRow(new Object[]{c.getId(),c.getName(),c.getNumber()});
//        });

        jTable = new JTable(data, columnNames);
        jTable.setBounds(30, 40, 200, 300);


        JScrollPane sp = new JScrollPane(jTable);
        jFrame.add(sp);
        jFrame.setSize(500, 200);
        jFrame.setVisible(true);
    }
}