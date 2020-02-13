package Instagual;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

public class Correo_electronico {
	public Recuperar_cuenta _recuperar_cuenta;
	public Registrado_con_exitoELIMINAR _registrado_con_exito;
	public Registrarse _registrarse;
	public iCorreo_electronico _iCorreo_electronico;

	// for example, smtp.mailgun.org
    private static final String SMTP_SERVER = "smtp.gmail.com";
    private static final String USERNAME = "instagualmessenger@gmail.com";
    private static final String PASSWORD = "Instagual1Instagual";

    private static final String EMAIL_FROM = "instagualmessenger@gmail.com";
    private static String EMAIL_TO = "correo de destino";
    private static final String EMAIL_TO_CC = "";

    private static String EMAIL_SUBJECT = "Asunto";
    private static String EMAIL_TEXT = "Aqui se insertaria el enlace";
    
    public Correo_electronico(String email, String asunto, String enlace) {
    	this.EMAIL_TO = email;
    	this.EMAIL_SUBJECT = asunto;
    	this.EMAIL_TEXT = enlace;
    }
    
    
    public void mandarEmail() {
    	
    	Properties prop = System.getProperties();
        prop.put("mail.smtp.host", SMTP_SERVER); //optional, defined in SMTPTransport
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "587"); // default port 25
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(prop, null);
        Message msg = new MimeMessage(session);

        try {
		
			// from
            msg.setFrom(new InternetAddress(EMAIL_FROM));

			// to 
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(EMAIL_TO, false));

			// cc
            msg.setRecipients(Message.RecipientType.CC,
                    InternetAddress.parse(EMAIL_TO_CC, false));

			// subject
            msg.setSubject(EMAIL_SUBJECT);
			
			// content 
            msg.setText(EMAIL_TEXT);
			
            msg.setSentDate(new Date());

			// Get SMTPTransport
            SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
			
			// connect
            t.connect(SMTP_SERVER, USERNAME, PASSWORD);
			
			// send
            t.sendMessage(msg, msg.getAllRecipients());

            System.out.println("Response: " + t.getLastServerResponse());

            t.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        
    }
}