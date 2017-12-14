package com.company;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMsg {
    Properties properties = new Properties( );
    public void setProperties(){
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.debug", "true");
        properties.put("mail.store.protocol", "pop3");
        properties.put("mail.transport.protocol", "smtp");
    }
    public void setServer(String server){
        properties.put("mail.smtp.host", server);
    }
    private Session SessionCheck(String from,String password)
    {
        Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication(from,password);
                    }
                });
        return  session;
    }
    public void Message(String to,String header,String text, String from,String password){
        try {
            MimeMessage message = new MimeMessage(SessionCheck(from,password));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(header);
            message.setText(text);

            Transport.send(message);
            System.out.println("I can!");
        } catch (MessagingException e) {throw new RuntimeException(e);}
    }
}
