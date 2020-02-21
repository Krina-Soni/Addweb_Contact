package Com.Addweb.Pages;

import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;
import javax.mail.*;
import javax.mail.internet.*;
import com.sun.mail.smtp.*;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class MGSendSimpleSMTP {

    //   public static void main(String args[]) throws Exception {

//        Properties props = System.getProperties();
//        props.put("mail.smtps.host", "smtp.mailgun.org");
//        props.put("mail.smtps.auth", "true");
//
//        Session session = Session.getInstance(props, null);
//        Message msg = new MimeMessage(session);
//        msg.setFrom(new InternetAddress("smtp@addwebsolution.com"));
//
//        InternetAddress[] addrs = InternetAddress.parse("krina.addweb@gmail.com", false);
//        msg.setRecipients(Message.RecipientType.TO, addrs);
//
//        msg.setSubject("Hello");
//        msg.setText("Testing some Mailgun awesomness");
//        msg.setSentDate(new Date());
//
//        SMTPTransport t =
//                (SMTPTransport) session.getTransport("smtps");
//        t.connect("smtp.mailgun.org", "coffee@addwebsolution.com", "Addweb@15819");
//        t.sendMessage(msg, msg.getAllRecipients());
//
//        System.out.println("Response: " + t.getLastServerResponse());
//
//        t.close();
//        final String username = "smtp@addwebsolution.com";
//        final String password = "Addweb@123";
//
//        Properties prop = new Properties();
//        prop.put("mail.smtp.host", "smtp.gmail.com");
//        prop.put("mail.smtp.port", "587");
//        prop.put("mail.smtp.auth", "true");
//        prop.put("mail.smtp.starttls.enable", "true"); //TLS
//
//        Session session = Session.getInstance(prop,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, password);
//                    }
//                });
//
//        try {
//
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("smtp@addwebsolution.com"));
//            message.setRecipients(
//                    Message.RecipientType.TO,
//                    InternetAddress.parse("coffee@addwebsolution.com, krina.addweb@gmail.com")
//            );
//            message.setSubject("Testing Gmail TLS");
//            message.setText("Dear Mail Crawler,"
//                    + "\n\n Please do not spam my email!");
//
//            Transport.send(message);
//
//            System.out.println("Done");
//
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }

}



