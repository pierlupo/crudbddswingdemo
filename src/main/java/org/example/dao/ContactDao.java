package org.example.dao;

import org.example.connexion.ConnectionUtil;
import org.example.model.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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


}
