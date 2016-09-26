/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author sonvu
 */
public class dataAccess {

    public Connection conn = null;

    public dataAccess() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/PRJ321DB?useSSL=false";
        conn = DriverManager.getConnection(url, "sa", "123456");
        System.out.println(conn);
    }

    //clode dbi connection
    public void close() throws Exception {
        if (conn != null) {
            conn.close();
        }
    }

    public static void main(String[] args) throws Exception {
        dataAccess da = new dataAccess();
        //System.out.println(da.checkAcc("admin", "admin"));
        
    }
    
    //insertCategory
    public int insertCategory(String id, String categoryName) throws Exception {
        String insert = "INSERT INTO PRJ321DB_LAB5.Categories VALUES(?,?);";
        PreparedStatement ps = conn.prepareStatement(insert);
        ps.setString(1, id);
        ps.setString(2, categoryName);
        return ps.executeUpdate();
    }

    //insertTransaction
    public int insertTransaction(String tx_id, String acc_id, String amount, String desc) throws Exception {
        String sqlInsert = "INSERT INTO PRJ321DB.tx VALUES (?,?,?,?);";
        PreparedStatement ps = conn.prepareStatement(sqlInsert);
        ps.setString(1, tx_id);
        ps.setString(2, acc_id);
        ps.setString(3, amount);
        ps.setString(4, desc);
        return ps.executeUpdate();
    }

    //insertHistory
    public int insertHistory(String name, String start, String end) throws Exception {
        String sqlInsert = "INSERT INTO PRJ321DB.loginHistory VALUES (?, ?, ?);";
        PreparedStatement ps = conn.prepareStatement(sqlInsert);
        ps.setString(1, name);
        ps.setString(2, start);
        ps.setString(3, end);
        return ps.executeUpdate();
    }

    //updateCategory
    public int updateCategory(String newId, String newCategoryName, String oldId) throws Exception {
        String sqlUpdate = "UPDATE PRJ321DB_LAB5.Categories SET id= ?, CategoryName= ? "
                + "WHERE id= ?;";
        PreparedStatement ps = conn.prepareStatement(sqlUpdate);
        ps.setString(1, newId);
        ps.setString(2, newCategoryName);
        ps.setString(3, oldId);
        return ps.executeUpdate();
    }

    //checkAccount
    public boolean checkAcc(String username, String password) throws Exception {
        PreparedStatement ps = null;
        try {
            String sql1 = "SELECT * FROM PRJ321DB_LAB5.Logins WHERE username = '" + username + "' "
                    + "AND password = '" + password + "';";
            ps = conn.prepareStatement(sql1);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    //selectCategoriesName
    public String selectName(String oldId) throws Exception{
        String name = "";
        String sqlSelectName = "Select * from PRJ321DB_LAB5.Categories where ID = ?;";
        PreparedStatement ps = conn.prepareStatement(sqlSelectName);
        ps.setString(1, oldId);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            name = rs.getString(2);
        }
        rs.close();
        return name;
    }
    
    //deleteCategories
    public int deleteCategories(String id) throws Exception{
        String delete = "DELETE FROM PRJ321DB_LAB5.Categories WHERE ID = ?;";
        PreparedStatement ps = conn.prepareStatement(delete);
        ps.setString(1, id);
        return ps.executeUpdate();
        
    }
    
    //deleteProducts
    public int deleteProducts(String id) throws Exception {
        String delete = "DELETE FROM PRJ321DB_LAB5.Products WHERE ID = ?;";
        PreparedStatement ps = conn.prepareStatement(delete);
        ps.setString(1, id);
        return ps.executeUpdate();
    }

    //insertProducts
    public int insertProducts(String id, String categoryId, String productName, String quantity, String price) throws Exception {
        String insert = "INSERT INTO PRJ321DB_LAB5.Products VALUES(?,?,?,?,?);";
        PreparedStatement ps = conn.prepareStatement(insert);
        ps.setString(1, id);
        ps.setString(2, categoryId);
        ps.setString(3, productName);
        ps.setString(4, quantity);
        ps.setString(5, price);
        return ps.executeUpdate();
    }
    
    //updateProducts
    public int updateProduct(String newId, String newProductName, String newQuatity, String newPrice ,String oldId) throws Exception {
        String sqlUpdate = "UPDATE PRJ321DB_LAB5.Products SET ID= ?, productName= ? , quantity= ? , pricing= ? WHERE ID= ?;";
        PreparedStatement ps = conn.prepareStatement(sqlUpdate);
        ps.setString(1, newId);
        ps.setString(2, newProductName);
        ps.setString(3, newQuatity);
        ps.setString(4, newPrice);
        ps.setString(5, oldId);
        return ps.executeUpdate();
    }
}
