/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import DataBase.Conexion;
import java.awt.HeadlessException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Properties;
import javax.mail.AuthenticationFailedException;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.swing.JOptionPane;


/**
 *
 * @author Gonzalo
 */
public class ChequeoMails 
{
   public static String Username;
   public static String PassWord;
   public static File f;
   public static FileWriter w;
   public static BufferedWriter bw;
   public static PrintWriter wr;
   public static Conexion cadena;
   public static Connection reg;
   public static Message fecha;
   public static Message de;
   public static Message asunto;
   
   @SuppressWarnings("empty-statement")
   public static void check(String host, String storeType, String user,String password) 
   {
       try 
       {
           Properties props = new Properties();
           props.put("mail.smtp.host", "smtp.gmail.com");
           props.put("mail.smtp.starttls.enable", "true");
           props.put("mail.smtp.auth", "true");
           props.put("mail.smtp.user", "usuario");
           props.put("mail.smtp.port", 25);
           Autenticador auth = new Autenticador(getUsername(),getPassWord() );
           Session emailSession = Session.getDefaultInstance(props, auth);
           emailSession.setDebug(false);

           //create the POP3 store object and connect with the pop server
           Store store = emailSession.getStore("pop3s");
           try
           {
               store.connect(host, user, password);
           }
           catch(AuthenticationFailedException ex)
           {
               JOptionPane.showMessageDialog(null,ex+"\nLa aplicacion finalizara"+"\nintente nuevamente","\n Error de Aunteticacion ",JOptionPane.WARNING_MESSAGE);;
               System.exit(0);
           }             

           //create the folder object and open it
           Folder emailFolder = store.getFolder("INBOX");
           emailFolder.open(Folder.READ_ONLY);
           
           // retrieve the messages from the folder in an array and print it
           Message[] messages = emailFolder.getMessages();
           f = new File("Mails.txt");
           try
           {
               w = new FileWriter(f);
               bw = new BufferedWriter(w);
               wr = new PrintWriter(bw);
               
               for (int i = 0, n = messages.length; i < n; i++)
               {
                   Message message = messages[i];
                   Multipart mp = (Multipart) message.getContent();
                   BodyPart bp = mp.getBodyPart(0);
                   String sentencia = (String)(bp.getContent());
                   if((message.getSubject().equalsIgnoreCase("DevOps"))||(sentencia.contains("DevOps")))
                   {                                             
                       wr.write("");
                       wr.write(""+ (i + 1));
                       wr.append(" | " + message.getSentDate());
                       wr.append(" | " + message.getFrom()[0]);
                       wr.append(" | " + message.getSubject());
                       wr.append(" | " + bp.getContent());
                   }                   
               }
               wr.close();
               bw.close();
           }
           catch(IOException e){};
           
           //close the store and folder objects
           emailFolder.close(false);
           store.close();
       }
       catch (NoSuchProviderException e) 
       {
       } 
       catch (MessagingException | HeadlessException e) 
       {
       }
   }
   
    
   public void setUsername(char[] value)
   {
       ChequeoMails.Username = new String(value);
   }
   
   public void setPassWord(char[] value)
   {
       ChequeoMails.PassWord = new String(value);
   }
   
   public static String getUsername()
   {
       return Username;
   }
   
   public static String getPassWord()
   {
       return PassWord;
   }
   
   public static void validar()
   {
       String host = "pop.gmail.com";
       String mailStoreType = "pop3";
       String username = getUsername();
       String password = getPassWord();
       check(host, mailStoreType, username, password);//llamada al metodo check con las validaciones
    }
       
}//Fin de la Clase ChequeoMail
