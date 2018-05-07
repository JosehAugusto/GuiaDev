package src;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class Eos{
	private String email;
	
	public Eos(String email) {
		this.email = email;
	}
	
      public void envia(String emailRecebe, String assunto, String mensagem, String senha) {
            Properties props = new Properties();
            /** Parâmetros de conexão com servidor Gmail */
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
 
            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   return new PasswordAuthentication(email, senha);
                             }
                        });
 
            /** Ativa Debug para sessão */
            session.setDebug(true);
 
            try {
 
                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress(email)); //Remetente
 
                  Address[] toUser = InternetAddress //Destinatário(s)
                             .parse(emailRecebe);  
 
                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject(assunto);//Assunto
                  message.setText(mensagem);
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);
 
             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
      }
}