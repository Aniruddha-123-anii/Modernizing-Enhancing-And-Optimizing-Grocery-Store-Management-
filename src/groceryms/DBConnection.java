/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package groceryms;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author aniruddha
 */
public class DBConnection {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("org.postgresql.Driver");
            con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/grocery_management_system","postgres","system");
        }catch(Exception e){
            e.printStackTrace();;
        }
        return con;
    }
    public static void main(String args[]) throws Exception {
        // TODO code application logic here
    }
}
