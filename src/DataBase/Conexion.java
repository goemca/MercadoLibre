/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import com.mysql.jdbc.Connection;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author gcano
 */
public class Conexion 
{
    private static Connection conexion;
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String user="root";//usuario del servidor mysql
    private static final String password="1234";//contraseña del servidor mysql
    private static final String url = "jdbc:mysql://localhost:3306/mails_db";
    public Statement sentencia;
   
    public Conexion() 
    {
        conexion = null;
        try
        {
            Class.forName(driver);
            conexion = (Connection) DriverManager.getConnection(url, user,password);
            sentencia = conexion.createStatement();
            if(conexion !=  null)
            {
                JOptionPane.showMessageDialog(null, "Conexion a Date Base exitosa...","\n¡Aviso!", WIDTH);;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No se puedo establecer la conexion","\n¡Aviso!", JOptionPane.WARNING_MESSAGE);;
            }
        }
        catch (Exception e)
        {
        }
    }

    public Connection getConexion() 
    {
        return conexion;
    }
    
    public void desconectar()
    {
        conexion = null;
        if(conexion == null)
        {
            JOptionPane.showConfirmDialog(null, "Se finalizo la conexion");
        }
    }
}//Fin de la Clase Conexion
