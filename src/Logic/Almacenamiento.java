/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gcano
 */
public class Almacenamiento 
{
    Vector principal =  new Vector();
    
    
    public void guardar(ChequeoMails cm)
    {
        this.principal.addElement(cm);
    }
    
    public DefaultTableModel listaMail()
    {
        Vector cabecera =  new Vector();
        cabecera.addElement("Nro Mail");
        cabecera.addElement("Fecha");
        cabecera.addElement("De");
        cabecera.addElement("Asunto");
        cabecera.addElement("Mensaje");
        DefaultTableModel tabla = new DefaultTableModel(cabecera,0);
        try
        {
           FileReader fr =  new FileReader("Mails.txt");
           BufferedReader br = new BufferedReader(fr);
           String aux;
           while((aux = br.readLine())!= null)
           {
               StringTokenizer dato = new StringTokenizer(aux,"|");
               Vector x = new Vector();
               while(dato.hasMoreElements())
               {
                   x.addElement(dato.nextToken());
               }
               tabla.addRow(x);
           }
        }
        catch (Exception ex)
        {
           JOptionPane.showMessageDialog(null, ex);
        }
        
        return tabla;
    }

}//Fin de la Clase Almacenamiento
