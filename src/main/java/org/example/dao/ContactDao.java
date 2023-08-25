package org.example.dao;

import org.example.connexion.ConnectionUtil;
import org.example.model.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactDao {

    private Connection con;

    private PreparedStatement ps;

    public int addContact(Contact contact) throws SQLException {

        con = ConnectionUtil.getConnection();
        ps = con.prepareStatement("INSERT INTO `contact` (`name`, `number`) VALUES (?, ?) ");
        ps.setString(1, contact.getName());
        ps.setString(2, contact.getNumber());
        int n = ps.executeUpdate();
        return n;

    }

    public void deleteContact(Contact contact) throws SQLException {

        con = ConnectionUtil.getConnection();
        ps = con.prepareStatement("DELETE FROM `contact` WHERE id = ?");
        ps.setInt(1, contact.getId());
        ps.executeUpdate();
    }

    public int updateContact(Contact contact) throws SQLException {

        con = ConnectionUtil.getConnection();
        ps = con.prepareStatement("UPDATE `contact` SET id = ?, name = ?, number = ? WHERE id = ?");
        ps.setInt(1, contact.getId());
        ps.setString(2, contact.getName());
        ps.setString(3, contact.getNumber());
        ps.executeUpdate();
        int n = ps.executeUpdate();
        return n;

    }

    public List<Contact> getAllContacts(Contact contact) throws  SQLException {
        List<Contact> contacts = new ArrayList<>();
        con = ConnectionUtil.getConnection();
        ps = con.prepareStatement("SELECT * FROM contact (`name`, `number`) VALUES (?, ?)");
        ps.setString(1, contact.getName());
        ps.setString(2, contact.getNumber());
        ps.executeUpdate();
        return contacts;

    }

    public int getContactId(int id) throws SQLException {
        Contact contact = new Contact();
        con = ConnectionUtil.getConnection();
        ps = con.prepareStatement("SELECT * FROM `contact` (`id`, `name`, `number`)  VALUES (?, ?)" + id);
        ps.setString(1, contact.getName());
        ps.setString(2, contact.getNumber());
        int n = ps.executeUpdate();
        return n;

    }

}
