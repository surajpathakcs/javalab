import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSending {
    public static void main(String[] args) {
        // Your email and app password
        final String senderEmail = "jyotibhadari0779@gmail.com";
        final String appPassword = "vnweoaiewcdzrgiwo";

        // Receiver's email
        String recipient = "jyotibhandari1020@gmail.com";

        // SMTP server properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); 

        // Authenticator for login
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, appPassword);
            }
        });

        try {
            // Create email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(recipient)
            );
            message.setSubject("Java mail Lab");
            message.setText("I am jyoti . Nice to meet you.");

            // Send the message
            Transport.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Failed to send email.");
        }
    }
}
