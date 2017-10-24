package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;


public class Database {
    
    private static Database data;
    
    public Connection con;
    public Statement st;
    public ResultSet rs;
    private Database() throws SQLException
    {
        connect();
        setUpRegisterTable();
        setUpEgamingTable();
    }
    
    public static Database getInstance() throws SQLException
    {
        if(data == null)
        {
            data = new Database();
        }
        return data;
    }        
    
    public void connect() throws SQLException
    {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration?useSSL=false","root","TeamRegistration"); 
    }
    
     void setUpRegisterTable() {
        String TABLE_NAME = "REGISTER";
        try {
            st = con.createStatement();

            DatabaseMetaData dbm = con.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
            } else {
                st.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	admissionNumber varchar(200) primary key,\n"
                        + "	name varchar(200),\n"
                        + "     registrationNumber varchar(100),\n"
                        + "     receiptNumber varchar(100),\n"
                        + "     amount int,\n"
                        + "	branch varchar(200),\n"
                        + "	emailId varchar(100),\n"
                        + "     contact varchar(100),\n"
                        + "     choice varchar(100),\n"
                        + "     size varchar(100),\n"
                        + "     member varchar(100),\n"
                        + "     date timestamp\n"
                        + " )");
                
            }
        } catch (SQLException e) {
            System.out.println("*");
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
    }
     
    void setUpEgamingTable() {
        String TABLE_NAME = "GAMING";
        try {
            st = con.createStatement();

            DatabaseMetaData dbm = con.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
            } else {
                st.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	admissionNumber varchar(200) primary key,\n"
                        + "	name varchar(200),\n"
                        + "     registrationNumber varchar(100),\n"
                        + "     receiptNumber varchar(100),\n"
                        + "     amount int,\n"
                        + "	branch varchar(200),\n"
                        + "	emailId varchar(100),\n"
                        + "     contact varchar(100),\n"
                        + "     choice varchar(100),\n"
                        + "     member varchar(100),\n"
                        + "     date timestamp\n"
                        + " )");
                
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
    }

}