package org.example.dao;

import org.example.connexion.ConnectionUtil;
import org.example.model.Contact;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ContactDao {

    private Connection con;

    private PreparedStatement ps;

    public int addContact(Contact contact) throws SQLException {

        con = ConnectionUtil.getConnection();
        ps = con.prepareStatement("INSERT INTO `contact` (`name`, `number`) VALUES (?, ?) ");
        ps.setString(1, contact.getName());
        ps.setString(2, contact.getNumber());
        int n = ps.executeUpdate();
        con.close();
        return n;

    }

    public void deleteContact(Contact contact) throws SQLException {

        con = ConnectionUtil.getConnection();
        ps = con.prepareStatement("DELETE FROM `contact` WHERE id = ?");
        ps.setInt(1, contact.getId());
        ps.executeUpdate();
        con.close();
    }

    public int updateContact(Contact contact) throws SQLException {

        con = ConnectionUtil.getConnection();
        ps = con.prepareStatement("UPDATE `contact` SET name = ?, number = ? WHERE id = ?");
        ps.setString(1, contact.getName());
        ps.setString(2, contact.getNumber());
        ps.setInt(3, contact.getId());
        ps.executeUpdate();
        int n = ps.executeUpdate();
        con.close();
        return n;

    }

    public List<Contact> getAllContacts(Contact contact) throws  SQLException {
        List<Contact> contactList = new ArrayList<>();
        con = ConnectionUtil.getConnection();
        ps = con.prepareStatement("SELECT * FROM contact ");
        ps.executeQuery();
        con.close();
        return contactList;

    }

    public int getContactId(int id) throws SQLException {
        Contact contact = new Contact();
        con = ConnectionUtil.getConnection();
        ps = con.prepareStatement("SELECT * FROM `contact` (`id`, `name`, `number`)  VALUES (?, ?)" + id);
        ps.setString(1, contact.getName());
        ps.setString(2, contact.getNumber());
        int n = ps.executeUpdate();
        con.close();
        return n;

    }

    public Contact searchContact(int id) {

        con = ConnectionUtil.getConnection();
        try {
            ps = con.prepareStatement("SELECT * FROM `contact` WHERE id=?");
            ps.setInt(1, id);

            ResultSet result = ps.executeQuery();
            Contact contact = null;
            if (result.first()) {
                contact = new Contact();
                contact.setId(result.getInt("id"));
                contact.setName(result.getString("Name"));
                contact.setNumber(result.getString("Number"));
                System.out.println(contact);
            }
            con.close();
            return contact;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public void loadData(DefaultTableModel tableModel) {

        try (Connection conn = ConnectionUtil.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("select * from Contact");
            ResultSetMetaData metaData = rs.getMetaData();

            // Names of columns
            Vector<String> columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }

            // Data of the table
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int i = 1; i <= columnCount; i++) {
                    vector.add(rs.getObject(i));
                }
                data.add(vector);
            }

            tableModel.setDataVector(data, columnNames);
        } catch (Exception e) {

        }
    }
}
