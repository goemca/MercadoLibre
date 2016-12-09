package Logic;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
/**
 * 
 * @author Gonzalo
 */
public class Autenticador extends Authenticator
{
    private String SMTP_AUTH_USER = "";
    private String SMTP_AUTH_PWD = "";
    
    public Autenticador() 
    {
    }
    
    public Autenticador(String user , String pass) 
    {
        this.SMTP_AUTH_USER = user;
        this.SMTP_AUTH_PWD = pass;
    }
    
    @Override
    public PasswordAuthentication getPasswordAuthentication() 
    {
        return new PasswordAuthentication(this.SMTP_AUTH_USER, this.SMTP_AUTH_PWD);
    }
    
}//Fin de la Clase Authenticador
