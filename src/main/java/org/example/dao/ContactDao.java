package org.example.dao;

import org.example.connexion.ConnectionUtil;
import org.example.model.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public int deleteContact(Contact contact) throws SQLException {

        con = ConnectionUtil.getConnection();
        ps = con.prepareStatement("DELETE FROM `contact` (`name`, `number`) WHERE id = ?");
        ps.setString(1, contact.getName());
        ps.setString(2, contact.getNumber());
        int n = ps.executeUpdate();
        return n;

    }

    public boolean updateContact(Contact contact) throws SQLException {

        con = ConnectionUtil.getConnection();
        ps = con.prepareStatement("UPDATE `contact` SET name = ?, number = ? WHERE id = ?");
        ps.setString(1, contact.getName());
        ps.setString(2, contact.getNumber());
        ps.executeUpdate();
        return true;

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

    public int getContactId(Contact contact) throws SQLException {
        con = ConnectionUtil.getConnection();
        ps = con.prepareStatement("SELECT * FROM `contact` (`name`, `number`)  VALUES (?, ?)");
        ps.setString(1, contact.getName());
        ps.setString(2, contact.getNumber());
        int n = ps.executeUpdate();
        return n;

    }



}
